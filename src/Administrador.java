import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador extends JDialog{
    public JPanel admin;
    private JButton regresarL;
    private JButton agregar;

    public Administrador(JFrame adm){
        super(adm);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/LOGO.png"));
        setIconImage(img);
        setContentPane(admin);
        setLocationByPlatform(true);
        pack();
        setVisible(true);
        regresarL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login(null);
            }
        });
    }

}
