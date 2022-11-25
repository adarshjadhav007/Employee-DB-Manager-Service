package com.qb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qb.entity.Leaves;

@Repository
public interface LeavesRepo extends JpaRepository<Leaves, Integer>{

}
