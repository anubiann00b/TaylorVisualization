package taylor.math.operation;

import taylor.math.Expression;

public class Addition extends Operation {
    
    public Addition(Expression exp1, Expression exp2) {
        super(exp1,exp2);
    }
    
    @Override
    public int getY(int x) {
        return exp1.getY(x) + exp2.getY(x);
    }
    
    @Override
    public Expression derive() {
        return new Addition(exp1.derive(),exp2.derive());
    }
}