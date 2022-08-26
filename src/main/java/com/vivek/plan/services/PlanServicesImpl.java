package com.vivek.plan.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivek.plan.appconstant.AppConstant;
import com.vivek.plan.entity.Plan;
import com.vivek.plan.entity.PlanCategory;
import com.vivek.plan.repo.IPlanCategoryDao;
import com.vivek.plan.repo.IPlanDao;

@Service
public class PlanServicesImpl implements IPlanServices {

	@Autowired
	private IPlanDao planDao;

	@Autowired
	private IPlanCategoryDao planCategoryDao;

	//Get-All-Category
	@Override
	public Map<Integer, String> getallCategory() {
		Map<Integer, String> mapcat = new HashMap<>();
		 List<PlanCategory> findAll = this.planCategoryDao.findAll();
		 findAll.forEach(cat ->{
			 mapcat.put(cat.getCategory_Id(), cat.getCategory_Name());
		 });
				  
		return mapcat;
	}
    
	//Save The Plan
	@Override
	public Boolean savePlan(Plan plan) {

		
		if (this.planDao.save(plan)!=null) {
			return true;
		}
		return false;
	}

	//Show All Plans
	@Override
	public List<Plan> showAllPlan() {
		List<Plan> findAll = this.planDao.findAll();

		return findAll;
	}

	//Update The Plan
	@Override
	public Boolean updatePlan(Plan plan) {
		
		
		if (this.planDao.save(plan)!=null) {
			return true;
		}
		return false;

	}

	//Get Plan By ID
	@Override
	public Plan getPlanById(Integer pid) {
		 Optional<Plan> findById = this.planDao.findById(pid);
		 if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	//Delete Plan By ID
	@Override
	public Boolean hardDelete(Integer pid) {
		Boolean s = false;
		try {
		       this.planDao.deleteById(pid);
			s =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public Boolean changeStatus(Integer pid, String statusName) {
		
		Optional<Plan> findById = this.planDao.findById(pid);
		if (findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActive_SW(statusName);
			 
			if (this.planDao.save(plan)!=null) {
				return true;
			}
		}
		return false;
	}

	

}
