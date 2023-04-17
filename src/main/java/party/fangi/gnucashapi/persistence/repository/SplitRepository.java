package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import party.fangi.gnucashapi.persistence.model.Splits;

import java.util.List;

interface SplitRepository extends CrudRepository<Splits, String> {
    List<Splits> findByGuid(@Param("guid") String guid);

    List<Splits> findByTransactionDescriptionContainsIgnoreCaseAndAccountNameIgnoreCase(@Param("transDescr") String transDescr, @Param("accountName") String accountName);

}