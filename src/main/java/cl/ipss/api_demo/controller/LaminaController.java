package cl.ipss.api_demo.controller;

import cl.ipss.api_demo.model.LaminaModel;
import cl.ipss.api_demo.service.LaminaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laminas")
@RequiredArgsConstructor

public class LaminaController {

    private final LaminaService laminaService;

    @PostMapping
    public LaminaModel crear(@RequestBody LaminaModel lamina){
        return laminaService.crear(lamina);
    }

    @GetMapping("/album/{albumId}")
    public List<LaminaModel> listarAlbum(@PathVariable Long albumId){
        return laminaService.listarPorAlbum(albumId);
    }

    @GetMapping("/faltantes/{albumId}")
    public List<LaminaModel> faltantes(@PathVariable Long albumId){
        return laminaService.faltantes(albumId);
    }

    @GetMapping("/repetidas/{albumId}")
    public List<LaminaModel> repetidas(@PathVariable Long albumId){
        return laminaService.repetidas(albumId);
    }

}
