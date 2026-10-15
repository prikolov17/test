package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void withdrawSuccessfullyChangesBalance() {
        BankAccount account = new BankAccount(100);

        account.withdraw(40);

        assertEquals(60, account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceIsRejected() {
        BankAccount account = new BankAccount(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(101)
        );
    }

    @Test
    void negativeInitialBalanceIsRejected() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(-1)
        );
    }

    @Test
    void nonPositiveDepositIsRejected() {
        BankAccount account = new BankAccount(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-5)
        );
    }

    @Test
    void nonPositiveWithdrawalIsRejected() {
        BankAccount account = new BankAccount(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-5)
        );
    }
}


