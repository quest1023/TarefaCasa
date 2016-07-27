package view;

import controller.UsuarioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Usuario;

public class UsuarioCadastrarGUI extends JPanel {
    
    private JLabel lbNome, lbLogin, lbSenha1, lbSenha2;
    private JTextField tfNome, tfLogin;
    private JPasswordField pfSenha1, pfSenha2;
    private JButton btCadastrar, btLimpar;
    
    public UsuarioCadastrarGUI() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbNome = new JLabel("Nome:");
        lbLogin = new JLabel("Login:");
        lbSenha1 = new JLabel("Senha:");
        lbSenha2 = new JLabel("Confirma:");
        tfNome = new JTextField();
        tfLogin = new JTextField();
        pfSenha1 = new JPasswordField();
        pfSenha2 = new JPasswordField();
        btCadastrar = new JButton("Cadastrar");
        btLimpar = new JButton("Limpar");
        
        lbNome.setBounds(30, 30, 80, 25);
        tfNome.setBounds(100, 30, 200, 25);
        lbLogin.setBounds(30, 75, 80, 25);
        tfLogin.setBounds(100, 75, 200, 25);
        lbSenha1.setBounds(30, 120, 80, 25);
        pfSenha1.setBounds(100, 120, 200, 25);
        lbSenha2.setBounds(30, 165, 80, 25);
        pfSenha2.setBounds(100, 165, 200, 25);
        btCadastrar.setBounds(30, 210, 100, 25);
        btLimpar.setBounds(135, 210, 100, 25);
        
        
        add(lbNome);
        add(tfNome);
        add(lbLogin);
        add(tfLogin);
        add(lbSenha1);
        add(pfSenha1);
        add(lbSenha2);
        add(pfSenha2);
        add(btCadastrar);
        add(btLimpar);
    }

    private void setEvents() {
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        btCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController controller = new UsuarioController();
                if (controller.cadastrar(new Usuario(tfLogin.getText(), String.valueOf(pfSenha1.getPassword()), tfNome.getText()))) {
                    JOptionPane.showMessageDialog(null, "Usuario cadastrado!");
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado!");
                }
                
            }
        });
    }
    
    private void limpar() {
        tfNome.setText("");
        tfLogin.setText("");
        pfSenha1.setText("");
        pfSenha2.setText("");
        tfNome.requestFocus();
    }
    
}
