package taylor;

import java.awt.Color;
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

    public void render(Graphics g, int width, int height) {
        if (equation != null)
            f = new Function(equation);
        if (f != null) {
            g.setColor(Color.red);
            int oldY = f.getY(0);
            for (int i=width/100;i<width;i+=width/100) {
                int y = f.getY(i);
                g.drawLine(i-width/100,height-oldY,i,height-y);
                oldY = y;
            }
        }
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
    }
}
