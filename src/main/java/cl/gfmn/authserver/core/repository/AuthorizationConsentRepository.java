package cl.gfmn.authserver.core.repository;

import cl.gfmn.authserver.core.entity.AuthorizationConsent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * https://docs.spring.io/spring-authorization-server/docs/current/reference/html/guides/how-to-jpa.html#authorization-consent-repository
 */
public interface AuthorizationConsentRepository extends JpaRepository<AuthorizationConsent, AuthorizationConsent.AuthorizationConsentId> {

    Optional<AuthorizationConsent> findByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
    void deleteByRegisteredClientIdAndPrincipalName(String registeredClientId, String principalName);
}
