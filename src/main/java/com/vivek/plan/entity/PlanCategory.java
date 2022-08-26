package com.vivek.plan.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private int Category_Id;
	@Column(name = "CATEGORY_NAME")
	private String Category_Name;
	@Column(name = "ACTIVE_SW")
	private String Active_SW;
	@Column(name = "CREATED_DATE" ,updatable = false)
	@CreationTimestamp
	private LocalDate Create_Date;
	@Column(name = "UPDATED_DATE" ,insertable =  false)
	@CreationTimestamp
	private LocalDate Update_Date;
	@Column(name = "CREATED_BY")
	private String Created_By;
	@Column(name = "UPDATED_BY")
	private String Updated_By;
	
}
