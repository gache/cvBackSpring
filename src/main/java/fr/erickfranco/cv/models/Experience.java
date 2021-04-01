package fr.erickfranco.cv.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Erick Franco
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "experience")
public class Experience  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60, nullable = false)
    private String titrePoste;

    @Column(length = 60, nullable = false)
    private String entreprise;

    @Column(columnDefinition = "Text")
    private String description;

    @Column(length = 30, nullable = false)
    private String ville;

    @JsonFormat(pattern = "YYYY-MM-DD", shape = JsonFormat.Shape.STRING)
    private String date;

    @Column(columnDefinition = "Text")
    private String description2;
}
