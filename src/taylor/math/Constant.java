package taylor.math;

public class Constant extends Expression {
    
    public int value;
    
    public Constant(int newVal) {
        value = newVal;
    }
    
    @Override
    public int getY(int x) { return value; }
    
    @Override
    public Expression derive() {
        return new Constant(0);
    }
}
