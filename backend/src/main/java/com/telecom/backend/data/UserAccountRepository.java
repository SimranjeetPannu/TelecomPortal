package com.telecom.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.backend.beans.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>  {

}
