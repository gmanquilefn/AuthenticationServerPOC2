package cl.gfmn.authserver.core.repository;

import cl.gfmn.authserver.core.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Optional<Authority> findByRole(String role);
}
