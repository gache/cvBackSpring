package fr.erickfranco.cv.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.EntityListeners;

/**
 * @author Erick Franco
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntiteBase implements Serializable {

    @CreatedBy
    @Column(name = "cree_par", length = 50, updatable = true)
    private String creePar;

    @CreatedDate
    @Column(name = "date_creation", updatable = false)
    @JsonIgnore
    private Instant dateCreation = Instant.now();

    @LastModifiedBy
    @Column(name = "modifie_par", length = 50)
    private String modifiePar;

    @LastModifiedDate
    @Column(name = "date_modification")
    @JsonIgnore
    private Instant dateModification = Instant.now();
}
