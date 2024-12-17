package tech.reliab.course.zenovskaiada.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.zenovskaiada.bank.entity.BankAtm;

import java.util.List;

public interface BankAtmRepository extends JpaRepository<BankAtm, Integer> {

    List<BankAtm> findAllByBankId(int id);

    void deleteById(int id);
}
