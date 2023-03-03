import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Administrador extends Login{
    public JPanel admin;
    private JButton regresarL;
    private JButton cajeroButton;
    private JButton bodega_button;

    public Administrador(JFrame adm, int ind){
        super(adm);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/LOGO.png"));
        setIconImage(img);
        setLocationRelativeTo(null);
        setContentPane(admin);
        pack();
        setVisible(true);
        regresarL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login(null);
            }
        });

        cajeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cajero cajero = new Cajero(null, ind);
            }
        });

        bodega_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Bodega bodg = new Bodega(null, ind);
            }
        });
    }

}
