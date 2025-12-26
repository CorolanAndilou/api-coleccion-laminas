package cl.ipss.api_demo.service.impl;

import cl.ipss.api_demo.model.*;
import cl.ipss.api_demo.repository.AlbumRepository;
import cl.ipss.api_demo.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;

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
}
