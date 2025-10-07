import tkinter as tk
from tkinter import messagebox, ttk
import time
import math

class TreeNode:
    def __init__(self, label):
        self.label = label
        self.children = []
        self.parent = None

    def add_child(self, node):
        self.children.append(node)
        node.parent = self

    def is_leaf(self):
        return len(self.children) == 0

    def get_depth(self):
        if self.parent is None:
            return 0
        return self.parent.get_depth() + 1

class DataTree:
    def __init__(self):
        self.root = TreeNode("Wurzel")
        self.node_count = 0

    def build_from_text(self, text):
        lines = text.strip().split('\n')
        if not lines or not lines[0].strip():
            raise ValueError("Leere Eingabe")
        
        self.root = TreeNode(lines[0].strip())
        stack = [(self.root, -1)]
        self.node_count = 1
        
        for line in lines[1:]:
            stripped = line.lstrip()
            if not stripped:
                continue
            indent = len(line) - len(stripped)
            node = TreeNode(stripped)
            
            while stack and stack[-1][1] >= indent:
                stack.pop()
            
            if stack:
                stack[-1][0].add_child(node)
            else:
                raise ValueError("Ungültige Einrückung")
            
            stack.append((node, indent))
            self.node_count += 1

    def preorder_traversal(self):
        result = []
        def preorder(node):
            if node:
                result.append(node)
                for child in node.children:
                    preorder(child)
        preorder(self.root)
        return result

    def inorder_traversal(self):
        result = []
        def inorder(node):
            if node:
                if node.children:
                    for i, child in enumerate(node.children):
                        if i == len(node.children) // 2:
                            result.append(node)
                        inorder(child)
                    if len(node.children) % 2 == 0:
                        if node not in result:
                            result.append(node)
                else:
                    result.append(node)
        inorder(self.root)
        return result

    def postorder_traversal(self):
        result = []
        def postorder(node):
            if node:
                for child in node.children:
                    postorder(child)
                result.append(node)
        postorder(self.root)
        return result

    def level_order_traversal(self):
        if not self.root:
            return []
        
        result = []
        queue = [self.root]
        
        while queue:
            node = queue.pop(0)
            result.append(node)
            queue.extend(node.children)
        
        return result

    def get_tree_height(self):
        def height(node):
            if not node or not node.children:
                return 0
            return 1 + max(height(child) for child in node.children)
        return height(self.root)

    def get_tree_width(self):
        def count_nodes_at_level(node, level):
            if level == 0:
                return 1
            count = 0
            for child in node.children:
                count += count_nodes_at_level(child, level - 1)
            return count
        
        height = self.get_tree_height()
        max_width = 0
        for level in range(height + 1):
            width = count_nodes_at_level(self.root, level)
            max_width = max(max_width, width)
        return max_width

