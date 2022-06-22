package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "transactions", path = "transactions")
public interface TransactionRepository extends PagingAndSortingRepository<Transactions, String> {
    List<Transactions> findByDescriptionContaining(@Param("descr") String description);
}
