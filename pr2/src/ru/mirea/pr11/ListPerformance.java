package ru.mirea.pr11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * Задание 5. Сравнение производительности ArrayList и LinkedList.
 * Время измеряется с помощью System.nanoTime().
 *
 * Подготовка списка (заполнение N элементами) выполняется ДО начала замера,
 * поэтому в измеренное время входит только сама исследуемая операция.
 * Каждый тест повторяется несколько раз, выводится медиана.
 */
public class ListPerformance {
    private static final int N = 100_000;      // размер списка
    private static final int OPS = 10_000;     // число операций в "дорогих" тестах
    private static final int SEARCHES = 1_000; // число поисков indexOf
    private static final int REPEATS = 5;      // повторов каждого замера

    /** Результаты операций накапливаются здесь, чтобы JIT не удалил вычисления как "мертвый код". */
    private static long blackhole;

    /** Исследуемая операция над заранее подготовленным списком. Возвращает контрольное значение. */
    interface ListTest {
        long run(List<Integer> list);
    }

    public static void main(String[] args) {
        // первый прогон - "прогрев" JVM (JIT-компиляция), его результаты не выводим
        runAll(false);
        runAll(true);
        System.out.println("(контрольная сумма: " + blackhole + ")");
    }

    private static void runAll(boolean print) {
        if (print) {
            System.out.printf("Размер списка N = %d, операций в тестах = %d, повторов = %d (медиана)%n",
                    N, OPS, REPEATS);
            System.out.printf("%-42s %12s %12s%n", "Операция", "ArrayList", "LinkedList");
        }
        // в этом тесте список изначально пуст - измеряется само заполнение
        compare(print, "Добавление в конец (N раз)", 0, list -> {
            for (int i = 0; i < N; i++) {
                list.add(i);
            }
            return list.size();
        });
        // во всех остальных тестах список из N элементов готовится вне замера
        compare(print, "Вставка в начало (OPS раз)", N, list -> {
            for (int i = 0; i < OPS; i++) {
                list.add(0, i);
            }
            return list.size();
        });
        compare(print, "Вставка в середину (OPS раз)", N, list -> {
            for (int i = 0; i < OPS; i++) {
                list.add(list.size() / 2, i);
            }
            return list.size();
        });
        compare(print, "Получение по индексу (OPS раз)", N, list -> {
            Random r = new Random(1);
            long sum = 0;
            for (int i = 0; i < OPS; i++) {
                sum += list.get(r.nextInt(list.size()));
            }
            return sum;
        });
        compare(print, "Удаление из начала (OPS раз)", N, list -> {
            long sum = 0;
            for (int i = 0; i < OPS; i++) {
                sum += list.remove(0);
            }
            return sum;
        });
        compare(print, "Удаление из середины (OPS раз)", N, list -> {
            long sum = 0;
            for (int i = 0; i < OPS; i++) {
                sum += list.remove(list.size() / 2);
            }
            return sum;
        });
        compare(print, "Поиск по образцу indexOf (" + SEARCHES + " раз)", N, list -> {
            Random r = new Random(2);
            long sum = 0;
            for (int i = 0; i < SEARCHES; i++) {
                sum += list.indexOf(r.nextInt(N));
            }
            return sum;
        });
    }

    private static void compare(boolean print, String name, int initialSize, ListTest test) {
        double a = measure(ArrayList::new, initialSize, test);
        double l = measure(LinkedList::new, initialSize, test);
        if (print) {
            System.out.printf("%-42s %9.2f мс %9.2f мс%n", name, a, l);
        }
    }

    /** Медиана из REPEATS замеров; заполнение списка в замер не входит. */
    private static double measure(Supplier<List<Integer>> factory, int initialSize, ListTest test) {
        double[] times = new double[REPEATS];
        for (int k = 0; k < REPEATS; k++) {
            List<Integer> list = factory.get();
            for (int i = 0; i < initialSize; i++) {
                list.add(i);
            }
            long start = System.nanoTime();
            long result = test.run(list);
            times[k] = (System.nanoTime() - start) / 1_000_000.0;
            blackhole += result;
        }
        Arrays.sort(times);
        return times[REPEATS / 2];
    }
}
