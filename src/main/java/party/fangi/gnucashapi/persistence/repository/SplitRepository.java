package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import party.fangi.gnucashapi.persistence.model.Splits;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "splits", path = "splits")
interface SplitRepository extends PagingAndSortingRepository<Splits, String> {
    List<Splits> findByGuid(@Param("guid") String guid);

    List<Splits> findByTransactionDescriptionContainsIgnoreCaseAndAccountNameIgnoreCase(@Param("transDescr") String transDescr, @Param("accountName") String accountName);

}