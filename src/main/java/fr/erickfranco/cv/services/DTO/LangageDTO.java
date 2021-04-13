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
public class LangageDTO {

    private Long id;

    @JsonProperty(value = "langageInformatique")
    private String langageInformatique;

    @JsonProperty(value = "porcentage")
    private String porcentage;
}
