package com.zohocrm.repository;

import com.zohocrm.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeadRepository extends JpaRepository<Lead, String> {

    Optional<Lead> findByEmail(String email); // here in case of findByEmail method we also use getByEmail method
                                                 // BUT WE USE "findBy" here because it is **standard template**
    Optional<Lead> findByMobile(long mobile); // here in case of findByMobile method we also use getByMobile method

    boolean existsByEmail(String email); // here we have to remember this existsByEmail method and here existsBy template is fixed

    boolean existsByMobile(long mobile);  // here we have to remember this existsByMobile method


}
