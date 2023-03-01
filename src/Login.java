import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class Login extends JDialog {
    PreparedStatement ps;
    private JPanel contentPane;
    private JButton ingresarButton;
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

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try {
                    con = getConection();

                    String id = String.valueOf(index);
                    String usuario = usuarioTextField.getText();
                    String contra = String.valueOf(contraseñaPasswordField.getPassword());

                    if (id.equals("0")) {
                        mensaje.setText("No haz ingresado un tipo de rol");
                    } else {
                        user = getValidacion(id,usuario,contra);

                        if (user != null) {
                            mensaje.setText("Cuenta correcta");
                        }
                        else {
                            mensaje.setText("Usuario o Contraseña Inválidos");
                            usuarioTextField.setText("");
                            contraseñaPasswordField.setText("");
                        }
                    }
                    con.close();

                } catch (HeadlessException | SQLException f) {
                    System.err.println(f);
                }
            }
        });

    }

    public Usuario user;
    private Usuario getValidacion(String id, String usuario, String contra) {
        Usuario user = null;
        Connection con;
        try{
            con = getConection();


            ps = con.prepareStatement("SELECT * FROM USUARIOS where idroles =? and usuario =? and contrasenia = ?;");
            ps.setString(1, id);
            ps.setString(2, usuario);
            ps.setString(3, contra);
            ResultSet rs = ps.executeQuery();

            if (rs .next()) {
                user = new Usuario();
                /*user.idsuario = resultSet.getString("name");
                user.idrol = resultSet.getString("email");
                user.usuario = resultSet.getString("phone");
                user.contrasena = resultSet.getString("address");*/
            }

            con.close();

        }catch (HeadlessException | SQLException f) {
            System.err.println(f);
        }

        return user;
    }

    public void seleccionRol(){
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgs[index]));
        Rol.setIcon(new ImageIcon(img));
        mensaje.setText(msj[index]);
    }

    public static Connection getConection(){
        Connection con = null;
        String url = "jdbc:mysql://localhost/quickmarket",
                user = "root",
                password = "UGPCUGR2002";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }

    public static void main(String[] args) {
        JFrame frame =new JFrame("Ventana Login");
        frame.setContentPane(new Login().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
