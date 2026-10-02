package ru.mirea.pr3.statics;

/** Недопустимые предложения 5 и 7 из задания 1 (не компилируется) */
public class Task1Invalid {
    public static void main(String[] args) {
        System.out.println(F.i);   // 5. i - переменная экземпляра
        F.imethod();               // 7. imethod() - метод экземпляра
    }
}
