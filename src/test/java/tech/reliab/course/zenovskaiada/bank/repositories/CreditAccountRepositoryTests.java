package tech.reliab.course.zenovskaiada.bank.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.reliab.course.zenovskaiada.bank.containers.PostgresContainer;
import tech.reliab.course.zenovskaiada.bank.entity.Bank;
import tech.reliab.course.zenovskaiada.bank.entity.CreditAccount;
import tech.reliab.course.zenovskaiada.bank.entity.User;
import tech.reliab.course.zenovskaiada.bank.repository.BankRepository;
import tech.reliab.course.zenovskaiada.bank.repository.CreditAccountRepository;
import tech.reliab.course.zenovskaiada.bank.repository.UserRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreditAccountRepositoryTests extends PostgresContainer {

    @Autowired
    private CreditAccountRepository creditAccountRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private UserRepository userRepository;

    private CreditAccount testCreditAccount;
    private Bank testBank;
    private User testUser;

    @BeforeEach
    void setUp() {
        testBank = new Bank("Test Bank");
        testBank.setRating(5);
        testBank.setTotalMoney(999999);
        testBank.setInterestRate(0.3);
        testBank = bankRepository.save(testBank);

        testUser = new User("Ivanov Ivan Ivanovich", LocalDate.of(2000, 10, 10), "Artist");
        testUser.setMonthlyIncome(5000);
        testUser.setCreditRating(999);
        testUser = userRepository.save(testUser);

        testCreditAccount = new CreditAccount(
                testUser,
                testBank,
                LocalDate.of(2024, 1, 1),
                12,
                5.0,
                null,
                null
        );
        testCreditAccount.setLoanAmount(10000);
        testCreditAccount.setMonthlyPayment(750);
        testCreditAccount = creditAccountRepository.save(testCreditAccount);
    }

    @AfterEach
    void tearDown() {
        creditAccountRepository.deleteAll();
        userRepository.deleteAll();
        bankRepository.deleteAll();
    }

    @Test
    void testFindCreditAccountById() {
        CreditAccount foundAccount = creditAccountRepository.findById(testCreditAccount.getId()).orElse(null);
        assertNotNull(foundAccount);
        assertEquals(testCreditAccount.getLoanAmount(), foundAccount.getLoanAmount());
    }

    @Test
    void testDeleteCreditAccount() {
        creditAccountRepository.deleteById(testCreditAccount.getId());

        boolean exists = creditAccountRepository.existsById(testCreditAccount.getId());
        assertFalse(exists);
    }
}
