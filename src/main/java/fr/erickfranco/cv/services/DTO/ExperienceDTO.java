package fr.erickfranco.cv.services.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Erick Franco
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

    private Long id;

    @JsonProperty(value = "titrePoste")
    private String titrePoste;

    @JsonProperty(value = "entreprise")
    private String entreprise;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "ville")
    private String ville;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

    @JsonProperty(value = "description2")
    private String description2;


}
