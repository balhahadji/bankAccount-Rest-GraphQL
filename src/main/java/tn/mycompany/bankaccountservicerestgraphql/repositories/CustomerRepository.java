package tn.mycompany.bankaccountservicerestgraphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
