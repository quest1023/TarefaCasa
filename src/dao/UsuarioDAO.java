package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    private final DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public UsuarioDAO() {
        db = new DataBase();
    }
    
    public boolean create(Usuario usuario) {
        if (db.open()) {
            sql = "INSERT INTO tb_login (log_login, log_senha, log_nome) VALUES (?, ?, ?)";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, usuario.getLogin());
                ps.setString(2, usuario.getSenha());
                ps.setString(3, usuario.getNome());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
                ps.close();
                db.close();
            } catch (SQLException error) {
                System.out.println("Erro: " + error.toString());
                return false;
            }
        }
        return false;
    }
    
    public boolean delete(Usuario usuario) {
        if (db.open()) {
            sql = "DELETE FROM tb_login WHERE log_id = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, usuario.getId());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
                ps.close();
                db.close();
            } catch (SQLException error) {
                return false;
            }
        }
        return false;
    }
    
        public boolean excluir(Usuario usuario) {
        if (db.open()) {
            sql = "DELETE FROM tb_login WHERE log_login = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, usuario.getLogin());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
                ps.close();
                db.close();
            } catch (SQLException error) {
                return false;
            }
        }
        return false;
    }
    
    public boolean update(Usuario usuario) {
        if (db.open()) {
            sql = "UPDATE tb_login SET log_senha = ?, log_nome = ? WHERE log_id = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, usuario.getSenha());
                ps.setString(2, usuario.getNome());
                ps.setInt(3, usuario.getId());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
                ps.close();
                db.close();
            } catch (SQLException error) {
                return false;
            }
        }
        return false;
    }
    
        public boolean updateE(Usuario usuario) {
        if (db.open()) {
            sql = "UPDATE tb_login SET log_senha = ?, log_nome = ? WHERE log_login = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, usuario.getSenha());
                ps.setString(2, usuario.getNome());
                ps.setString(3, usuario.getLogin());
                if (ps.executeUpdate() == 1) {
                    ps.close();
                    db.close();
                    return true;
                }
                ps.close();
                db.close();
            } catch (SQLException error) {
                return false;
            }
        }
        return false;
    }
    
    public List<Usuario> findAll() {
        if (db.open()) {
            List<Usuario> usuarios = new ArrayList();
            sql = "SELECT * FROM tb_login";
            try {
                ps = db.connection.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("log_id"), rs.getString("log_login"), rs.getString("log_senha"), rs.getString("log_nome"));
                    usuarios.add(usuario);
                }
                rs.close();
                ps.close();
                db.close();
                return usuarios;
            } catch (SQLException error) {
                return null;
            }
        }
        return null;
    }
    
    public Usuario findById(int id) {
        if (db.open()) {
            sql = "SELECT * FROM tb_login WHERE log_id = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("log_id"), rs.getString("log_login"), rs.getString("log_senha"), rs.getString("log_nome"));
                    rs.close();
                    ps.close();
                    db.close();
                    return usuario;
                }
                rs.close();
                ps.close();
                db.close();
            } catch (SQLException error) {
                return null;
            }
        }
        return null;
    }
    
    public Usuario findByLogin(String login) {
        if (db.open()) {
            sql = "SELECT * FROM tb_login WHERE log_login = ?";
            try {
                ps = db.connection.prepareStatement(sql);
                ps.setString(1, login);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("log_id"), rs.getString("log_login"), rs.getString("log_senha"), rs.getString("log_nome"));
                    rs.close();
                    ps.close();
                    db.close();
                    return usuario;
                }
                rs.close();
                ps.close();
                db.close();
            } catch (SQLException error) {
                return null;
            }
        }
        return null;
    }
    
}