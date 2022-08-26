package com.vivek.plan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.plan.entity.PlanCategory;

public interface IPlanCategoryDao extends JpaRepository<PlanCategory, Integer>{

}
