package taylor.math.function;

import taylor.math.Expression;

public abstract class Function extends Expression {

    public static Expression getFunction(String op, Expression e) {
        switch(op) {
            case "s":
                return new Sine(e);
            case "c":
                return new Cosine(e);
            case "l":
                return new NaturalLog(e);
            default:
                return null;
        }
    }
    
    public Expression e;
    
    public Function(Expression en) {
        e = en;
    }
    
    @Override
    public Expression simplify() {
        e = e.simplify();
        return this;
    }
}
