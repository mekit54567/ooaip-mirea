package part4.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задание 3 (ПР4). Мини-приложение "Интернет-магазин" (консольное меню).
 */
public class OnlineShop {
    private static final int MAX_ATTEMPTS = 3;

    private final List<User> users = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final Cart cart = new Cart();
    private final Scanner sc;
    private User currentUser;
    private Category currentCategory;
    private boolean inputClosed;

    public OnlineShop(Scanner sc) {
        this.sc = sc;
        // учетные записи и товары задаются в коде (учебный пример)
        users.add(new User("student", "java2026"));
        users.add(new User("admin", "admin"));

        products.add(new Product("Ноутбук Lenovo IdeaPad 5", 64990.0, Category.ELECTRONICS));
        products.add(new Product("Смартфон Samsung Galaxy A55", 32990.0, Category.ELECTRONICS));
        products.add(new Product("Наушники JBL Tune 520", 4490.0, Category.ELECTRONICS));
        products.add(new Product("Шилдт Г. Java. Полное руководство", 3150.0, Category.BOOKS));
        products.add(new Product("Блох Дж. Java. Эффективное программирование", 2400.0, Category.BOOKS));
        products.add(new Product("Худи с логотипом МИРЭА", 2990.0, Category.CLOTHES));
        products.add(new Product("Футболка хлопковая", 990.0, Category.CLOTHES));
    }

    /** 1) Аутентификация: логин и пароль вводятся с клавиатуры. */
    private boolean login() {
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Логин: ");
            String login = readLine();
            System.out.print("Пароль: ");
            String password = readLine();
            if (login == null || password == null) {
                return false;
            }
            for (User u : users) {
                if (u.checkCredentials(login, password)) {
                    currentUser = u;
                    System.out.println("Добро пожаловать, " + u.getLogin() + "!");
                    return true;
                }
            }
            System.out.println("Неверный логин или пароль (попытка " + attempt + " из " + MAX_ATTEMPTS + ")");
        }
        return false;
    }

    /** 2) Список каталогов. */
    private void showCategories() {
        System.out.println("Каталоги:");
        for (Category c : Category.values()) {
            System.out.println("  " + (c.ordinal() + 1) + ". " + c.getTitle());
        }
    }

    private List<Product> productsOf(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory() == category) {
                result.add(p);
            }
        }
        return result;
    }

    /** 3) Товары выбранного каталога. */
    private void showProducts() {
        showCategories();
        int n = readInt("Номер каталога: ");
        if (n < 1 || n > Category.values().length) {
            System.out.println("Нет такого каталога");
            return;
        }
        currentCategory = Category.values()[n - 1];
        System.out.println("Каталог \"" + currentCategory.getTitle() + "\":");
        List<Product> list = productsOf(currentCategory);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + list.get(i));
        }
    }

    /** 4) Выбор товара в корзину (из последнего открытого каталога). */
    private void addToCart() {
        if (currentCategory == null) {
            System.out.println("Сначала откройте каталог (пункт 2)");
            return;
        }
        List<Product> list = productsOf(currentCategory);
        int n = readInt("Номер товара в каталоге \"" + currentCategory.getTitle() + "\": ");
        if (n < 1 || n > list.size()) {
            System.out.println("Нет такого товара");
            return;
        }
        cart.add(list.get(n - 1));
        System.out.println("Добавлено в корзину: " + list.get(n - 1).getName());
    }

    /** 5) Покупка товаров из корзины. */
    private void buy() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста, покупать нечего");
            return;
        }
        cart.print();
        System.out.print("Подтвердить покупку? (y/n): ");
        String answer = readLine();
        if (answer != null && answer.equalsIgnoreCase("y")) {
            System.out.printf("Покупка оформлена пользователем %s на сумму %.2f руб. Спасибо!%n",
                    currentUser.getLogin(), cart.getTotal());
            cart.clear();
        } else {
            System.out.println("Покупка отменена");
        }
    }

    /** Чтение строки; при конце входного потока возвращает null. */
    private String readLine() {
        if (inputClosed || !sc.hasNextLine()) {
            if (!inputClosed) {
                inputClosed = true;
                System.out.println();
                System.out.println("Ввод завершен (конец входного потока)");
            }
            return null;
        }
        return sc.nextLine().trim();
    }

    /** Чтение номера пункта меню; -1 при ошибке ввода, 0 (выход) при конце ввода. */
    private int readInt(String prompt) {
        System.out.print(prompt);
        String line = readLine();
        if (line == null) {
            return 0;
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void run() {
        if (!login()) {
            System.out.println("Доступ запрещен");
            return;
        }
        while (true) {
            System.out.println();
            System.out.println("1 - каталоги, 2 - товары каталога, 3 - добавить в корзину, "
                    + "4 - корзина, 5 - купить, 0 - выход");
            int choice = readInt("Ваш выбор: ");
            if (inputClosed) {
                System.out.println("До свидания!");
                return;
            }
            switch (choice) {
                case 1: showCategories(); break;
                case 2: showProducts(); break;
                case 3: addToCart(); break;
                case 4: cart.print(); break;
                case 5: buy(); break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new OnlineShop(sc).run();
        sc.close();
    }
}
