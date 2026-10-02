package ru.mirea.pr6.undo;

/** Команда отмены одного действия (шаблон "Команда"). */
public interface Command {
    void undo();
}
