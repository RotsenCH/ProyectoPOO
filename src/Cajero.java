import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cajero extends JDialog {
    public JPanel cajero_panel;
    private JButton regresarL;
    private JPanel panel1;
    private JButton buscar;
    private JSpinner cantidadSPN;
    private JButton agregar;
    private JButton eliminar;
    private JTable table1;
    private JTable table2;
    private JTextField idprodTXT;
    private JLabel mensajeTXT;
    private JButton clienteButton;
    private JButton facturarButton;
    private JTextField NOMProdTXT;
    private JTextField precioVenTXT;

    public Cajero(JFrame cajer){
        super(cajer);
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Imagenes/LOGO.png"));
        setIconImage(img);
        setContentPane(cajero_panel);
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
