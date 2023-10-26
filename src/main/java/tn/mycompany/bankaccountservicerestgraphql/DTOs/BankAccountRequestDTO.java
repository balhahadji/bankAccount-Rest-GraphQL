package tn.mycompany.bankaccountservicerestgraphql.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.mycompany.bankaccountservicerestgraphql.enums.AccountType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDTO {
    private Double balance;
    private String currency;
    private AccountType type;
}
