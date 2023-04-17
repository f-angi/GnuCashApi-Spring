package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transactions, String> {
    Page<Transactions> findByDescriptionContainingIgnoreCase(String description, PageRequest pageRequest);

    Page<Transactions> findBySplitAccountNameContainingIgnoreCase(String accountName, PageRequest pageRequest);

    Page<Transactions> findByDescriptionContainingIgnoreCaseAndSplitAccountNameContainingIgnoreCase(String description, String accountName, PageRequest pageRequest);
}