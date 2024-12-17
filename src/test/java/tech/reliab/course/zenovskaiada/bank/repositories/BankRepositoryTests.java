package tech.reliab.course.zenovskaiada.bank.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.reliab.course.zenovskaiada.bank.containers.PostgresContainer;
import tech.reliab.course.zenovskaiada.bank.entity.Bank;
import tech.reliab.course.zenovskaiada.bank.repository.BankRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BankRepositoryTests extends PostgresContainer {

    @Autowired
    private BankRepository bankRepository;

    private Bank testBank;

    @BeforeEach
    void setUp() {
        testBank = new Bank("Test Bank");
        testBank.setRating(5);
        testBank.setTotalMoney(999999);
        testBank.setInterestRate(0.3);
        testBank = bankRepository.save(testBank);
    }

    @AfterEach
    void tearDown() {
        bankRepository.deleteAll();
    }

    @Test
    void testFindBankById() {
        Bank foundBank = bankRepository.findById(testBank.getId()).orElse(null);
        assertNotNull(foundBank);
        assertEquals(testBank.getName(), foundBank.getName());
    }

    @Test
    void testDeleteBank() {
        bankRepository.deleteById(testBank.getId());

        boolean exists = bankRepository.existsById(testBank.getId());
        assertFalse(exists);
    }
}
