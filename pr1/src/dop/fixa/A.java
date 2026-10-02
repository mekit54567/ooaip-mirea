package dop.fixa;

/**
 * Исправленная версия класса A из задания 1:
 * добавлен конструктор без аргументов.
 */
public class A {
    String s;

    A() {
        this("строка по умолчанию");
    }

    A(String newS) {
        s = newS;
    }

    public void print() {
        System.out.print(s);
    }
}

class TestA {
    public static void main(String[] args) {
        A a = new A();
        a.print();
        System.out.println(); // перевод строки - метод print() из задания его не выводит
        A b = new A("Hello, Java!");
        b.print();
        System.out.println();
    }
}
