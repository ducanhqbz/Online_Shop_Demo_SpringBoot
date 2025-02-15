package org.example.onlineshop.repository;

import org.example.onlineshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByUsername(String username);
    public Account findById (int username);
}
