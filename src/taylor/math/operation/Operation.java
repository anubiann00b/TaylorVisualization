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
            case "^":
                return new Exponent(e1,e2);
            default:
                return null;
        }
    }
    
    public Expression e1;
    public Expression e2;
    
    public Operation(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
}
