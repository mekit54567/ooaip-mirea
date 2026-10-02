package part1;

/**
 * Задание 5. Вывод аргументов командной строки в цикле for.
 */
public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы командной строки не переданы");
            return;
        }
        System.out.println("Количество аргументов: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}
