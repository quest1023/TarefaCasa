package view;

import controller.UsuarioController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Principal extends JFrame {

    private static Principal frame;
    private JLabel lbLogin, lbSenha;
    private JTextField tfLogin;
    private JPasswordField pfSenha;
    private JButton btLogar, btCancelar;

    public Principal() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Login no Sistema");
        setBounds(0, 0, 250, 200);
        setLayout(null);
        
        lbLogin = new JLabel("Login:");
        lbSenha = new JLabel("Senha:");
        tfLogin = new JTextField(5);
        pfSenha = new JPasswordField(5);
        btLogar = new JButton("Entrar");
        btCancelar = new JButton("Cancelar");
        
        lbLogin.setBounds(30, 30, 80, 25);
        lbSenha.setBounds(30, 75, 80, 25);
        tfLogin.setBounds(100, 30, 120, 25);
        pfSenha.setBounds(100, 75, 120, 25);
        btLogar.setBounds(20, 120, 100, 25);
        btCancelar.setBounds(125, 120, 100, 25);
        
        add(lbLogin);
        add(lbSenha);
        add(tfLogin);
        add(pfSenha);
        add(btLogar);
        add(btCancelar);
        
        tfLogin.requestFocus();
    }
    
    private void definirEventos() {
        btLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pfSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logar();
            }
        });
        
    }
    
    private void limpar() {
        tfLogin.setText("");
        pfSenha.setText("");
        tfLogin.requestFocus();
    }
    
    private void logar() {
        String login = tfLogin.getText();
        String senha = String.valueOf(pfSenha.getPassword());
        UsuarioController controller = new UsuarioController();
        if (controller.login(login, senha)) {
            frame.setVisible(false);
            UsuarioGUI.run();
        } else {
            JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
            limpar();
        }
    }
   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new Principal();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
                int x = (tela.width - frame.getSize().width) / 2;
                int y = (tela.height - frame.getSize().height) / 2;
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        });
    }
    
}
