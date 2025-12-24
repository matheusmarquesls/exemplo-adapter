package school.sptech.exemplo_adapter.dto;

import school.sptech.exemplo_adapter.Usuario;

import java.util.UUID;

public class UsuarioResponseDto {

    private UUID id;
    private String nome;
    private String email;
    private boolean autenticado;

    public static UsuarioResponseDto toResponseDto(Usuario entity) {
        UsuarioResponseDto dto = new UsuarioResponseDto();
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        dto.setAutenticado(entity.isAutenticado());
        return dto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}