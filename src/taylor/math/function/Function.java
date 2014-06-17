package taylor.math.function;

import taylor.math.Expression;

public abstract class Function extends Expression {

    public static Expression getFunction(String op, Expression e) {
        if (op.equals("s"))
            return new Sine(e);
        if (op.equals("c"))
            return new Cosine(e);
        if (op.equals("l"))
            return new NaturalLog(e);
        return null;
    }
    
    public Expression e;
    
    public Function(Expression en) {
        e = en;
    }
    
    @Override
    public boolean isValid(double x1, double x2) {
        return e.isValid(x1,x2);
    }
    
    @Override
    public Expression simplify() {
        e = e.simplify();
        return this;
    }
}
