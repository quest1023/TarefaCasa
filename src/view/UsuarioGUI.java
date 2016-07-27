package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UsuarioGUI extends JFrame {

    private Container contentPane;
    private JMenuBar mnBarra;
    private JMenu mnArquivo;
    private JMenuItem miCadastrar, miEditar, miExcluir, miSair;
    
    public UsuarioGUI() {
        inicializarComponentes();
        definirEventos();
    }
    
    private void inicializarComponentes() {
        setTitle("Menu Principal");
        setBounds(0, 0, 800, 600);
        contentPane = getContentPane();
        
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        miCadastrar = new JMenuItem("Cadastrar");
        miEditar = new JMenuItem("Editar");
        miExcluir = new JMenuItem("Excluir");
        miSair = new JMenuItem("Sair");
        
        mnArquivo.setMnemonic('A');
        
        mnArquivo.add(miCadastrar);
        mnArquivo.add(miEditar);
        mnArquivo.add(miExcluir);
        mnArquivo.add(miSair);
        
        mnBarra.add(mnArquivo);
        setJMenuBar(mnBarra);
    }
    
    private void definirEventos() {
        miSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioCadastrarGUI cadastrar = new UsuarioCadastrarGUI();
                contentPane.removeAll();
                contentPane.add(cadastrar);
                contentPane.validate();
            }
        });
        miEditar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioGuiEditar editar = new UsuarioGuiEditar();
                contentPane.removeAll();
                contentPane.add(editar);
                contentPane.validate();
                }
        });
        
        miExcluir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioExcluirGui excluir = new UsuarioExcluirGui();
                contentPane.removeAll();
                contentPane.add(excluir);
                contentPane.validate();                
            }
        });
        
    }
    
        
    
    public static void run() {
        UsuarioGUI frame = new UsuarioGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tela.width - frame.getSize().width) / 2;
        int y = (tela.height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
    
}
