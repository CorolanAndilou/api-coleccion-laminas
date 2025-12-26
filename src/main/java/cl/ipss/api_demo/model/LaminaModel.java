package cl.ipss.api_demo.model;

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

    private String nombreLamina;
    private String descripcion;
    private Integer tipo;
    //private String rareza -- cambiar a enum si hay tiempo
    private String imagen;


    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumModel album;
}
