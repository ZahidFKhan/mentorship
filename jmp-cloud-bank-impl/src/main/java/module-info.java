import com.jmp.bankapi.Bank;

module cloudbank {
    requires transitive bank_api_module;
    requires transitive jmp_dtos;

    provides Bank with
            com.jmp.cloud.bank.impl.RetailBank,
            com.jmp.cloud.bank.impl.InvestmentBank;
}