class Visualizer:
    def __init__(self, master, tree):
        self.master = master
        self.tree = tree
        self.master.geometry("1200x800")
        
        self.main_frame = tk.Frame(master)
        self.main_frame.pack(fill=tk.BOTH, expand=True)
        
        self.control_frame = tk.Frame(self.main_frame)
        self.control_frame.pack(side=tk.TOP, fill=tk.X, padx=5, pady=5)
        
        self.canvas = tk.Canvas(self.main_frame, width=1200, height=700, bg='white')
        self.canvas.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
        
        self.info_frame = tk.Frame(self.main_frame, width=300, bg='lightgray')
        self.info_frame.pack(side=tk.RIGHT, fill=tk.Y)
        self.info_frame.pack_propagate(False)
        
        self.scale = 1.0
        self.positions = {}
        self.highlighted_nodes = set()
        self.animation_running = False
        self.node_colors = {}
        
        self._setup_controls()
        self._setup_info_panel()
        self._bind_events()
        self._calculate_optimal_layout()
        self.draw_tree()
        self._update_info()

    def _setup_controls(self):
        tk.Label(self.control_frame, text="Traversierung:").pack(side=tk.LEFT, padx=5)
        
        self.preorder_btn = tk.Button(self.control_frame, text="Preorder", 
                                     command=self.animate_preorder, bg='lightgreen')
        self.preorder_btn.pack(side=tk.LEFT, padx=2)
        
        self.inorder_btn = tk.Button(self.control_frame, text="Inorder", 
                                    command=self.animate_inorder, bg='lightblue')
        self.inorder_btn.pack(side=tk.LEFT, padx=2)
        
        self.postorder_btn = tk.Button(self.control_frame, text="Postorder", 
                                      command=self.animate_postorder, bg='lightcoral')
        self.postorder_btn.pack(side=tk.LEFT, padx=2)
        
        self.levelorder_btn = tk.Button(self.control_frame, text="Level Order", 
                                       command=self.animate_levelorder, bg='lightyellow')
        self.levelorder_btn.pack(side=tk.LEFT, padx=2)
        
        tk.Frame(self.control_frame, width=20).pack(side=tk.LEFT)
        
        self.reset_btn = tk.Button(self.control_frame, text="Reset", 
                                  command=self.reset_visualization, bg='lightgray')
        self.reset_btn.pack(side=tk.LEFT, padx=2)
        
        self.export_btn = tk.Button(self.control_frame, text="Export", 
                                   command=self.export_traversals, bg='wheat')
        self.export_btn.pack(side=tk.LEFT, padx=2)

        tk.Label(self.control_frame, text="Layout:").pack(side=tk.LEFT, padx=(20,5))
        
        self.layout_var = tk.StringVar(value="Kompakt")
        layout_menu = ttk.Combobox(self.control_frame, textvariable=self.layout_var, 
                                  values=["Kompakt", "Ausgebreitet", "Kreisförmig"],
                                  state="readonly", width=10)
        layout_menu.pack(side=tk.LEFT, padx=2)
        layout_menu.bind('<<ComboboxSelected>>', self.change_layout)

    def _setup_info_panel(self):
        tk.Label(self.info_frame, text="Baum-Informationen", font=('Arial', 12, 'bold'), 
                bg='lightgray').pack(pady=10)
        
        self.info_text = tk.Text(self.info_frame, height=15, width=35, wrap=tk.WORD)
        self.info_text.pack(padx=10, pady=5, fill=tk.BOTH, expand=True)
        
        scrollbar = tk.Scrollbar(self.info_frame, orient=tk.VERTICAL, command=self.info_text.yview)
        scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
        self.info_text.config(yscrollcommand=scrollbar.set)
        
        self.traversal_text = tk.Text(self.info_frame, height=8, width=35, wrap=tk.WORD)
        self.traversal_text.pack(padx=10, pady=5, fill=tk.BOTH)

    def _bind_events(self):
        self.canvas.bind('<ButtonPress-1>', self._start_move)
        self.canvas.bind('<B1-Motion>', self._move_canvas)
        self.canvas.bind('<MouseWheel>', self._zoom)
        self.canvas.bind('<Button-4>', self._zoom_linux)
        self.canvas.bind('<Button-5>', self._zoom_linux)
        self.canvas.bind('<Double-Button-1>', self._on_double_click)
        self.canvas.bind('<Motion>', self._on_mouse_motion)

    def _start_move(self, event):
        self.canvas.scan_mark(event.x, event.y)

    def _move_canvas(self, event):
        self.canvas.scan_dragto(event.x, event.y, gain=1)

    def _zoom(self, event):
        factor = 1.1 if event.delta > 0 else 0.9
        self._apply_zoom(factor, event.x, event.y)

    def _zoom_linux(self, event):
        factor = 1.1 if event.num == 4 else 0.9
        self._apply_zoom(factor, event.x, event.y)

    def _apply_zoom(self, factor, x, y):
        self.scale *= factor
        self.canvas.scale('all', x, y, factor, factor)
        self.canvas.configure(scrollregion=self.canvas.bbox('all'))

    def _on_double_click(self, event):
        self.scale = 1.0
        self.draw_tree()

    def _on_mouse_motion(self, event):
        item = self.canvas.find_closest(event.x, event.y)[0]
        tags = self.canvas.gettags(item)
        if 'node' in tags:
            self.canvas.configure(cursor='hand2')
        else:
            self.canvas.configure(cursor='')

    def _calculate_optimal_layout(self):
        if not self.tree.root:
            return
        
        layout = self.layout_var.get()
        
        if layout == "Kreisförmig":
            self._calculate_circular_positions()
        elif layout == "Ausgebreitet":
            self._calculate_spread_positions()
        else:
            self._calculate_compact_positions()

    def _calculate_compact_positions(self):
        if not self.tree.root:
            return
        
        self.positions = {}
        self.x_counter = 0
        self._calculate_positions_recursive(self.tree.root, 0)

    def _calculate_positions_recursive(self, node, depth):
        x = self.x_counter * 180 + 100
        y = depth * 120 + 80
        self.positions[node] = (x, y)
        self.x_counter += 1
        
        for child in node.children:
            self._calculate_positions_recursive(child, depth + 1)

    def _calculate_spread_positions(self):
        if not self.tree.root:
            return
        
        self.positions = {}
        tree_width = self.tree.get_tree_width()
        
        def calculate_spread(node, depth, min_x, max_x):
            if not node.children:
                x = (min_x + max_x) / 2
                y = depth * 150 + 80
                self.positions[node] = (x, y)
                return
            
            y = depth * 150 + 80
            self.positions[node] = ((min_x + max_x) / 2, y)
            
            child_width = (max_x - min_x) / len(node.children)
            for i, child in enumerate(node.children):
                child_min_x = min_x + i * child_width
                child_max_x = min_x + (i + 1) * child_width
                calculate_spread(child, depth + 1, child_min_x, child_max_x)
        
        calculate_spread(self.tree.root, 0, 50, tree_width * 200)

    def _calculate_circular_positions(self):
        if not self.tree.root:
            return
        
        self.positions = {}
        center_x, center_y = 400, 300
        
        def calculate_circular(node, depth, angle_start, angle_end):
            radius = 80 + depth * 100
            angle = (angle_start + angle_end) / 2
            
            x = center_x + radius * math.cos(angle)
            y = center_y + radius * math.sin(angle)
            self.positions[node] = (x, y)
            
            if node.children:
                angle_per_child = (angle_end - angle_start) / len(node.children)
                for i, child in enumerate(node.children):
                    child_angle_start = angle_start + i * angle_per_child
                    child_angle_end = angle_start + (i + 1) * angle_per_child
                    calculate_circular(child, depth + 1, child_angle_start, child_angle_end)
        
        calculate_circular(self.tree.root, 0, 0, 2 * math.pi)

    def change_layout(self, event=None):
        self._calculate_optimal_layout()
        self.draw_tree()

    def draw_tree(self):
        self.canvas.delete('all')
        if not self.tree.root:
            return
        
        self._draw_edges()
        self._draw_nodes()
        self.canvas.configure(scrollregion=self.canvas.bbox('all'))

    def _draw_edges(self):
        for node in self.positions:
            if node.children:
                x, y = self.positions[node]
                for child in node.children:
                    cx, cy = self.positions[child]
                    self.canvas.create_line(x, y + 25, cx, cy - 25, 
                                          width=2, fill='gray', tags='edge')

    def _draw_nodes(self):
        for node, (x, y) in self.positions.items():
            color = self.node_colors.get(node, 'lightblue')
            outline = 'red' if node in self.highlighted_nodes else 'black'
            outline_width = 3 if node in self.highlighted_nodes else 1
            
            self.canvas.create_oval(x - 25, y - 25, x + 25, y + 25, 
                                  fill=color, outline=outline, width=outline_width,
                                  tags=('node', f'node_{id(node)}'))
            
            text_color = 'white' if color in ['red', 'blue', 'darkgreen'] else 'black'
            self.canvas.create_text(x, y, text=node.label, 
                                  font=('Arial', 10, 'bold'), fill=text_color,
                                  tags=('text', f'text_{id(node)}'))

    def animate_preorder(self):
        if self.animation_running:
            return
        nodes = self.tree.preorder_traversal()
        self._animate_traversal(nodes, "Preorder", 'lightgreen')

    def animate_inorder(self):
        if self.animation_running:
            return
        nodes = self.tree.inorder_traversal()
        self._animate_traversal(nodes, "Inorder", 'lightblue')

    def animate_postorder(self):
        if self.animation_running:
            return
        nodes = self.tree.postorder_traversal()
        self._animate_traversal(nodes, "Postorder", 'lightcoral')

    def animate_levelorder(self):
        if self.animation_running:
            return
        nodes = self.tree.level_order_traversal()
        self._animate_traversal(nodes, "Level Order", 'lightyellow')

    def _animate_traversal(self, nodes, traversal_name, color):
        self.animation_running = True
        self.reset_visualization()
        
        self.traversal_text.delete(1.0, tk.END)
        self.traversal_text.insert(tk.END, f"{traversal_name} Traversierung:\n\n")
        
        for i, node in enumerate(nodes):
            self.highlighted_nodes.add(node)
            self.node_colors[node] = color
            self.draw_tree()
            
            self.traversal_text.insert(tk.END, f"{i+1}. {node.label}\n")
            self.traversal_text.see(tk.END)
            
            self.master.update()
            time.sleep(0.8)
        
        self.animation_running = False

    def reset_visualization(self):
        self.highlighted_nodes.clear()
        self.node_colors.clear()
        self.draw_tree()
        self.traversal_text.delete(1.0, tk.END)

    def export_traversals(self):
        export_window = tk.Toplevel(self.master)
        export_window.title("Traversierung Export")
        export_window.geometry("500x400")
        
        text_widget = tk.Text(export_window, wrap=tk.WORD)
        text_widget.pack(fill=tk.BOTH, expand=True, padx=10, pady=10)
        
        preorder = [node.label for node in self.tree.preorder_traversal()]
        inorder = [node.label for node in self.tree.inorder_traversal()]
        postorder = [node.label for node in self.tree.postorder_traversal()]
        levelorder = [node.label for node in self.tree.level_order_traversal()]
        
        export_text = f"""Baum Traversierung Export
=========================

Preorder:   {' -> '.join(preorder)}
Inorder:    {' -> '.join(inorder)}
Postorder:  {' -> '.join(postorder)}
Level Order: {' -> '.join(levelorder)}

Baum-Statistiken:
- Anzahl Knoten: {self.tree.node_count}
- Höhe: {self.tree.get_tree_height()}
- Maximale Breite: {self.tree.get_tree_width()}
"""
        
        text_widget.insert(1.0, export_text)
        text_widget.config(state=tk.DISABLED)

    def _update_info(self):
        self.info_text.delete(1.0, tk.END)
        
        info = f"""Baum-Statistiken:
• Anzahl Knoten: {self.tree.node_count}
• Höhe: {self.tree.get_tree_height()}
• Max. Breite: {self.tree.get_tree_width()}

Traversierung-Arten:
• Preorder: Wurzel → Links → Rechts
• Inorder: Links → Wurzel → Rechts  
• Postorder: Links → Rechts → Wurzel
• Level Order: Ebene für Ebene

Steuerung:
• Mausrad: Zoomen
• Ziehen: Verschieben
• Doppelklick: Zoom zurücksetzen

Layout-Optionen:
• Kompakt: Platzsparend
• Ausgebreitet: Gleichmäßig verteilt
• Kreisförmig: Radiale Anordnung
"""
        
        self.info_text.insert(1.0, info)
        self.info_text.config(state=tk.DISABLED)

