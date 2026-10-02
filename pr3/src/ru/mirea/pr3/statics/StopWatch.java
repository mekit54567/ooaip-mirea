package ru.mirea.pr3.statics;

/** Задание 6. Секундомер */
public class StopWatch {
    private long startTime;
    private long endTime;

    /** Конструктор без аргументов: запоминает текущее время как время старта */
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    /** Сбрасывает startTime до текущего времени */
    public void start() {
        startTime = System.currentTimeMillis();
    }

    /** Присваивает endTime текущее время */
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    /** Прошедшее время в миллисекундах */
    public long getElapsedTime() {
        return endTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
