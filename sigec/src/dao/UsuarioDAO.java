
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
    
}