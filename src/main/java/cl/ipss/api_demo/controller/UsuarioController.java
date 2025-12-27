package cl.ipss.api_demo.controller;

import cl.ipss.api_demo.model.ColeccionModel;
import cl.ipss.api_demo.model.LaminaModel;
import cl.ipss.api_demo.repository.ColeccionRepository;
import cl.ipss.api_demo.repository.LaminaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final ColeccionRepository coleccionRepository;
    private final LaminaRepository laminaRepository;

    @GetMapping("/{usuarioId}/laminas")
    public List<LaminaModel> obtenerLaminas(@PathVariable Long usuarioId){
        return coleccionRepository.findByUsuarioUsuarioId(usuarioId)
                .stream()
                .map(ColeccionModel::getAlbum)
                .flatMap(a -> laminaRepository.findByAlbumAlbumId(a.getAlbumId()).stream())
                .toList();
    }

    @GetMapping("/{usuarioId}/laminas/contar")
    public Map<String, Object> contarLaminasUsuario(@PathVariable Long usuarioId){

    List<ColeccionModel> colecciones = coleccionRepository.findByUsuarioUsuarioId(usuarioId);

    int total = colecciones.stream()
            .map(ColeccionModel::getAlbum)
            .mapToInt(a -> laminaRepository.countByAlbumAlbumId(a.getAlbumId()))
            .sum();

    Map<String, Object> respuesta = new HashMap<>();
    respuesta.put("usuarioId", usuarioId);
    respuesta.put("total_laminas", total);

    return respuesta;
    }
}
