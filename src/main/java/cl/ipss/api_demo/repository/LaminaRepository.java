package cl.ipss.api_demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.api_demo.model.*;

public interface LaminaRepository extends JpaRepository<LaminaModel, Long> {
    List<LaminaModel> findByAlbumAlbumId(Long albumId);
    List<LaminaModel> findByAlbumAlbumIdAndTipo(Long albumId, Integer tipo);
    int countByAlbumAlbumIdAndTipo(Long albumId, Integer tipo);
    int countByAlbumAlbumId(Long albumId);
    int countByRareza(Rareza rareza);

}
