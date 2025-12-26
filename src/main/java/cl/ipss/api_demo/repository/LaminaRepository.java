package cl.ipss.api_demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.api_demo.model.*;

public interface LaminaRepository extends JpaRepository<LaminaModel, Long> {
    List<LaminaModel> findByAlbumAlbumId(Long albumId);
}
