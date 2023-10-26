package tn.mycompany.bankaccountservicerestgraphql.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountRequestDTO;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountResponseDTO;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;
import tn.mycompany.bankaccountservicerestgraphql.entities.Customer;
import tn.mycompany.bankaccountservicerestgraphql.mappers.BankAccountMapper;
import tn.mycompany.bankaccountservicerestgraphql.repositories.BankAccountRepository;
import tn.mycompany.bankaccountservicerestgraphql.repositories.CustomerRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private BankAccountMapper bankAccountMapper;
    private CustomerRepository customerRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, BankAccountMapper bankAccountMapper, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountMapper = bankAccountMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getBankAccount(String id) {

        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));
    }

    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = new BankAccount();
        bankAccount = bankAccountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        bankAccountResponseDTO = bankAccountMapper.fromBankAccount(bankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateBankAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Account %s not found", id)));

        if (bankAccountRequestDTO.getBalance() != null) account.setBalance(bankAccountRequestDTO.getBalance());
        account.setCreatedAt(new Date());
        if (bankAccountRequestDTO.getType() != null) account.setType(bankAccountRequestDTO.getType());
        if (bankAccountRequestDTO.getCurrency() != null) account.setCurrency(bankAccountRequestDTO.getCurrency());
        bankAccountRepository.save(account);
        return bankAccountMapper.fromBankAccount(account);
    }

    @Override
    public void deleteBankAccount(String id) {
        bankAccountRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
