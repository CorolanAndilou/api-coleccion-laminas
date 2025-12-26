package cl.ipss.api_demo.service;

import java.util.List;

import cl.ipss.api_demo.model.*;

public interface AlbumService {
    AlbumModel crearAlbum(AlbumModel album);
    AlbumModel actualizarAlbum(Long id, AlbumModel album);
    void eliminarAlbum(Long id);
    List<AlbumModel> listar();
    AlbumModel buscarPorId(Long id);
}
