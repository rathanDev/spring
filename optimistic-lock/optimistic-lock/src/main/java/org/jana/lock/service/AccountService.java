package org.jana.lock.service;

import org.jana.lock.model.Account;
import org.jana.lock.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}
