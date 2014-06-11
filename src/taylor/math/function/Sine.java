package taylor.math.function;

import taylor.math.Expression;
import taylor.math.operation.Multiplication;

public class Sine extends Function {
    
    public Sine(Expression e) {
        super(e);
    }
    
    @Override
    public Expression derive() {
        return new Multiplication(e.derive(),new Cosine(e));
    }
    
    @Override
    public double getY(double x) {
        return Math.sin(x);
    }
    
    @Override
    public String toString() {
        return "sin(" + e.toString() + ")";
    }
}
