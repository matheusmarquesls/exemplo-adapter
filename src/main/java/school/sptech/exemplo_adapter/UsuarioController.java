package school.sptech.exemplo_adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<?>> listarUsuarios() {

        if (usuarios.isEmpty()){
            ResponseEntity.noContent();
        }
      return ResponseEntity.ok(usuarios);
    }



    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {

        if (usuario.getEmail() == null || usuario.getNome() == null || usuario.getSenha() == null){
         return ResponseEntity.status(400).build();
        }

        usuario.setId(UUID.randomUUID());
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(usuarios);

    }


    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestBody Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getSenha() == null) {
            return ResponseEntity.badRequest().build();
        }

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(usuario.getEmail()) && u.getSenha().equals(usuario.getSenha())) {
                u.setAutenticado(true);
                return ResponseEntity.ok(u);
            }
        }

        return ResponseEntity.status(401).build();
    }
}
