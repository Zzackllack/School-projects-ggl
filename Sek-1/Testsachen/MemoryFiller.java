/*
 * ========================================
 * MEMORY FILLER STRESS TEST WITH GUI
 * ========================================
 *
 * WARNING: This Java program is designed for testing and debugging purposes only.
 * It will attempt to allocate up to 64GB of memory, which may cause your system to
 * become unresponsive or crash. Do not run this program on a system with insufficient
 * resources or without fully understanding the risks.
 *
 * Recommended JVM argument (if you have 64GB available):
 *     -Xmx64g
 *
 * USE AT YOUR OWN RISK.
 */

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import javax.swing.*;

public class MemoryFiller {

    // Total target memory: 64GB in bytes
    private static final long TARGET_MEMORY_BYTES = 64L * 1024 * 1024 * 1024;
    // Block size per allocation: 1MB (in bytes)
    private static final int BLOCK_SIZE_BYTES = 1024 * 1024;
    // Number of concurrent threads for allocation
    private static final int ALLOCATION_THREADS = Runtime.getRuntime().availableProcessors();

    // Thread-safe list to hold references to allocated blocks (prevents GC)
    private final List<byte[]> allocatedBlocks = Collections.synchronizedList(new ArrayList<byte[]>());
    // Atomic counter to track total allocated bytes
    private final AtomicLong allocatedBytes = new AtomicLong(0);
    // Reference to the GUI (if used)
    private MemoryFillerGUI gui;

    /**
     * Starts the memory allocation process.
     */
    public void startMemoryAllocation() {
        ExecutorService allocationExecutor = Executors.newFixedThreadPool(ALLOCATION_THREADS);
        ScheduledExecutorService monitorExecutor = Executors.newSingleThreadScheduledExecutor();

        // Start a monitor to report progress every 5 seconds
        monitorExecutor.scheduleAtFixedRate(new MemoryMonitor(), 0, 5, TimeUnit.SECONDS);

        System.out.println("Starting memory allocation using " + ALLOCATION_THREADS + " threads.");
        System.out.println("Target memory to allocate: " + TARGET_MEMORY_BYTES + " bytes.");

        // Submit allocation tasks to the executor
        for (int i = 0; i < ALLOCATION_THREADS; i++) {
            allocationExecutor.submit(new MemoryAllocator());
        }

        // Shutdown the allocation executor after tasks complete or an error occurs
        allocationExecutor.shutdown();
        try {
            // Wait indefinitely until all allocation tasks are complete.
            allocationExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Allocation interrupted: " + e.getMessage());
        } finally {
            monitorExecutor.shutdownNow();
        }

        System.out.println("Memory allocation process terminated.");
    }

    /**
     * Runnable that continuously allocates memory blocks until the target is reached.
     */
    private class MemoryAllocator implements Runnable {
        @Override
        public void run() {
            while (allocatedBytes.get() < TARGET_MEMORY_BYTES) {
                try {
                    // Allocate a new block of memory (1MB)
                    byte[] block = new byte[BLOCK_SIZE_BYTES];
                    allocatedBlocks.add(block);
                    long total = allocatedBytes.addAndGet(BLOCK_SIZE_BYTES);
                    
                    // Uncomment the next line for detailed per-allocation output (may slow down allocation)
                    // System.out.println(Thread.currentThread().getName() + " allocated block; total = " + total + " bytes.");
                } catch (OutOfMemoryError e) {
                    System.err.println("OutOfMemoryError in " + Thread.currentThread().getName() +
                                       " after allocating " + allocatedBytes.get() + " bytes.");
                    break;
                }
            }
        }
    }

    /**
     * Runnable that monitors and reports the allocated memory periodically.
     */
    private class MemoryMonitor implements Runnable {
        @Override
        public void run() {
            long allocated = allocatedBytes.get();
            double percent = (allocated / (double) TARGET_MEMORY_BYTES) * 100;
            System.out.printf("Memory Monitor: Allocated %d bytes (%.2f%% of target)%n", allocated, percent);
            
            // Update GUI if it exists
            if (gui != null) {
                SwingUtilities.invokeLater(() -> {
                    gui.updateProgress(allocated, percent);
                });
            }
        }
    }

    /**
     * GUI class to display allocation progress.
     */
    private class MemoryFillerGUI extends JFrame {
        private final JProgressBar progressBar;
        private final JLabel statusLabel;
        
        public MemoryFillerGUI() {
            setTitle("Memory Filler Progress");
            setSize(500, 100);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            progressBar = new JProgressBar(0, 100);
            statusLabel = new JLabel("Allocated 0 bytes (0.00% of target)");
            
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(statusLabel, BorderLayout.NORTH);
            getContentPane().add(progressBar, BorderLayout.CENTER);
            
            setVisible(true);
        }
        
        public void updateProgress(long allocated, double percent) {
            progressBar.setValue((int) percent);
            statusLabel.setText("Allocated " + allocated + " bytes (" + String.format("%.2f", percent) + "% of target)");
        }
    }

    /**
     * Main method that shows a GUI warning prompt and, upon confirmation, starts the memory fill process.
     */
    public static void main(String[] args) {
        // Use Swing's event dispatch thread for GUI operations.
        SwingUtilities.invokeLater(() -> {
            // Show a warning confirmation dialog
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "<html><body style='width: 300px;'>"
                  + "WARNING: This program will attempt to allocate 64GB of RAM!<br><br>"
                  + "Running this program may cause your system to become unresponsive, crash, "
                  + "or result in data loss. Only run this in a controlled test environment.<br><br>"
                  + "Do you really want to proceed?</body></html>",
                    "Memory Allocation Warning",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            
            if (choice != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Operation cancelled by the user.");
                System.exit(0);
            }
            
            // Create an instance of MemoryFiller and its GUI
            MemoryFiller filler = new MemoryFiller();
            filler.gui = filler.new MemoryFillerGUI();
            
            // Start the memory allocation process in a separate thread so as not to block the GUI.
            new Thread(filler::startMemoryAllocation).start();
        });
    }
}
