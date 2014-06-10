package taylor.math.operation;

import taylor.math.Expression;

public abstract class Operation extends Expression {
    
    public Expression exp1;
    public Expression exp2;
    
    public Operation(Expression e1, Expression e2) {
        exp1 = e1;
        exp2 = e2;
    }
}
