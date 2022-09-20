package Transaction.Transactionservice.repository;

import Transaction.Transactionservice.modal.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepo extends JpaRepository<Transaction,Integer> {
}
