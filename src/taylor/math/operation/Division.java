package taylor.math.operation;

import taylor.math.Expression;

public class Division extends Operation {
    
    public Division(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public double getY(double x) {
        if (exp2.getY(x) == 0)
            return exp1.getY(x) > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        return exp1.getY(x) / exp2.getY(x);
    }
    
    @Override
    public Expression derive() {
        return new Division(new Subtraction(new Multiplication(exp1.derive(),exp2),
                new Multiplication(exp1,exp2.derive())),
                new Multiplication(exp2,exp2));
    }
    
    @Override
    public String toString() {
        return "(" + exp1 + "/" + exp2 + ")";
    }
}
