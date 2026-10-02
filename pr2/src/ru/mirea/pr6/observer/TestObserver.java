package ru.mirea.pr6.observer;

public class TestObserver {
    public static void main(String[] args) {
        ObservableStringBuilder s = new ObservableStringBuilder();
        ConsoleLogger logger = new ConsoleLogger();
        s.subscribe(logger);
        s.subscribe(new LengthWatcher(15));
        // наблюдатель в виде лямбда-выражения
        s.subscribe((op, value) -> System.out.println("[Счетчик] символов: " + value.length()));

        s.append("Hello");
        s.append(", World");
        s.insert(0, "Say: ");
        s.replace(5, 10, "Hi");
        s.delete(0, 5);
        s.append('!');
        s.setCharAt(0, 'h');
        s.deleteCharAt(s.length() - 1);

        System.out.println("--- Логгер отписан ---");
        s.unsubscribe(logger);
        s.reverse();
        System.out.println("Итоговая строка: " + s);
    }
}
