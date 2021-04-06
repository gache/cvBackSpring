package fr.erickfranco.cv.services.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

/**
 * @author Erick Franco
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {

    private Long id;
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "nom")
    private String nom;

    @JsonProperty(value = "prenom")
    private String prenom;

    @JsonProperty(value = "sujet")
    private String sujet;

    @JsonProperty(value = "message")
    private String message;
}
