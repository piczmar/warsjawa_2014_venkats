package com.agiledeveloper;

public class Account {
    private Ref balance; // managed mutable identity

    public Account(int initialBalance) {
        balance = new Ref(initialBalance);
    }

    public void deposit(int amount) {

        if (amount < 0) throw new RuntimeException("Invalid amount");

        LockingTransaction.runInTransaction(
                new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        balance.set(getBalance() + amount);
                        return null;
                    }
                });

    }

    public void withdraw(int amount) {
        if (amount < 0) throw new RuntimeException("Invalid amount");
        LockingTransaction.runInTransaction(
                new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        if (amount > getBalance()) throw new RuntimeException("Insufficient fund");
                        balance.set(getBalance() - amount);
                    }
                });

    }

    public int getBalance() {
        return (Integer) balance.deref();
    }
}