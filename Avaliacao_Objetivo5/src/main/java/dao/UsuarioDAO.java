package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDAO{

    public static List<Usuario> selecionarUsuarios() {
        final String sql = "SELECT * FROM usuario ORDER BY nome";
        try
                (
                        Connection conn = getConnection();
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        ResultSet rs = pstmt.executeQuery();
                )
        {
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(resultsetToUsuario(rs));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Usuario selecionarUsuarioId(Long id) {
        final String sql = "SELECT * FROM usuario WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            Usuario usuario = null;
            if (rs.next()) {
                usuario = resultsetToUsuario(rs);
            }
            rs.close();
            return usuario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<Usuario> selecionarUsuariosNome(String nome) {
        final String sql = "SELECT * FROM usuario WHERE nome LIKE ? ORDER BY nome";
        try
                (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, nome.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(resultsetToUsuario(rs));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Usuario> selecionarUsuariosEmail(String email) {
        final String sql = "SELECT * FROM usuario WHERE email LIKE ? ORDER BY nome";
        try
                (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, email.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(resultsetToUsuario(rs));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Usuario> selecionarUsuariosTelefone(String telefone) {
        final String sql = "SELECT * FROM usuario WHERE telefone LIKE ? ORDER BY nome";
        try
                (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, telefone.toLowerCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while (rs.next()) {
                usuarios.add(resultsetToUsuario(rs));
            }
            return usuarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean inserirUsuario(Usuario usuario) {
        final String sql = "INSERT INTO usuario (nome, email, telefone) VALUES (?, ?, ?)";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean alterarUsuario(Usuario usuario) {
        final String sql = "UPDATE usuario SET nome=?, email=?, telefone=? WHERE id=?";
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
        )
        {
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getTelefone());
            pstmt.setLong(4, usuario.getId());
            int count = pstmt.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deletarUsuario(long id) {
        final String sql = "DELETE FROM usuario WHERE id=?";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setLong(1, id);
            int count = pstmt.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Usuario resultsetToUsuario(ResultSet rs) throws SQLException {
        Usuario user = new Usuario();
        user.setId(rs.getLong("id"));
        user.setNome(rs.getString("nome"));
        user.setEmail(rs.getString("email"));
        user.setTelefone(rs.getString("telefone"));
        return user;
    }
}
