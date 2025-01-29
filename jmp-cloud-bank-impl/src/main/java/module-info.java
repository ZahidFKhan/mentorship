import com.jmp.bankapi.Bank;

module cloudbank {
    requires transitive jmp_bank_api_module;
    requires jmp_dtos;

    provides Bank with
            com.jmp.cloud.bank.impl.InvestmentBank;
}
