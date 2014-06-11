package taylor.math;

public class Constant extends Expression {
    
    public double value;
    
    public Constant(double newVal) {
        value = newVal;
    }
    
    @Override
    public double getY(double x) { return value; }
    
    @Override
    public Expression derive() {
        return new Constant(0);
    }
    
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
