package taylor.math.operation;

import taylor.math.Constant;
import taylor.math.Expression;
import taylor.math.Variable;

public class Division extends Operation {
    
    public Division(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public double getY(double x) {
        if (e2.getY(x) == 0)
            if (e1.getY(x) == 0)
                return Double.NaN;
            else
                return e1.getY(x) > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        return e1.getY(x) / e2.getY(x);
    }
    
    @Override
    public boolean isValid(double x1, double x2) {
        if (e2 instanceof Variable)
            if (x1<0 && x2>0)
                return false;
        if (x1==x2) {
            double y = getY(x1);
            if (y==Double.POSITIVE_INFINITY || y==Double.NEGATIVE_INFINITY || y==Double.NaN)
                return false;
        }
        return true;
    }
    
    @Override
    public Expression derive() {
        return new Division(new Subtraction(new Multiplication(e1.derive(),e2),
                new Multiplication(e1,e2.derive())),
                new Multiplication(e2,e2));
    }
    
    @Override
    public String toString() {
        return "(" + e1 + "/" + e2 + ")";
    }
    
    @Override
    public Expression simplify() {
        e1 = e1.simplify();
        e2 = e2.simplify();
        
        if (e1 instanceof Constant && e2 instanceof Constant)
            return new Constant(((Constant)e1).value/((Constant)e2).value);
        if (e1 instanceof Constant && ((Constant)e1).value == 0)
            return new Constant(0);
        
        return this;
    }
}
