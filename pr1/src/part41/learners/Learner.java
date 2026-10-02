package part41.learners;

/**
 * Учащийся - суперкласс для школьника и студента.
 */
public class Learner {
    protected String name;
    protected int age;
    protected String institution; // учебное заведение

    public Learner(String name, int age, String institution) {
        this.name = name;
        this.age = age;
        this.institution = institution;
    }

    public String getName() {
        return name;
    }

    public void study() {
        System.out.println(name + " учится в " + institution);
    }

    @Override
    public String toString() {
        return name + ", " + age + " лет, " + institution;
    }
}
