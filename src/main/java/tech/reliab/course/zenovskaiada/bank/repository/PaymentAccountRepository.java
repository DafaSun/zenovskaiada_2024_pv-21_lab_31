package tech.reliab.course.zenovskaiada.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.zenovskaiada.bank.entity.PaymentAccount;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Integer> {

    void deleteById(int id);
}