def create_tree_input():
    window = tk.Toplevel()
    window.title('Hierarchische Baumstruktur eingeben')
    window.geometry('600x500')
    
    info_frame = tk.Frame(window)
    info_frame.pack(fill=tk.X, padx=10, pady=5)
    
    tk.Label(info_frame, text='Geben Sie die Baumstruktur ein:', 
             font=('Arial', 12, 'bold')).pack(anchor=tk.W)
    tk.Label(info_frame, text='• Verwenden Sie Leerzeichen für Einrückungen', 
             fg='blue').pack(anchor=tk.W)
    tk.Label(info_frame, text='• Jede Ebene = 2-4 Leerzeichen mehr', 
             fg='blue').pack(anchor=tk.W)
    tk.Label(info_frame, text='• Beispiel: "  Kind" für Unterelement', 
             fg='blue').pack(anchor=tk.W)
    
    text_frame = tk.Frame(window)
    text_frame.pack(fill=tk.BOTH, expand=True, padx=10, pady=5)
    
    text_widget = tk.Text(text_frame, width=70, height=20, font=('Courier', 10))
    scrollbar = tk.Scrollbar(text_frame, orient=tk.VERTICAL, command=text_widget.yview)
    text_widget.config(yscrollcommand=scrollbar.set)
    
    text_widget.pack(side=tk.LEFT, fill=tk.BOTH, expand=True)
    scrollbar.pack(side=tk.RIGHT, fill=tk.Y)
    
    example_text = """Unternehmen
  Management
    CEO
    CTO
    CFO
  Entwicklung
    Frontend
      React
      Vue
    Backend
      Python
      Java
  Marketing
    Digital
    Print"""
    
    text_widget.insert(1.0, example_text)
    
    button_frame = tk.Frame(window)
    button_frame.pack(fill=tk.X, padx=10, pady=5)
    
    def process_input():
        content = text_widget.get('1.0', 'end').strip()
        if not content:
            messagebox.showwarning('Warnung', 'Bitte geben Sie eine Baumstruktur ein.')
            return
        
        global app_tree
        app_tree = DataTree()
        try:
            app_tree.build_from_text(content)
            messagebox.showinfo('Erfolg', f'Baum mit {app_tree.node_count} Knoten erstellt!')
            window.destroy()
        except Exception as e:
            messagebox.showerror('Fehler', f'Fehler beim Erstellen des Baums:\n{str(e)}')
    
    def clear_input():
        text_widget.delete(1.0, tk.END)
    
    tk.Button(button_frame, text='Baum erstellen', command=process_input, 
              bg='lightgreen', font=('Arial', 10, 'bold')).pack(side=tk.LEFT, padx=5)
    tk.Button(button_frame, text='Löschen', command=clear_input, 
              bg='lightcoral').pack(side=tk.LEFT, padx=5)
    tk.Button(button_frame, text='Abbrechen', command=window.destroy, 
              bg='lightgray').pack(side=tk.RIGHT, padx=5)

