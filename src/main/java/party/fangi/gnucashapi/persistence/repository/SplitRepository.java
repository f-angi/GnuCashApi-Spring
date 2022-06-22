package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import party.fangi.gnucashapi.persistence.model.Splits;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "splits", path = "splits")
public interface SplitRepository extends PagingAndSortingRepository<Splits, String> {
    List<Splits> findByGuid(@Param("guid") String guid);

    List<Splits> findByTransactionDescriptionContainsAndAccountName(@Param("transDescr") String transDescr, @Param("accountName") String accountName);

}
