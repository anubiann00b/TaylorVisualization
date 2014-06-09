package taylor;

import java.awt.Graphics;

public class Calculator {
    
    private String equation;
    private String oldEquation;
    
    private boolean axis;
    private boolean grid;
    private boolean coords;
    
    public void setAxis(boolean axis) { this.axis = axis; }
    public void setGrid(boolean grid) { this.grid = grid; }
    public void setCoords(boolean coords) { this.coords = coords; }
    
    public Calculator() {
        oldEquation = null;
        equation = "";
    }
    
    public void setEquation(String newEquation) { oldEquation = equation; equation = newEquation; }

    public void render(Graphics g) {
        oldEquation = equation;
        if (equation.equals(oldEquation)) {
            g.drawRect(0,0,50,50);
        }
    }
}
