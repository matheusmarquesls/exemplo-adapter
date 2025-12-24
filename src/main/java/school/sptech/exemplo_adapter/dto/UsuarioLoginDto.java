package school.sptech.exemplo_adapter.dto;

import jakarta.validation.constraints.NotBlank;

public class UsuarioLoginDto {

    @NotBlank
    private String usuario;
    @NotBlank
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
