package ru.mirea.pr6.nameable;

public class Animal implements Nameable {
    private String kind;
    private String nickname;

    public Animal(String kind, String nickname) {
        this.kind = kind;
        this.nickname = nickname;
    }

    @Override
    public String getName() {
        return kind + " по кличке " + nickname;
    }
}
