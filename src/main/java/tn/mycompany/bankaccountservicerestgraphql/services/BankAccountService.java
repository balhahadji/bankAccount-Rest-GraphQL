package tn.mycompany.bankaccountservicerestgraphql.services;

import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountRequestDTO;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountResponseDTO;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.entities.Customer;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllAccounts();

    BankAccount getBankAccount(String id);

    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO);

    BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);

    void deleteBankAccount(String id);
    List<Customer> getAllCustomers();
}
