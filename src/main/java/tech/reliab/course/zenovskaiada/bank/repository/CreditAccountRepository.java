package tech.reliab.course.zenovskaiada.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.zenovskaiada.bank.entity.CreditAccount;

public interface CreditAccountRepository extends JpaRepository<CreditAccount, Integer> {

    void deleteById(int id);
}
