package com.company;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// need this annotation for parameterized tests
@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double excpected;

    public BankAccountTestParameterized(double amount, boolean branch, double excpected) {
        this.amount = amount;
        this.branch = branch;
        this.excpected = excpected;
    }

    @Before
    public void setup() {
        account = new BankAccount("Adam", "Carter", 1000.00, BankAccount.CHECKING);
        System.out.println("Running test");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @Test
    public void getBalance_deposit() throws Exception {
        // parameters we have created in this class that are initialized in the constructor
        account.deposit(amount, branch);
        assertEquals(excpected, account.getBalance(), .01); //changed delta since test was failing, due to doubles
    }
}
