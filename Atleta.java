public class Athelete {
    private char sex;
    private String name;
    private double height;
    private double weight;

    public Athelete(
        String name,
        char sex,
        double height,
        double weight
    ) {
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public char getSex() {
        return this.sex;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }
}