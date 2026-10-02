package ru.mirea.pr6.undo;

public class TestUndo {
    public static void main(String[] args) {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("Привет");
        System.out.println("append(\"Привет\")        -> " + s);
        s.append(", мир").append('!');
        System.out.println("append(\", мир\").append('!') -> " + s);
        s.insert(0, ">> ");
        System.out.println("insert(0, \">> \")       -> " + s);
        s.replace(11, 14, "Java");
        System.out.println("replace(11, 14, \"Java\")-> " + s);
        s.delete(0, 3);
        System.out.println("delete(0, 3)            -> " + s);
        s.reverse();
        System.out.println("reverse()               -> " + s);
        s.setCharAt(0, '?');
        System.out.println("setCharAt(0, '?')       -> " + s);
        s.append(' ').append(2026).append(true);
        System.out.println("append(' ').append(2026).append(true) -> " + s);
        s.insert(0, (String) null);
        System.out.println("insert(0, (String) null) -> " + s);
        s.deleteCharAt(0);
        System.out.println("deleteCharAt(0)         -> " + s);
        s.setLength(5);
        System.out.println("setLength(5)            -> " + s);

        System.out.println("--- Отмена операций ---");
        while (s.undo()) {
            System.out.println("undo() -> \"" + s + "\"");
        }
        System.out.println("Больше нечего отменять, undo() = " + s.undo());
    }
}
