package com.example.backenduppgiftfinal.auth;

import com.example.backenduppgiftfinal.repositories.CustomerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("fake")
public class FakeApplicationUserService implements ApplicationUserDao{

    List<ApplicationUser> applicationUsers;

    private final PasswordEncoder passwordEncoder;

    CustomerRepository customerRepository;


    @Autowired
    public FakeApplicationUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    public List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("niklas",
                        passwordEncoder.encode("password"), true, true, true,true));







        return applicationUsers;
    }
}
