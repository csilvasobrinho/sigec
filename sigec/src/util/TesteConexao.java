
package util;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conexao = ConexaoBD.conectar();
        
        if(conexao != null){
            System.out.println("Teste executado com sucesso!");
            ConexaoBD.fecharConexao(conexao);
        }else{
            System.out.println("Erro!");
        }
    }
}
