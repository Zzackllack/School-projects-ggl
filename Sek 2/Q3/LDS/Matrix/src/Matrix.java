public class Matrix {
    private final int[][] mat;

    public Matrix() {
        mat = new int[][] {
            {1, 2, 3},
            {4, 5, 6}
        };
    }

        public void matrixAusgabe() {
            // Diese Methode gibt das 2D-Array 'mat' zeilenweise aus.
            // 'mat' ist ein Array von Zeilen: jede mat[i] ist eine einzelne Zeile (ein int[]).

            // Äußere Schleife: geht über alle Zeilen (i = 0, 1, ..., mat.length-1)
            // Warum 0? Java-Array-Indizes beginnen bei 0.
            // Warum i < mat.length? Damit wir nicht über das Ende des Arrays hinaus zugreifen.
            for (int i = 0; i < mat.length; i++) {

                // Innere Schleife: geht über alle Spalten der aktuellen Zeile mat[i]
                // mat[i].length ist die Anzahl der Elemente in dieser Zeile.
                // j ist der Spaltenindex innerhalb der aktuellen Zeile.
                for (int j = 0; j < mat[i].length; j++) {

                    // Ausgabe des Elements an Position [i][j]
                    // Beispiel: für i=0, j=1 wird "mat[0][1]=2" ausgegeben.
                    System.out.print("mat[" + i + "][" + j + "]=" + mat[i][j]);

                    // Wenn dies nicht das letzte Element der Zeile ist, füge ein Leerzeichen ein,
                    // damit die Elemente in einer Zeile optisch getrennt sind.
                    // mat[i].length - 1 ist der Index des letzten Elements in der Zeile.
                    if (j < mat[i].length - 1) System.out.print(" ");
                }

                // Nach dem Durchlaufen aller Spalten einer Zeile: Zeilenumbruch,
                // damit die nächste Zeile der Matrix in einer neuen Textzeile beginnt.
                System.out.println();
            }
        }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.matrixAusgabe();
    }
}