package com.vivek.plan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.plan.entity.Plan;

public interface IPlanDao extends JpaRepository<Plan, Integer>{

}
