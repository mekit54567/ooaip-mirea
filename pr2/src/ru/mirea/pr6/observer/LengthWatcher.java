package ru.mirea.pr6.observer;

/** Наблюдатель, который предупреждает, если строка стала слишком длинной. */
public class LengthWatcher implements StringChangeListener {
    private final int maxLength;

    public LengthWatcher(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void onChange(String operation, String newValue) {
        if (newValue.length() > maxLength) {
            System.out.println("[Длина] внимание: длина " + newValue.length()
                    + " больше " + maxLength);
        }
    }
}