def visualize_tree():
    if 'app_tree' not in globals() or not app_tree:
        messagebox.showerror('Fehler', 'Bitte erstellen Sie zuerst eine Baumstruktur!')
        return
    
    visualization_window = tk.Toplevel()
    visualization_window.title('Erweiterte Baum-Visualisierung')
    visualization_window.state('zoomed')
    
    Visualizer(visualization_window, app_tree)

def show_about():
    about_window = tk.Toplevel()
    about_window.title('Über das Programm')
    about_window.geometry('400x300')
    about_window.resizable(False, False)
    
    about_text = """Erweiterte Baum-Visualisierung v2.0

Funktionen:
• Interaktive Baumdarstellung
• Traversierung-Animationen
• Verschiedene Layout-Optionen
• Zoom und Pan-Funktionen
• Export-Möglichkeiten

Traversierung-Methoden:
• Preorder (Tiefensuche)
• Inorder (Symmetrische Ordnung)
• Postorder (Nachbearbeitung)
• Level Order (Breitensuche)

Entwickelt für Bildungszwecke
"""
    
    tk.Label(about_window, text=about_text, justify=tk.LEFT, 
             font=('Arial', 10), padx=20, pady=20).pack()

if __name__ == "__main__":
    root = tk.Tk()
    root.title('Erweiterte Baum-Visualisierung')
    root.geometry('400x200')
    root.resizable(False, False)
    
    main_frame = tk.Frame(root, padx=20, pady=20)
    main_frame.pack(fill=tk.BOTH, expand=True)
    
    tk.Label(main_frame, text='Baum-Visualisierung mit Traversierung', 
             font=('Arial', 14, 'bold')).pack(pady=10)
    
    button_frame = tk.Frame(main_frame)
    button_frame.pack(pady=10)
    
    tk.Button(button_frame, text='Baumstruktur eingeben', 
              command=create_tree_input, bg='lightblue', 
              font=('Arial', 10), width=20, height=2).pack(pady=5)
    
    tk.Button(button_frame, text='Baum visualisieren', 
              command=visualize_tree, bg='lightgreen', 
              font=('Arial', 10), width=20, height=2).pack(pady=5)
    
    tk.Button(button_frame, text='Über das Programm', 
              command=show_about, bg='wheat', 
              font=('Arial', 10), width=20, height=2).pack(pady=5)
    
    root.mainloop()