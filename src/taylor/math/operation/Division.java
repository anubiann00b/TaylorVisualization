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
            return e1.getY(x) > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return e1.getY(x) / e2.getY(x);
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
        if (e1 instanceof Variable && e2 instanceof Variable)
            return new Variable(((Variable)e1).coefficient/((Variable)e2).coefficient);
        
        return this;
    }
}
