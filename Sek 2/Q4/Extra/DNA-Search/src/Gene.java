import java.util.ArrayList;
import java.util.Comparator;

public class Gene {
    enum Nucleotide {
        A, C, G, T
    }

    public static class Codon implements Comparable<Codon> {
        public final Nucleotide first;
        public final Nucleotide second;
        public final Nucleotide third;
        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.first)
                .thenComparing((Codon c) -> c.second)
                .thenComparing((Codon c) -> c.third);

        public Codon(String codonStr) {
            first = Nucleotide.valueOf(codonStr.substring(0, 1));
            second = Nucleotide.valueOf(codonStr.substring(1, 2));
            third = Nucleotide.valueOf(codonStr.substring(2, 3));
        }

        @Override
        public int compareTo(Codon other) {
            return comparator.compare(this, other);
        }

        @Override
        public String toString() {
            return "" + first + second + third;
        }
    }

    private final ArrayList<Codon> codons = new ArrayList<>();

    public Gene(String geneStr) {
        for (int i = 0; i < geneStr.length() - 3; i += 3) {
            codons.add(new Codon(geneStr.substring(i, i + 3)));
        }
    }

    public boolean linearContains(Codon key) {
        for (Codon codon : codons) {
            if (codon.compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Gene gene = new Gene("ATGCCCTTAAAGGGT");
        Codon codonA = new Codon("ATG");
        Codon codonB = new Codon("CCC");
        Codon codonC = new Codon("GTA");

        System.out.println(codonA + " enthalten? " + gene.linearContains(codonA));
        System.out.println(codonB + " enthalten? " + gene.linearContains(codonB));
        System.out.println(codonC + " enthalten? " + gene.linearContains(codonC));
    }
}
