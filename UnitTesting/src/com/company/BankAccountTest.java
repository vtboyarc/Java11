package com.company;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("this is run before any test cases. Count = " + count++);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("this is run after any test cases. Count = " + count++);
    }

    @After
    public void tearDown() {
        System.out.println("Count = " + count++);
    }

    @Before
    public void setup() {
        // this is run before each test
        account = new BankAccount("Adam", "Carter", 1000.00, BankAccount.CHECKING);
    }

    @Test
    public void deposit() throws Exception {
        //amount and true or false for branch
        double balance = account.deposit(200.00, true);
        // 3rd param is delta, allows some leeway between the expected and actual, good for doubles
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    // add the expected IllegalArgumentException, because this should throw this exception, since trying to withdraw
    // more than 500 from a non branch
    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        // don't need an assert, because doing this on the withdraw method should throw the exception, and we are testing for that
        account.withdraw(600.00, false);
        // this only prints out if the test fails
        fail("Should have thrown IllegalArgumentException");
    }

    // same as above test, but if using older version than JUnit 4, can't catch exception in the Test annotation
    @Test
    public void withdraw_notBranch_oldJunit() throws Exception {
        try {
            account.withdraw(600.00, false);
            // this only prints out if the test fails
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void getBalance_deposit() throws Exception {
        //amount and true or false for branch
        account.deposit(200.00, true);
        //1200 is expected, account.getBalance is actual
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() throws Exception {
        //amount and true or false for branch
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        //the message will only print out if the assert fails
        assertTrue("the account is not checking account", account.isChecking());
    }
}