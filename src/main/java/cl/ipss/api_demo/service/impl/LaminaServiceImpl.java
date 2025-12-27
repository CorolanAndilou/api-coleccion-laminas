package cl.ipss.api_demo.service.impl;

import cl.ipss.api_demo.model.LaminaModel;
import cl.ipss.api_demo.repository.LaminaRepository;
import cl.ipss.api_demo.service.LaminaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor

public class LaminaServiceImpl implements LaminaService{

    private final LaminaRepository laminaRepository;

    @Override
    public LaminaModel crear(LaminaModel lamina) {
        return laminaRepository.save(lamina);
    }

    @Override
    public List<LaminaModel> listarPorAlbum(Long albumId) {
        return laminaRepository.findByAlbumAlbumId(albumId);
    }

    @Override
    public List<LaminaModel> faltantes(Long albumId) {
        return laminaRepository.findByAlbumAlbumId(albumId)
                .stream()
                .filter(l -> l.getTipo() == 0)
                .toList();
    }

    @Override
    public List<LaminaModel> repetidas(Long albumId) {
        return laminaRepository.findByAlbumAlbumId(albumId)
                .stream()
                .filter(l -> l.getTipo() == 2)
                .toList();
    }

    @Override
    public int contarRepetidas(Long albumId) {
        return laminaRepository.findByAlbumAlbumId(albumId)
            .stream()
            .filter(l -> l.getTipo() == 2)
            .mapToInt(l -> l.getCantidad() != null ? l.getCantidad() : 1)
            .sum();
    }

}