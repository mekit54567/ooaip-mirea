package part4.seasons;

/**
 * Задание 1 (ПР4). Времена года.
 */
public class SeasonDemo {

    /** Выводит сообщение о любимом времени года (оператор switch). */
    public static void printLove(Season season) {
        switch (season) {
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case SPRING:
                System.out.println("Я люблю весну");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
            case AUTUMN:
                System.out.println("Я люблю осень");
                break;
            default:
                System.out.println("Неизвестное время года");
        }
    }

    public static void main(String[] args) {
        // 1) любимое время года и вся информация о нём
        Season favorite = Season.SUMMER;
        System.out.println("Любимое время года: " + favorite.getRussianName());
        System.out.println("  name()      = " + favorite.name());
        System.out.println("  ordinal()   = " + favorite.ordinal());
        System.out.println("  температура = " + favorite.getAverageTemperature() + " °C");
        System.out.println("  описание    = " + favorite.getDescription());

        // 2) метод со switch
        printLove(favorite);
        printLove(Season.valueOf("WINTER"));

        // 6) все времена года в цикле
        System.out.println();
        System.out.println("Все времена года:");
        for (Season s : Season.values()) {
            System.out.printf("%d. %-6s (%-6s) средняя температура %5.1f °C - %s%n",
                    s.ordinal() + 1, s.getRussianName(), s, s.getAverageTemperature(),
                    s.getDescription());
        }
    }
}
