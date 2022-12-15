package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import party.fangi.gnucashapi.persistence.model.Splits;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "splits", path = "splits")
interface SplitRepository extends CrudRepository<Splits, String> {
    List<Splits> findByGuid(@Param("guid") String guid);

    List<Splits> findByTransactionDescriptionContainsIgnoreCaseAndAccountNameIgnoreCase(@Param("transDescr") String transDescr, @Param("accountName") String accountName);

}