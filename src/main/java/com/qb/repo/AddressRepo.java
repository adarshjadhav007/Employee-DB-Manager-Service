package com.qb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qb.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{

}
