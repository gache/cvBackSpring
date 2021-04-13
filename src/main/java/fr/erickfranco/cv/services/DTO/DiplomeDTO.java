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
public class DiplomeDTO {

    private Long id;

    @JsonProperty(value = "nomDiplome")
    private String nomDiplome;

    @JsonProperty(value = "ecole")
    private String ecole;

    @JsonProperty(value = "ville")
    private String ville;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "annee")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String annee;
}
