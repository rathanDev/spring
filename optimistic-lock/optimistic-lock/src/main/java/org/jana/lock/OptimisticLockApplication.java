package org.jana.lock;

import org.jana.lock.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OptimisticLockApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(OptimisticLockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		AccountService es = context.getBean(AccountService.class);
//		es.run();
		es.runLock();

		System.out.println("End");

	}
}
