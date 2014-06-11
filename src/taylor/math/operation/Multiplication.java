package taylor.math.operation;
import taylor.math.Constant;
import taylor.math.Expression;

public class Multiplication extends Operation {
    
    public Multiplication(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public double getY(double x) {
        return e1.getY(x) * e2.getY(x);
    }
    
    @Override
    public Expression derive() {
        return new Addition(new Multiplication(e1.derive(),e2),new Multiplication(e1,e2.derive()));
    }
    
    @Override
    public String toString() {
        return "(" + e1 + "*" + e2 + ")";
    }
    
    @Override
    public Expression simplify() {
        e1 = e1.simplify();
        e2 = e2.simplify();
        
        if (e1 instanceof Constant && e2 instanceof Constant)
            return new Constant(((Constant)e1).value*((Constant)e2).value);
        if (e1 instanceof Constant && ((Constant)e1).value == 0 || e2 instanceof Constant && ((Constant)e2).value == 0)
            return new Constant(0);
        
        return this;
    }
}
