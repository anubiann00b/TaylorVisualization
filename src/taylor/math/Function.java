package taylor.math;

public class Function {
    
    public Expression exp;
    
    public Function(String s) {
        
    }
    
    public int getY(int x) {
        return exp.getY(x);
    }
}
