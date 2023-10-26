package tn.mycompany.bankaccountservicerestgraphql;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.entities.Customer;
import tn.mycompany.bankaccountservicerestgraphql.enums.AccountType;
import tn.mycompany.bankaccountservicerestgraphql.repositories.BankAccountRepository;
import tn.mycompany.bankaccountservicerestgraphql.repositories.CustomerRepository;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BankAccountServiceRestGraphQlApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceRestGraphQlApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {

        return args -> {
            Stream.of("Balha", "Anis", "Bassem", "Majdi", "yassine").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                for (int i = 0; i < 10; i++) {
                    BankAccount bankAccount = BankAccount.builder()
                            .id(UUID.randomUUID().toString())
                            .type(Math.random() > 0.5 ? AccountType.SAVING_ACCOUNT : AccountType.CURRENT_ACCOUNT)
                            .balance(1000 + Math.random() * 90000)
                            .createdAt(new Date()).currency("EUR")
                            .customer(customer).build();
                    bankAccountRepository.save(bankAccount);

                }
            });


        };
    }
}
