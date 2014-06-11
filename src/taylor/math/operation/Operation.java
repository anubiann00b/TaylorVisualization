package taylor.math.operation;

import taylor.math.Expression;

public abstract class Operation extends Expression {

    public static Expression getOperation(String op, Expression e1, Expression e2) {
        switch(op) {
            case "+":
                return new Addition(e1,e2);
            case "*":
                return new Multiplication(e1,e2);
            case "-":
                return new Subtraction(e1,e2);
            case "/":
                return new Division(e1,e2);
            default:
                return null;
        }
    }
    
    public Expression exp1;
    public Expression exp2;
    
    public Operation(Expression e1, Expression e2) {
        exp1 = e1;
        exp2 = e2;
    }
}
