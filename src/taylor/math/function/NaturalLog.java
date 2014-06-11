package taylor.math.function;

import taylor.math.Expression;
import taylor.math.operation.Division;

public class NaturalLog extends Function {
    
    public NaturalLog(Expression e) {
        super(e);
    }
    
    @Override
    public Expression derive() {
        return new Division(e.derive(),e);
    }
    
    @Override
    public double getY(double x) {
        return Math.log(e.getY(x));
    }
    
    @Override
    public String toString() {
        return "ln(" + e.toString() + ")";
    }
}
