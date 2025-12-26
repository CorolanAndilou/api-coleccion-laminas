package cl.ipss.api_demo.service;

import java.util.List;

import cl.ipss.api_demo.model.*;

public interface LaminaService {
    LaminaModel crear(LaminaModel lamina);
    List<LaminaModel> listarPorAlbum(Long albumId);
    List<LaminaModel> faltantes(Long albumId);
    List<LaminaModel> repetidas(Long albumId);
}
