package com.telecom.backend.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telecom.backend.beans.UserAccount;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>  {

    @Query (value="select * from account where customerid = :customerid", nativeQuery = true)
    public List<UserAccount> findById(@Param(value = "customerid") int customerid);
}
