package taylor.math.function;

import taylor.math.Constant;
import taylor.math.Expression;
import taylor.math.operation.Multiplication;

public class Cosine extends Function {
    
    public Cosine(Expression e) {
        super(e);
    }
    
    @Override
    public Expression derive() {
        return new Multiplication(e.derive(),new Multiplication(new Constant(-1),new Sine(e)));
    }
    
    @Override
    public double getY(double x) {
        return Math.cos(e.getY(x));
    }
    
    @Override
    public String toString() {
        return "cos(" + e.toString() + ")";
    }
}
