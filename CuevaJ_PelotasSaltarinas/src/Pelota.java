
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Pelota extends Thread
{
    private final Panel panel;
    private Color color;
    private int x, y, velocidadX, velocidadY;
    
    public Pelota(Panel panel, Color color) 
    {
        this.panel = panel;
        this.color = color;
        this.x = (int) Math.round(Math.random()*(panel.getWidth()-30));
        this.y =(int) Math.round(Math.random()*(panel.getHeight()-30));
        int dir1 = (int) Math.round(Math.random()*11);
        int dir2 = (int) Math.round(Math.random()*11);
        if(dir1 >5){this.velocidadX = (int) Math.round(Math.random()*10);} else{
            {this.velocidadX = (int) Math.round(Math.random()*-10);}
        }
        if(dir2 >5){this.velocidadY = (int) Math.round(Math.random()*10);} else{
            {this.velocidadY = (int) Math.round(Math.random()*-10);}
        }
        
    }
    
    @Override
    public void run() 
    {
        while (true) 
        {
            moverPelota();
            panel.repaint();
            
            try 
            {
                Thread.sleep(15);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    private void moverPelota() 
    {
        x += velocidadX;
        y += velocidadY;
        
        if (x < 0 || x > panel.getWidth() - 30) 
        {
            velocidadX = -velocidadX;
        }
        
        if (y < 0 || y > panel.getHeight() - 30) 
        {
            velocidadY = -velocidadY;
        }
    }
    
    public void dibujarPelota(Graphics g) 
    {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }
}
