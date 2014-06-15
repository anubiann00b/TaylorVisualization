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
    public double tableStep = 1;
    
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
        
        tableStep = (ex-sx)/20;
        
        if (axis) {
            drawLineScale(0,sy,0,ey);
            drawLineScale(sx,0,ex,0);
        }
        
        if (equation != null)
            f = new Equation(equation);
        
        if (f != null) {
            Equation fd = new Equation(f);
            
            for (int i=0;i<degree;i++) {
                if (i != 0)
                    fd = new Equation(f.getTaylorPolynomial(i,1));
                g.setColor(colors[(i+1)%colors.length]);
                double oldY = fd.getY(sx);
                double step = (ex-sx)/1000.0;
                for (double j=sx+step;j<=ex;j+=step) {
                    double y = fd.getY(j);
                    drawLineScale(j,y,j-step,oldY);
                    oldY = y;
                }
                if (fd.exp.equals(new Constant(0)))
                    break;
            }
        }
    }
    
    public void drawLineScale(double x1, double y1, double x2, double y2) {
        if (y1==Double.NaN || y2==Double.NaN || y1==Double.POSITIVE_INFINITY || y2==Double.POSITIVE_INFINITY
                || y1==Double.NEGATIVE_INFINITY || y2==Double.NEGATIVE_INFINITY)
            return;
        g.drawLine((int)((x1-sx)*w/(ex-sx)),(int)(h-(y1-sy)*h/(ey-sy)),
                (int)((x2-sx)*w/(ex-sx)),(int)(h-(y2-sy)*h/(ey-sy)));
    }
    
    public void update(JTable t) {
        double x = sx;
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
        sx -= tableStep*r;
        sy -= tableStep*r;
        ex += tableStep*r;
        ey += tableStep*r;
    }
    
    public void pan(int x, int y) {
        sx += tableStep*x/20.0;
        sy -= tableStep*y/20.0;
        ex += tableStep*x/20.0;
        ey -= tableStep*y/20.0;
    }
}
