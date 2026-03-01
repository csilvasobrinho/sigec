
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Usuario;
import util.ConexaoBD;

public class UsuarioDAO {
    //Método para cadastrar usuário
    public static boolean cadastrarUsuarioDAO(Usuario usuario){
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO usuario(nome_completo, login, senha, codigo_Perfil_de_Acesso) VALUES (?, ?, ?, ?)";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setInt(4, usuario.getPerfilAcesso().getIdPerfilAcesso());
            
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o novo usuário!" + e.getMessage());
            return false;
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }
    // Método para atualizar usuário
    public void atualizarUsuario(int id_usuario, String novoNome, String novoLogin, String novaSenha, int novoCodigoPerfilAcesso) {
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        
        try{
            String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setInt(4, usuario.getPerfilAcesso().getIdPerfilAcesso());
            
        }
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, novoNome);
            stmt.setString(2, novaSenha);
            
            stmt.setInt(3, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para excluir usuário
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com o ID informado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}