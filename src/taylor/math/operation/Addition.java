package taylor.math.operation;

import taylor.math.Constant;
import taylor.math.Expression;
import taylor.math.Variable;

public class Addition extends Operation {
    
    public Addition(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public double getY(double x) {
        return e1.getY(x) + e2.getY(x);
    }
    
    @Override
    public Expression derive() {
        return new Addition(e1.derive(),e2.derive());
    }
    
    @Override
    public String toString() {
        return "(" + e1 + "+" + e2 + ")";
    }
    
    @Override
    public Expression simplify() {
        e1 = e1.simplify();
        e2 = e2.simplify();
        
        if (e1 instanceof Constant && e2 instanceof Constant)
            return new Constant(((Constant)e1).value+((Constant)e2).value);
        if (e1 instanceof Variable && e2 instanceof Variable)
            return new Variable(((Variable)e1).coefficient+((Variable)e2).coefficient);
        if (e1 instanceof Constant && ((Constant)e1).value == 0)
            return e2;
        if (e2 instanceof Constant && ((Constant)e2).value == 0)
            return e1;
        
        return this;
    }
}
