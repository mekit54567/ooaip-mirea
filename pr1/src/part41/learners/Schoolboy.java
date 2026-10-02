package part41.learners;

public class Schoolboy extends Learner {
    private int grade; // класс

    public Schoolboy(String name, int age, String school, int grade) {
        super(name, age, school);
        this.grade = grade;
    }

    @Override
    public void study() {
        System.out.println(name + " учится в " + grade + " классе (" + institution + ")");
    }

    @Override
    public String toString() {
        return "Школьник: " + super.toString() + ", " + grade + " класс";
    }
}
