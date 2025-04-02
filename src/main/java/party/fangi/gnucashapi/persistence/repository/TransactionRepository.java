package party.fangi.gnucashapi.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import party.fangi.gnucashapi.model.AccountType;
import party.fangi.gnucashapi.model.AmountPerPeriod;
import party.fangi.gnucashapi.persistence.model.Transactions;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transactions, String>, CrudRepository<Transactions, String> {
    Page<Transactions> findByDescriptionContainingIgnoreCase(String description, PageRequest pageRequest);

    Page<Transactions> findBySplitAccountNameContainingIgnoreCase(String accountName, PageRequest pageRequest);

    Page<Transactions> findByDescriptionContainingIgnoreCaseAndSplitAccountNameContainingIgnoreCase(String description, String accountName, PageRequest pageRequest);

    @Query("select new party.fangi.gnucashapi.model.AmountPerPeriod(" +
            "to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY-MM') as dateInterval, " +
            "- sum(s.valueNum)" +
            ") " +
            " from Transactions t join t.split s join s.account a" +
            " where a.accountType = :#{#accountType.toString()}" +
            " and t.postDate >= :from and t.postDate < :to" +
            " group by to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY-MM')" +
            " order by to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY-MM')")
    List<AmountPerPeriod> sumAccountAmountPerMonth(AccountType accountType, Timestamp from, Timestamp to);

    @Query("select new party.fangi.gnucashapi.model.AmountPerPeriod(" +
            "to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY') as dateInterval, " +
            "- sum(s.valueNum)" +
            ") " +
            " from Transactions t join t.split s join s.account a" +
            " where a.accountType = :#{#accountType.toString()}" +
            " and t.postDate >= :from and t.postDate < :to" +
            " group by to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY')" +
            " order by to_date(cast(timezone('UTC', t.postDate) as text), '%YYYY')")
    List<AmountPerPeriod> sumAccountAmountPerYear(AccountType accountType, Timestamp from, Timestamp to);

    @Query("SELECT DISTINCT t FROM Transactions t " +
            "JOIN t.split s " +
            "JOIN s.account a " +
            "WHERE (:description IS NULL OR :description = '' OR LOWER(t.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
            "AND (:accountName IS NULL OR :accountName = '' OR LOWER(a.name) LIKE LOWER(CONCAT('%', :accountName, '%'))) " +
            "AND a.accountType = 'EXPENSE'")
    Page<Transactions> findExpenseTransactions(String description, String accountName, PageRequest pageRequest);

    @Query("SELECT DISTINCT t FROM Transactions t " +
            "JOIN t.split s " +
            "JOIN s.account a " +
            "WHERE (:description IS NULL OR :description = '' OR LOWER(t.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
            "AND (:accountName IS NULL OR :accountName = '' OR LOWER(a.name) LIKE LOWER(CONCAT('%', :accountName, '%'))) " +
            "AND a.accountType = 'INCOME'")
    Page<Transactions> findIncomeTransactions(String description, String accountName, PageRequest pageRequest);

    @Query("SELECT DISTINCT t FROM Transactions t " +
            "JOIN t.split s " +
            "JOIN s.account a " +
            "WHERE (:description IS NULL OR :description = '' OR LOWER(t.description) LIKE LOWER(CONCAT('%', :description, '%'))) " +
            "AND (:accountName IS NULL OR :accountName = '' OR LOWER(a.name) LIKE LOWER(CONCAT('%', :accountName, '%')))")
    Page<Transactions> findTransactions(String description, String accountName, PageRequest pageRequest);
}
