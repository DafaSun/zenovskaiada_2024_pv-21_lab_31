package tech.reliab.course.zenovskaiada.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.zenovskaiada.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

    void deleteById(int id);
}
