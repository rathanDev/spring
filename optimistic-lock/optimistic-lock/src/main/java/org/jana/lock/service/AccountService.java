package org.jana.lock.service;

import org.jana.lock.model.Account;
import org.jana.lock.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    public void run() {

        Account account = new Account("Jana", 1000);
        repo.save(account);

        Long accountId = account.getId();
        System.out.println("Account persisted " + account);

        Account account1 = repo.findById(accountId).get();
        account1.setAmount(2000);
        repo.save(account1);

        Account account2 = repo.findById(accountId).get();
        System.out.println("account2 = " + account2);

    }

    public void runLock() {
        System.out.println("Demonstrate optimistic lock");

        Account account = new Account("Rathan", 1000);
        repo.save(account);

        Long accountId = account.getId();
        System.out.println("Account persisted" + account);

        ExecutorService es = Executors.newFixedThreadPool(2);

        es.execute(() -> {
            System.out.println("Thread 1 starts");

            Account account1 = repo.findById(accountId).get();
            System.out.println("T1 Account found " + account1);
            account1.setAmount(2000);

            try {
                repo.save(account1);
                System.out.println("T1 updated account" + repo.findById(accountId));
            } catch (Exception e) {
                System.out.println("T1 Error at saving " + e);
            }
            System.out.println("Thread 1 done");
        });

        es.execute(() -> {
            System.out.println("Thread 2 starts");

            Account account1 = repo.findById(accountId).get();
            System.out.println("T2 Account found " + account1);
            account1.setAmount(3000);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                repo.save(account1);
                System.out.println("T2 updated account" + repo.findById(accountId));
            } catch (Exception e) {
                System.out.println("T2 Error at saving " + e);
            }
            System.out.println("Thread 2 done");
        });

    }

}
