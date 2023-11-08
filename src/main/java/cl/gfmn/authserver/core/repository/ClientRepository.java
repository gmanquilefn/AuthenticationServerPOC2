package cl.gfmn.authserver.core.repository;

import cl.gfmn.authserver.core.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * https://docs.spring.io/spring-authorization-server/docs/current/reference/html/guides/how-to-jpa.html#client-repository
 */
public interface ClientRepository extends JpaRepository<Client, String> {

    Optional<Client> findByClientId(String clientId);
}
