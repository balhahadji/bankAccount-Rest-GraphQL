package tn.mycompany.bankaccountservicerestgraphql.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountRequestDTO;
import tn.mycompany.bankaccountservicerestgraphql.DTOs.BankAccountResponseDTO;
import tn.mycompany.bankaccountservicerestgraphql.entities.BankAccount;

@Component
public class BankAccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {

        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }

    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
        return bankAccount;
    }
}
