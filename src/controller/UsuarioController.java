package controller;

import dao.UsuarioDAO;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuarioController {
    Scanner sc = new Scanner(System.in);
    
    private final UsuarioDAO dao;
    
    public UsuarioController() {
        dao = new UsuarioDAO();
    }
    
    public boolean cadastrar(Usuario usuario) {
        if (dao.findByLogin(usuario.getLogin()) == null) {
            if (dao.create(usuario)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean login(String login, String senha) {
        Usuario usuario = dao.findByLogin(login);
        if (usuario != null && usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
    
        public boolean loginTest(String login) {
        Usuario usuario = dao.findByLogin(login);
        if (usuario != null && usuario.getLogin().equals(login)) {
            return true;
        }
        return false;
    }       
        
    
    public void editar(String nome, String Senha, String login ){
        
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(Senha);
        usuario.setLogin(login);
        dao.updateE(usuario);
        
    }

    
    public void deletar(String login){
        Usuario us = new Usuario();
        us.setLogin(login);
        dao.excluir(us);  
    }
    
    public void listarTudo(){
        UsuarioDAO udao = new UsuarioDAO();
        for(Usuario u: udao.findAll()){
            System.out.println("Id" + u.getId()+ "\tLogin" + u.getLogin() + "Senha" + u.getSenha() + "Nome" + u.getNome());
        }
    }
    
    public void buscarPorId(){}
    
    public void buscarPorLogin(String login){}
    
    
    
    
}
