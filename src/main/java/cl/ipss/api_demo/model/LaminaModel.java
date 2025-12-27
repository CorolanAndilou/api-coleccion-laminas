package cl.ipss.api_demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lamina")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class LaminaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laminaId;

    @Column(nullable = false)
    private String codigoLocal;

    @Column(nullable = false)
    private String nombreLamina;

    private String descripcion;

    @Column(nullable = false)
    private Integer tipo;

    @Enumerated(EnumType.STRING)
    private Rareza rareza;

    private String imagen;

    @ManyToOne
    @JoinColumn(name = "album_id")
    @JsonBackReference
    private AlbumModel album;
}
