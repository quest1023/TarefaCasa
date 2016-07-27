
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

class UsuarioGuiEditar extends JPanel {
    
    private JLabel lbNome, lbLogin, lbSenha1, lbSenha2,lbTLogin;
    private JTextField tfNome, tfLogin, tfTLogin;
    private JPasswordField pfSenha1, pfSenha2;
    private JButton btEditar, btLimpar, btTestar;
    
    public UsuarioGuiEditar() {
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
        btEditar = new JButton("Editar");
        btLimpar = new JButton("Limpar");
        lbTLogin = new JLabel("Testar Login");
        tfTLogin  = new JTextField();
        btTestar = new JButton("Testar");
        
        lbNome.setBounds(30, 140, 80, 25);
        tfNome.setBounds(100, 140, 200, 25);
        lbLogin.setBounds(30, 180, 80, 25);
        tfLogin.setBounds(100, 180, 200, 25);
        lbSenha1.setBounds(30, 220, 80, 25);
        pfSenha1.setBounds(100, 220, 200, 25);
        lbSenha2.setBounds(30, 265, 80, 25);
        pfSenha2.setBounds(100, 265, 200, 25);
        btEditar.setBounds(30, 310, 100, 25);
        btLimpar.setBounds(235, 310, 100, 25);
        lbTLogin.setBounds(30, 30, 80, 25);
        tfTLogin.setBounds(120, 30, 200, 25);
        btTestar.setBounds(30, 60, 100, 25);
        
        tfNome.setEnabled(false);
        tfLogin.setEnabled(false);
        pfSenha1.setEnabled(false);
        pfSenha2.setEnabled(false);
        
        
        add(lbNome);
        add(tfNome);
       
        add(lbSenha1);
        add(pfSenha1);
        add(lbSenha2);
        add(pfSenha2);
        add(btEditar);
        add(btLimpar);
        add(lbTLogin);
        add(tfTLogin);
        add(btTestar);
    }

    private void setEvents() {
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        
        btTestar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController uc = new UsuarioController();
                if(uc.loginTest(tfTLogin.getText())){
                    JOptionPane.showMessageDialog(null, "Login encontrado");
                    tfNome.setEnabled(true);
                    pfSenha1.setEnabled(true);
                    pfSenha2.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Login não encontrado");
                }
            
            }
        });
        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController uc = new UsuarioController();
                uc.editar(tfNome.getText(), String.valueOf(pfSenha1.getPassword()), tfTLogin.getText());

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
