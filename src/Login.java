import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Login extends JDialog {
    private JPanel contentPane;
    private JButton button1;
    private JLabel Rol;
    private JTextField usuarioTextField;
    private JPasswordField contraseñaPasswordField;
    private JComboBox rolComboBox;
    private JLabel mensaje;
    private JButton buttonOK;

    int index=0;

    String imgs[] = {
            "Imagenes/Supermercado.png", //Selleccion 0
            "Imagenes/Administrador.png",// 1
            "Imagenes/Cajero.png"// 2
    };

    String msj[] = {
            "",
            "Ingresando como Administrador",
            "Ingresando como Cajero"
    };

    public Login() {
        seleccionRol();

        rolComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                index = rolComboBox.getSelectedIndex();
                seleccionRol();
            }
        });





    }

    public void seleccionRol(){
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgs[index]));
        Rol.setIcon(new ImageIcon(img));
        mensaje.setText(msj[index]);
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Ventana Login");
        frame.setContentPane(new Login().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
