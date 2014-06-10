package taylor;

import java.awt.Graphics;
import taylor.math.Function;

public class Calculator {
    
    private String equation;
    
    private Function f;
    
    public boolean axis = true;
    public boolean grid = false;
    public boolean coords = true;
    
    public Calculator() {
        equation = null;
    }
    
    public void setEquation(String newEquation) { equation = newEquation; }

    public void render(Graphics g) {
        if (equation != null)
            f = new Function(equation);
        g.drawRect(0,0,50,50);
    }
}
