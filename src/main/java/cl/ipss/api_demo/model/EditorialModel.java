package cl.ipss.api_demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "editorial")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class EditorialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long editorialId;

    private String contacto;
}
