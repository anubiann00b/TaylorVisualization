package taylor;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JTable;
import taylor.math.Constant;
import taylor.math.Equation;

public class Calculator {
    
    private String equation;
    
    private Equation f;
    
    public boolean axis = true;
    public boolean grid = false;
    public boolean coords = true;
    
    public int degree = 1;
    
    public int sx = -10;
    public int sy = -10;
    public int ex = 10;
    public int ey = 10;
    public int tableStep = 1;
    
    public Graphics g;
    public int w;
    public int h;
    
    public Color[] colors = { Color.black, Color.red, Color.blue, Color.green, Color.pink};
    
    public void setEquation(String newEquation) { equation = newEquation; }

    public void render(Graphics graphics, int width, int height) {
        w = width;
        h = height;
        g = graphics;
        
        g.setColor(colors[0]);
        g.drawRect(0,0,width-1,height-1);
        
        if (axis) {
            g.drawLine(width/2,0,width/2,height);
            g.drawLine(0,height/2,width,height/2);
        }
        
        if (equation != null)
            f = new Equation(equation);
        
        if (f != null) {
            Equation fd = new Equation(f);
            
            for (int j=0;j<degree;j++) {
                g.setColor(colors[(j+1)%colors.length]);
                double oldY = fd.getY(sx);
                double step = (ex-sx)/1000.0;
                for (double i=sx+step;i<=ex;i+=step) {
                    double y = fd.getY(i);
                    drawLineScale(i,y,i-step,oldY);
                    oldY = y;
                }
                if (fd.exp.equals(new Constant(0)))
                    break;
                fd = fd.derive();
            }
        }
    }
    
    public void drawLineScale(double x1, double y1, double x2, double y2) {
        g.drawLine((int)((x1-sx)*w/(ex-sx)),(int)(h-(y1-sy)*h/(ey-sy)),
                (int)((x2-sx)*w/(ex-sx)),(int)(h-(y2-sy)*h/(ey-sy)));
    }

    public void update(JTable t) {
        int row = 0;
        for (double i=sx;i<ex;i+=tableStep) {
            t.setValueAt(i,row,0);
            
            if (f != null) {
                t.setValueAt(f.getY(i),row,1);
                t.setValueAt(f.derive().getY(i),row,2);
            }
            row++;
        }
    }
}
