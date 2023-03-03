import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clientes extends Login {
    private JPanel clientes1;
    private JTextField textField1;
    private JTextField textFieldNom_Cli;
    private JTextField textFieldApell_Cli;
    private JTextField textFieldCorreo_Cli;
    private JTextField textFieldTlf_Cli;
    private JTextField textFieldDirec_Cli;
    private JLabel Mensajelabel;
    private JPanel clientes2;
    private JButton buscar;
    private JButton agregar;
    private JButton eliminar;
    private JButton regresarL;
    private JButton modificar;
    private JButton aceptar;

    public Clientes(JFrame client, int ind){
        super(client);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/LOGO.png"));
        setIconImage(img);
        setLocationRelativeTo(null);
        setContentPane(clientes1);
        pack();
        setVisible(true);

        regresarL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cajero cajero = new Cajero(null,ind);
            }
        });

        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cajero cajero = new Cajero(null,ind);
            }
        });
    }

}
