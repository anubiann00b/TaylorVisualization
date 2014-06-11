package taylor.math.operation;
import taylor.math.Constant;
import taylor.math.Expression;
import taylor.math.function.NaturalLog;

public class Exponent extends Operation {
    
    public Exponent(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public double getY(double x) {
        return Math.pow(e1.getY(x),e2.getY(x));
    }
    
    @Override
    public Expression derive() {
        return new Addition(new Multiplication(new Multiplication(this,e2.derive()),new NaturalLog(e1)),
                new Multiplication(new Multiplication(new Exponent(e1,
                        new Subtraction(e2,new Constant(1))),e2),e1.derive()));
    }
    
    @Override
    public String toString() {
        return "(" + e1 + "^" + e2 + ")";
    }
    
    @Override
    public Expression simplify() {
        e1 = e1.simplify();
        e2 = e2.simplify();
        
        if (e1 instanceof Constant && e2 instanceof Constant)
            return new Constant(Math.pow(((Constant)e1).value,((Constant)e2).value));
        if (e1 instanceof Constant && ((Constant)e1).value == 0)
            return new Constant(0);
        if (e2 instanceof Constant && ((Constant)e2).value == 0)
            return new Constant(1);
        if (e1 instanceof Constant && ((Constant)e1).value == 1)
            return new Constant(1);
        if (e2 instanceof Constant && ((Constant)e2).value == 1)
            return e1;
        
        return this;
    }
}
