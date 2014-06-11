package taylor.math;

public class Variable extends Expression {
    
    public double coefficient;
    
    public Variable(double newCo) {
        coefficient = newCo;
    }
    
    @Override
    public double getY(double x) { return coefficient*x; }
    
    @Override
    public Expression derive() {
        return new Constant(coefficient);
    }
    
    @Override
    public String toString() {
        return (coefficient!=1?coefficient:"") + "x";
    }
    
    @Override
    public Expression simplify() {
        return this;
    }
}
