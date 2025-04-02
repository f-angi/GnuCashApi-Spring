package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import party.fangi.gnucashapi.persistence.model.Accounts;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Accounts, String> {
    Optional<Accounts> findFirstByNameIgnoreCase(String name);
}
