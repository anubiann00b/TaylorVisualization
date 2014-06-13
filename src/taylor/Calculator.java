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
    
    public double sx = -10;
    public double sy = -10;
    public double ex = 10;
    public double ey = 10;
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
            drawLineScale(0,sy,0,ey);
            drawLineScale(sx,0,ex,0);
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
        int x = 0;
        for (int i=0;i<20;i++) {
            t.setValueAt(x,i,0);
            
            if (f != null) {
                t.setValueAt(f.getY(x),i,1);
                t.setValueAt(f.derive().getY(x),i,2);
            }
            x+=tableStep;
        }
    }
    
    public void zoom(int r) {
        sx -= r;
        sy -= r;
        ex += r;
        ey += r;
    }
    
    public void pan(int x, int y) {
        sx += x/20.0;
        sy -= y/20.0;
        ex += x/20.0;
        ey -= y/20.0;
    }
}
