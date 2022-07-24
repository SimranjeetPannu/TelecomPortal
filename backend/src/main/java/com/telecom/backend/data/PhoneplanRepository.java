package com.telecom.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.backend.beans.PhonePlan;
@Repository
public interface PhoneplanRepository extends JpaRepository<PhonePlan, Integer>  {

}
