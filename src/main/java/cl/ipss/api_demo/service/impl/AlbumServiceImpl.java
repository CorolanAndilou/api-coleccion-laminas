package cl.ipss.api_demo.service.impl;

import cl.ipss.api_demo.model.*;
import cl.ipss.api_demo.repository.AlbumRepository;
import cl.ipss.api_demo.repository.ColeccionRepository;
import cl.ipss.api_demo.repository.LaminaRepository;
import cl.ipss.api_demo.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final LaminaRepository laminaRepository;
    private final ColeccionRepository coleccionRepository;


    @Override
    public AlbumModel crearAlbum(AlbumModel album) {
        return albumRepository.save(album);
    }

    @Override
    public AlbumModel actualizarAlbum(Long id, AlbumModel album) {
        AlbumModel a = albumRepository.findById(id).orElseThrow();
        a.setNombreAlbum(album.getNombreAlbum());
        a.setDescripcion(album.getDescripcion());
        a.setFechaEmision(album.getFechaEmision());
        a.setEditorial(album.getEditorial());
        return albumRepository.save(a);
    }

    @Override
    public void eliminarAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<AlbumModel> listar() {
        return albumRepository.findAll();
    }

    @Override
    public AlbumModel buscarPorId(Long id) {
        return albumRepository.findById(id).orElseThrow();
    }

    @Override
public boolean completarAlbum(Long albumId, Long usuarioId) {

    int total = laminaRepository.findByAlbumAlbumId(albumId).size();
    int coleccionadas = coleccionRepository.countByAlbumAlbumIdAndUsuarioUsuarioId(albumId, usuarioId);

    if(total == coleccionadas){

        ColeccionModel c = coleccionRepository
                .findByUsuarioUsuarioId(usuarioId)
                .stream()
                .filter(x -> x.getAlbum().getAlbumId().equals(albumId))
                .findFirst()
                .orElseThrow();

        c.setEstado(true);
        coleccionRepository.save(c);
        return true;
    }

    return false;
}

}
