package part41.learners;

public class Student extends Learner {
    private int course;
    private String group;

    public Student(String name, int age, String university, int course, String group) {
        super(name, age, university);
        this.course = course;
        this.group = group;
    }

    @Override
    public void study() {
        System.out.println(name + " учится на " + course + " курсе в группе " + group);
    }

    @Override
    public String toString() {
        return "Студент:  " + super.toString() + ", " + course + " курс, группа " + group;
    }
}
