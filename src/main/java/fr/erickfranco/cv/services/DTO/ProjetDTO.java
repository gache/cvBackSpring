package fr.erickfranco.cv.services.DTO;

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
public class ProjetDTO {
    private Long id;

    @JsonProperty(value = "nom")
    private String nom;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "langage")
    private String langage;

    @JsonProperty(value = "url")
    private String url;
}
