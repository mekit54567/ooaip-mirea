package part1;

/**
 * Задание 6. Вывод первых 10 членов гармонического ряда 1 + 1/2 + 1/3 + ...
 * с форматированием, а также частичных сумм ряда.
 */
public class HarmonicSeries {
    public static void main(String[] args) {
        final int COUNT = 10;
        double partialSum = 0;

        System.out.println("  n |  член ряда  | значение | частичная сумма");
        System.out.println("----+-------------+----------+----------------");
        for (int n = 1; n <= COUNT; n++) {
            double term = 1.0 / n;
            partialSum += term;
            System.out.printf("%3d | %11s | %8.5f | %14.5f%n", n, "1/" + n, term, partialSum);
        }
    }
}
