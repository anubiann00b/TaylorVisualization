package taylor.math;

public abstract class Expression {
    
    public abstract Expression derive();
    public abstract double getY(double x);
    public abstract Expression simplify();
    public boolean hasDerivative(double x) { return true; }
    
    @Override
    public boolean equals(Object o) {
        if (o==null || !(o instanceof Expression))
            return false;
        
        return ((Expression)o).toString().equals(toString());
    }

    public boolean isValid(double x1, double x2) {
        return true;
    }
}
