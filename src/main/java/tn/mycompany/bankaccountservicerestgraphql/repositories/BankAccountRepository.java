package tn.mycompany.bankaccountservicerestgraphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
