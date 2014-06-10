package taylor.math;

public class Variable extends Expression {
    
    public int coefficient;
    
    public Variable(int newCo) {
        coefficient = newCo;
    }
    
    @Override
    public int getY(int x) { return coefficient*x; }
    
    @Override
    public Expression derive() {
        return new Constant(coefficient);
    }
    
    @Override
    public String toString() {
        return coefficient + "x";
    }
}
