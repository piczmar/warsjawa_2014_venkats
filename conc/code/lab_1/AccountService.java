package com.agiledeveloper;
import java.util.concurrent.Callable;
import clojure.lang.LockingTransaction;
public class AccountService {
    public void transfer(final Account from, final Account to, final int amount) {


        LockingTransaction.runInTransaction(
                new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        from.withdraw(amount);
                        to.deposit(amount);
                        return null;
                    }
                });
    }
}
