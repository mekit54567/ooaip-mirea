package part41.matrix;

public class MatrixDemo {
    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        Matrix b = new Matrix(new double[][]{
                {0.5, -1, 2},
                {3, 0, 1.5}
        });
        Matrix c = new Matrix(new double[][]{
                {1, 0},
                {2, 1},
                {0, 3}
        });

        System.out.println("Матрица A (" + a.getRows() + "x" + a.getCols() + "):");
        a.print();
        System.out.println("Матрица B:");
        b.print();
        System.out.println("A + B:");
        a.add(b).print();
        System.out.println("A * 2.5:");
        a.multiply(2.5).print();
        System.out.println("Матрица C (3x2):");
        c.print();
        System.out.println("A * C (2x2):");
        a.multiply(c).print();

        try {
            a.add(c);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка A + C: " + e.getMessage());
        }
    }
}
