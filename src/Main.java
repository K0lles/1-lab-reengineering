


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HumanIMB humanIMB = new HumanIMB(80, 1.52);
        System.out.println(humanIMB.result());
    }
}

class HumanIMB {
    private double weight; // Weight of the Human
    private double height; // Height of the Human
    private double imb;

    public HumanIMB(double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.imb = calculateIMB();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        this.imb = calculateIMB();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        this.imb = calculateIMB();
    }

    public double getImb() {
        return imb;
    }

    private double calculateIMB() {
        return weight / (height * height);
    }

    public String result() {
        if (imb >= 18.5 && imb < 25) {
            return "Norm";
        } else if (imb >= 25 && imb < 30) {
            return "Warning!";
        } else if (imb >= 30) {
            return "Fat";
        } else {
            return "Deficit";
        }
    }
}
