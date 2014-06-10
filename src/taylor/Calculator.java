package taylor;

import java.awt.Graphics;

public class Calculator {
    
    private String equation;
    
    public boolean axis = true;
    public boolean grid = false;
    public boolean coords = true;
    
    public Calculator() {
        equation = "";
    }
    
    public void setEquation(String newEquation) { equation = newEquation; }

    public void render(Graphics g) {
        g.drawRect(0,0,50,50);
    }
}
