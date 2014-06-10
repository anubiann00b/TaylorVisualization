package taylor.math;

public class Term {
    
    public Term next;
    
    public int mult;
    public int exp;
    public Function op;
    
    public Term(Function op, int mult, int exp) {
        this.op = op;
        this.mult = mult;
        this.exp = exp;
    }
    
    public Term getDerivative() {
        return op.getDerivative(this);
    }
}
