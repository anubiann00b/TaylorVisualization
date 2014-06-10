package taylor.math;

import java.util.ArrayList;
import java.util.List;

public class Equation {
    
    private List<Term> terms;
    
    public Equation(String e) {
        terms = new ArrayList<Term>();
        StringBuilder sb = new StringBuilder();
        String[] split = e.split(" ");
        for (String s : split) {
            sb.append(s);
        }
        String eq = sb.toString();
        
        int index = 0;
        
        for (int i=0;i<eq.length();i++) {
            if (eq.charAt(i) == '+') {
                terms.add(new Term(eq.substring(index,i),Operator.ADD));
            }
        }
        String[] parts = eq.split("[+-/*]");
        
        for (String s : parts) {
            //terms.add(new Term(s));
        }
    }
    
    public Equation getDerivative() {
        return null;
        //return new Equation(startingTerm.getDerivative());
    }
}
