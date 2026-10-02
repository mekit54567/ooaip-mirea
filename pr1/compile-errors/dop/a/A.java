public class A {
    String s;

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
    }
}
