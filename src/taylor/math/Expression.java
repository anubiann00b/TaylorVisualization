package taylor.math;

public abstract class Expression {
    
    public abstract Expression derive();
    public abstract int getY(int x);
}
