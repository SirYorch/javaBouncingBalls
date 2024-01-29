
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Panel extends JPanel 
{
    private JButton inicioButton;
    //private Pelota pelota;
    private List<Pelota> pelotas;
    
    public Panel() 
    {
        setPreferredSize(new Dimension(800, 500));
        initComponents();
        
        pelotas = new ArrayList<>();
        
    }
    
    private void initComponents() 
    {
        setLayout(null);
        inicioButton = new JButton("Inicio");
        
        inicioButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                iniciarAnimacion();
                repaint();
            }
        });
        
        add(inicioButton);
    }
    
    private void iniciarAnimacion() 
    {
        Color colorAleatorio = obtenerColorAleatorio();
        Pelota nuevaPelota = new Pelota(this, colorAleatorio);
        pelotas.add(nuevaPelota);
        nuevaPelota.start();
    }
    
    private Color obtenerColorAleatorio() 
    {
        //representacion de color rgb
        
        return new Color((int) (Math.random() * 256),(int) (Math.random() * 256),(int) (Math.random() * 256));
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        for (Pelota pelota : pelotas) 
        {
            //Color colorAleatorio = obtenerColorAleatorio();
            //pelota.setColor(colorAleatorio);
            pelota.dibujarPelota(g);
        }
        
        inicioButton.setBounds(10, getHeight() - 40, 80, 30);
    }
}
