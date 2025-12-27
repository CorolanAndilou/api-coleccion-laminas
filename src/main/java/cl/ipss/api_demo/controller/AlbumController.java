package cl.ipss.api_demo.controller;

import cl.ipss.api_demo.model.AlbumModel;
import cl.ipss.api_demo.model.LaminaModel;
import cl.ipss.api_demo.repository.LaminaRepository;
import cl.ipss.api_demo.service.AlbumService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor

public class AlbumController {
    private final AlbumService albumService;
    private final LaminaRepository laminaRepository;

    @PostMapping
    public AlbumModel crear(@RequestBody AlbumModel album){
        return albumService.crearAlbum(album);
    }

    @GetMapping
    public List<AlbumModel> listar(){
        return albumService.listar();
    }

    @GetMapping("/{id}")
    public AlbumModel obtener(@PathVariable Long id){
        return albumService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AlbumModel actualizar(@PathVariable Long id, @RequestBody AlbumModel album){
        return albumService.actualizarAlbum(id, album);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        albumService.eliminarAlbum(id);
    }

    @PostMapping("/{albumId}/completar/{usuarioId}")
    public boolean completar(@PathVariable Long albumId, @PathVariable Long usuarioId){
        return albumService.completarAlbum(albumId, usuarioId);
    }

    @GetMapping("/{albumId}/laminas")
    public ResponseEntity<List<LaminaModel>> obtenerLaminasDeAlbum(@PathVariable Long albumId) {
    List<LaminaModel> laminas = laminaRepository.findByAlbumAlbumId(albumId);

    if (laminas.isEmpty()) {
        return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(laminas);
    }


}
