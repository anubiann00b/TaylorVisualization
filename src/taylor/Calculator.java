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
    
    public int sx = -10;
    public int sy = -10;
    public int ex = 10;
    public int ey = 10;
    
    public Graphics g;
    public int w;
    public int h;
    
    public void setEquation(String newEquation) { equation = newEquation; }

    public void render(Graphics graphics, int width, int height) {
        w = width;
        h = height;
        g = graphics;
        
        g.setColor(Color.black);
        g.drawRect(0,0,width-1,height-1);
        
        if (axis) {
            g.drawLine(width/2,0,width/2,height);
            g.drawLine(0,height/2,width,height/2);
        }
        
        if (equation != null)
            f = new Function(equation);
        
        if (f != null) {
            g.setColor(Color.red);
            int oldY = f.getY(sx);
            for (int i=sx+1;i<ex;i++) {
                int y = f.getY(i);
                drawLineScale(i,y,i-1,oldY);
                oldY = y;
            }
        }
    }
    
    public void drawLineScale(int x1, int y1, int x2, int y2) {
        g.drawLine((x1-sx)*(w-ex+sx),h-(y1-sy)*(h-ey+sy),(x2-sx)*(w-ex+sx),h-(y2-sy)*(h-ey+sy));
        //int xs = w/(ex-sx);
        //int ys = h/(ey-sy);
        //g.drawLine((x1-sx)*xs,(y1-sy)*ys,(x2-sx)*xs,(y2-sy)*ys);
    }
}
