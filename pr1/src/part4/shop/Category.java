package part4.shop;

/**
 * Каталоги (категории) товаров интернет-магазина.
 */
public enum Category {
    ELECTRONICS("Электроника"),
    BOOKS("Книги"),
    CLOTHES("Одежда");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
