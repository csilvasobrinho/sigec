
package util;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdb:mysql://localhost:3306/sigec";
    private static final String USUARIO = "root";
    private static final String SENHA = "12345678";
    
    Connection conexao = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public static Connection conectar(){
            Connection conexao = null;
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.err.println("Conexão com o bando de dados estabelecida com sucesso!");
            }catch(SQLException e){
                System.out.println("Erro ao conectar com o Banco de Dados!" + e.getMessage());
            }catch(ClassNotFoundException ex){
                System.out.println("Erro ao carregar o driver JDBC" + ex.getMessage());
            }
            return conexao;
    }
    public static void fecharConexao(Connection conexao){
        if(conexao != null){
            try {
                conexao.close();
                System.out.println("Conexao com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados!" + e.getMessage());
            }
        }
    }
    public static void fecharConexao(Connection conexao, PreparedStatement pstmt){
        if(conexao != null && pstmt != null){
            try {
                conexao.close();
                pstmt.close();
                System.out.println("Conexao com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados!" + e.getMessage());
            }
        }
    }
    public static void fecharConexao(Connection conexao, PreparedStatement pstmt,ResultSet rs){
        if(conexao != null && pstmt != null && rs != null){
            try {
                conexao.close();
                pstmt.close();
                rs.close();
                System.out.println("Conexao com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão com o banco de dados!" + e.getMessage());
            }
        }
    }
}
