package pk.sandbox;

public class Calculation {
    double answer =0;

    public double a;
    public double d;
    public Calculation(double a, double d) {
        this.a = a;
        this.d = d;

    }
    public double answer() {
        this.answer = this.a * this.d;
        return answer;
    }
}
