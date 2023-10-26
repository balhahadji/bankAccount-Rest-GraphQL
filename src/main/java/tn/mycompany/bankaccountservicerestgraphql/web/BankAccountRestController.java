package tn.mycompany.bankaccountservicerestgraphql.web;

import org.springframework.web.bind.annotation.*;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountRequestDTO;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountResponseDTO;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.services.BankAccountService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {
    private BankAccountService bankAccountService;

    public BankAccountRestController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @GetMapping("/bankAccounts")
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccount(@PathVariable String id) {
        return bankAccountService.getBankAccount(id);

    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO addNewAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.addBankAccount(bankAccountRequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO updateAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO, @PathVariable String id) {
        return bankAccountService.updateBankAccount(id, bankAccountRequestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        bankAccountService.deleteBankAccount(id);
    }
}
