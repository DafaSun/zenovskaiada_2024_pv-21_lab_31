package tech.reliab.course.zenovskaiada.bank.service;

import tech.reliab.course.zenovskaiada.bank.entity.BankOffice;
import tech.reliab.course.zenovskaiada.bank.model.BankOfficeRequest;

import java.util.List;

public interface BankOfficeService {

    BankOffice createBankOffice(BankOfficeRequest bankOfficeRequest);

    BankOffice getBankOfficeById(int id);

    BankOffice getBankDtoOfficeById(int id);

    List<BankOffice> getAllBankOffices();

    BankOffice updateBankOffice(int id, String name);

    void deleteBankAtm(int id);
}
