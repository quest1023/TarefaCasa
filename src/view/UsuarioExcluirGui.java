
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

public class UsuarioExcluirGui extends JPanel {
    
    private JLabel lbTLogin;
    private JTextField  tfTLogin;
   
    private JButton btExcluir, btTestar;
    
    public UsuarioExcluirGui() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);


        btExcluir = new JButton("Excluir");
        lbTLogin = new JLabel("Testar Login");
        tfTLogin  = new JTextField();
        btTestar = new JButton("Testar");
        
        btExcluir.setEnabled(false);
        

        btExcluir.setBounds(30, 310, 100, 25);
        lbTLogin.setBounds(30, 30, 80, 25);
        tfTLogin.setBounds(120, 30, 200, 25);
        btTestar.setBounds(30, 60, 100, 25);
        

        
        

        add(btExcluir);
        add(lbTLogin);
        add(tfTLogin);
        add(btTestar);
    }

    private void setEvents() {
        
        btTestar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController uc = new UsuarioController();
                if(uc.loginTest(tfTLogin.getText())){
                    JOptionPane.showMessageDialog(null, "Login encontrado");
                    btExcluir.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Login não encontrado");
                }
            
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController uc = new UsuarioController();
                uc.deletar(tfTLogin.getText());

            }
        });
    }
    
}
