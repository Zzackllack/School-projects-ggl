public class Matrix {
    private int[][] mat;

    public Matrix() {
        mat = new int[][] {
            {1, 2, 3},
            {4, 5, 6}
        };
    }

    public void matrixAusgabe() {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("mat[" + i + "][" + j + "]=" + mat[i][j]);
                if (j < mat[i].length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix m = new Matrix();
        m.matrixAusgabe();
    }
}