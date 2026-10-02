package part41.learners;

public class LearnerDemo {
    public static void main(String[] args) {
        Learner[] learners = {
                new Schoolboy("Миша Орлов", 12, "школа №1535", 6),
                new Student("Анна Белова", 19, "РТУ МИРЭА", 2, "УИБО-03-24"),
                new Schoolboy("Катя Зайцева", 16, "лицей №1580", 10),
                new Student("Денис Волков", 20, "РТУ МИРЭА", 3, "БИСО-01-23"),
                new Student("Олег Лебедев", 18, "МГТУ им. Баумана", 1, "ИУ8-11")
        };

        System.out.println("Все учащиеся:");
        for (Learner l : learners) {
            l.study();
        }

        System.out.println();
        System.out.println("Школьники:");
        for (Learner l : learners) {
            if (l instanceof Schoolboy) {
                System.out.println("  " + l);
            }
        }

        System.out.println("Студенты:");
        for (Learner l : learners) {
            if (l instanceof Student) {
                System.out.println("  " + l);
            }
        }
    }
}
