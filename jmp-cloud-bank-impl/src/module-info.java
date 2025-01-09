module cloudbank {
    requires transitive bank_api_module;
    requires jmp_dtos;
    exports com.jmp.cloud.bank.impl;
}