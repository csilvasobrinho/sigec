
package model;

public class PerfilAcesso {
    private int idPerfilAcesso;
    private String tipoPerfil;

    public PerfilAcesso() {
    }

    public PerfilAcesso(int idPerfilAcesso, String tipoPerfil) {
        this.idPerfilAcesso = idPerfilAcesso;
        this.tipoPerfil = tipoPerfil;
    }

    public int getIdPerfilAcesso() {
        return idPerfilAcesso;
    }

    public void setIdPerfilAcesso(int idPerfilAcesso) {
        this.idPerfilAcesso = idPerfilAcesso;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }
    
}
