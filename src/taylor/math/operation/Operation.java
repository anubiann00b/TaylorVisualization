package taylor.math.operation;

import taylor.math.Expression;

public abstract class Operation extends Expression {

    public static Expression getOperation(String op, Expression e1, Expression e2) {
        if (op.equals("+"))
            return new Addition(e1,e2);
        if (op.equals("*"))
            return new Multiplication(e1,e2);
        if (op.equals("-"))
            return new Subtraction(e1,e2);
        if (op.equals("/"))
            return new Division(e1,e2);
        if (op.equals("^"))
            return new Exponent(e1,e2);
        return null;
    }
    
    public Expression e1;
    public Expression e2;
    
    @Override
    public boolean isValid(double x1, double x2) {
        return e1.isValid(x1,x2) && e2.isValid(x1,x2);
    }
    
    public Operation(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}
