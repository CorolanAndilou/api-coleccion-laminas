package cl.ipss.api_demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "coleccion")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ColeccionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coleccionId;

    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumModel album;
}
