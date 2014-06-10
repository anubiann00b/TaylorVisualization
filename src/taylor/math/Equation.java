package taylor.math;

public class Equation {
    
    private Term startingTerm;
    
    public Equation(Term t) {
        
    }
    
    public Equation getDerivative() {
        return new Equation(startingTerm.getDerivative());
    }
}
