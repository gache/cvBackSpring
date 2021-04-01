package fr.erickfranco.cv.configurations.security;

import fr.erickfranco.cv.services.serviceinter.UtilisateurServiceInter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

/**
 * @author Erick Franco
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UtilisateurServiceInter utilisateurServiceInter;
    private final SecurityProblemSupport problemSupport;

    public SecurityConfig(UtilisateurServiceInter utilisateurServiceInter, SecurityProblemSupport problemSupport) {
        this.utilisateurServiceInter = utilisateurServiceInter;
        this.problemSupport = problemSupport;
    }
}
