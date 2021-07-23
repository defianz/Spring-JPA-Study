package me.defian.querydlsdemo.account;

import com.querydsl.core.types.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void crud(){
        QAccount account = QAccount.account;
        Predicate predicate = account.firstName.containsIgnoreCase("defian")
                .and(account.lastName.startsWith("kim"));
        Optional<Account> one = accountRepository.findOne(predicate);
        assertTrue(one.isEmpty());


    }

}