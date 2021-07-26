package me.defian.commoneweb.post;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditAware implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        System.out.println("Looking for current User");
        return Optional.empty();
    }
}
