package part4.computer;

public class Monitor {
    private final double diagonal; // дюймы
    private final int width;       // разрешение по горизонтали
    private final int height;      // разрешение по вертикали

    public Monitor(double diagonal, int width, int height) {
        this.diagonal = diagonal;
        this.width = width;
        this.height = height;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public String getResolution() {
        return width + "x" + height;
    }

    @Override
    public String toString() {
        return diagonal + "\" " + getResolution();
    }
}
