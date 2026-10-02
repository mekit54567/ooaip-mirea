package part41.matrix;

/**
 * Матрица вещественных чисел.
 */
public class Matrix {
    private final double[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("размеры матрицы должны быть положительными");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public Matrix(double[][] values) {
        this(values.length, values[0].length);
        for (int i = 0; i < rows; i++) {
            if (values[i].length != cols) {
                throw new IllegalArgumentException("строки должны быть одинаковой длины");
            }
            for (int j = 0; j < cols; j++) {
                data[i][j] = values[i][j];
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int i, int j) {
        return data[i][j];
    }

    /** Сложение с другой матрицей того же размера. */
    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("для сложения размеры матриц должны совпадать");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    /** Умножение на число. */
    public Matrix multiply(double k) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] * k;
            }
        }
        return result;
    }

    /** Умножение матриц (число столбцов первой = числу строк второй). */
    public Matrix multiply(Matrix other) {
        if (cols != other.rows) {
            throw new IllegalArgumentException("число столбцов первой матрицы должно равняться числу строк второй");
        }
        Matrix result = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    /** Вывод на печать. */
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f", data[i][j]);
            }
            System.out.println();
        }
    }
}
