
import javax.swing.JFrame;

public class Inicio extends JFrame
{
    private Panel panel;
    
    public Inicio() 
    {
        initComponents();
    }
    
    private void initComponents() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Animación de Pelota");

        panel = new Panel();
        add(panel);

        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                Inicio ventana = new Inicio();
                ventana.setVisible(true);
            }
        });
    }
    
}
