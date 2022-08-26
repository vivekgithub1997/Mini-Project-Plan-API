package com.vivek.plan.services;

import java.util.List;
import java.util.Map;

import com.vivek.plan.entity.Plan;

public interface IPlanServices {
	
	public Map<Integer, String> getallCategory();
	
	public Boolean savePlan(Plan plan);
	
	public Plan getPlanById(Integer pid);
	
	public List<Plan> showAllPlan();
	
	public Boolean hardDelete(Integer pid);
	
	public Boolean updatePlan(Plan plan); 
	
	public Boolean changeStatus(Integer pid,String statusName);

}
