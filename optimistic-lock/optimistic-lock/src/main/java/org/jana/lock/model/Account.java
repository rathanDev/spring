package org.jana.lock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String holder;

    private int amount;

    @Version
    private long version;

    public Account() {
    }

    public Account(String holder, int amount) {
        this.holder = holder;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int salary) {
        this.amount = salary;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", holder='" + holder + '\'' +
                ", amount=" + amount +
                ", version=" + version +
                '}';
    }

}
