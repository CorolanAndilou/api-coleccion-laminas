package cl.ipss.api_demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "album")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AlbumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long albumId;

    private String nombreAlbum;
    private LocalDate fechaEmision;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private EditorialModel editorial;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<LaminaModel> laminas;
}
