package taylor.math;

public abstract class Expression {
    
    public abstract Expression derive();
    public abstract double getY(double x);
    public abstract Expression simplify();
}
