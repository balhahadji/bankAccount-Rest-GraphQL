package tn.mycompany.bankaccountservicerestgraphql.web;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountRequestDTO;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountResponseDTO;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.entities.Customer;
import tn.mycompany.bankaccountservicerestgraphql.repositories.BankAccountRepository;
import tn.mycompany.bankaccountservicerestgraphql.services.BankAccountService;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    private BankAccountService bankAccountService;
    private BankAccountRepository bankAccountRepository;

    public BankAccountGraphQLController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @QueryMapping
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }
    @QueryMapping
    public BankAccount getAccountById(@Argument String id) {
        return bankAccountService.getBankAccount(id);
    }
    @MutationMapping
    public BankAccountResponseDTO addNewBankAccount(@Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.addBankAccount(bankAccount);
    }
    @MutationMapping
    public BankAccountResponseDTO updateBankAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return bankAccountService.updateBankAccount(id,bankAccount);
    }
    @MutationMapping
    public void deleteBankAccount(@Argument String id){
        bankAccountService.deleteBankAccount(id);
    }
    @QueryMapping
    public List<Customer> getAllCustomers(){
        return bankAccountService.getAllCustomers();
    }
}
