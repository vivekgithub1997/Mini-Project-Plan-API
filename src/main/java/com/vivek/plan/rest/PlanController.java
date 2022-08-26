package com.vivek.plan.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivek.plan.appconstant.AppConstant;
import com.vivek.plan.entity.Plan;
import com.vivek.plan.props.AppProperties;
import com.vivek.plan.services.IPlanServices;

@RestController
public class PlanController {

	
	private IPlanServices planServices;

	private Map<String, String> Messages;

	public PlanController(IPlanServices planServices, AppProperties appProperties) {

		this.planServices = planServices;
		this.Messages = appProperties.Messages;
		System.out.println(Messages);
	}

	Logger logger = LoggerFactory.getLogger(PlanController.class);

	// Load Category
	@GetMapping("/getcategory")
	public ResponseEntity<Map<Integer, String>> GetCategory() {
		Map<Integer, String> getallCategory = this.planServices.getallCategory();
		logger.info(AppConstant.EXECUTION_COMPLETED);
		return new ResponseEntity<Map<Integer, String>>(getallCategory, HttpStatus.OK);
	}

	// Save The Plan
	@PostMapping("/plan/save")
	public ResponseEntity<String> SavePlan(@RequestBody Plan plan) {
		String str = AppConstant.EMPTY_STR;
		

		Boolean savePlan = this.planServices.savePlan(plan);
		if (savePlan) {
			str = Messages.get(AppConstant.PLAN_SAVE_SUCCESSFULLY);
			logger.info(AppConstant.EXECUTION_COMPLETED);
		} else {
			logger.error(AppConstant.EXECUTION_FAILED);
		}

		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// Get Plan By Id
	@GetMapping("/plan/{pid}")
	public ResponseEntity<Plan> GetPlanById(@PathVariable int pid) {
		String str = AppConstant.EMPTY_STR;

		Plan planById = this.planServices.getPlanById(pid);
		if (planById != null) {
			str = AppConstant.PLAN_SAVE_SUCCESSFULLY;
			logger.info(AppConstant.EXECUTION_COMPLETED + planById);
		} else {
			str = AppConstant.PLAN_SAVE_FAILED;
			logger.error(AppConstant.EXECUTION_FAILED);
		}

		return new ResponseEntity<Plan>(planById, HttpStatus.OK);
	}

	// Deleted By Id Method
	@DeleteMapping("/plan/{pid}")
	public ResponseEntity<String> DeleteById(@PathVariable int pid) {
		String str = AppConstant.EMPTY_STR;

		Boolean hardDelete = this.planServices.hardDelete(pid);
		if (hardDelete) {
			str = AppConstant.PLAN_DELETE_SUCCESSFULLY;
			logger.info(AppConstant.EXECUTION_COMPLETED);
		} else {
			str = AppConstant.PLAN_DELETE_FAILED;
			logger.info(AppConstant.EXECUTION_FAILED);
		}

		return new ResponseEntity<String>(str, HttpStatus.OK);

	}

	// Get All Plans
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> GetAllPlans() {

		List<Plan> showAllPlan = this.planServices.showAllPlan();
		logger.info(AppConstant.EXECUTION_COMPLETED + showAllPlan);
		return new ResponseEntity<List<Plan>>(showAllPlan, HttpStatus.OK);
	}

	// Update Plan
	@PutMapping("/plan/save")
	public ResponseEntity<String> UpdatePlan(@RequestBody Plan plan) {
		String str = AppConstant.EMPTY_STR;

		 Boolean savePlan = this.planServices.savePlan(plan);
		if (savePlan) {
			str = AppConstant.PLAN_UPDATE_SUCCESSFULLY;
			logger.info(AppConstant.EXECUTION_COMPLETED + str);
		} else {
			str = AppConstant.PLAN_UPDATE_FAILED;
			logger.info(AppConstant.EXECUTION_FAILED);
		}

		return new ResponseEntity<String>(str, HttpStatus.CREATED);
	}

	// Status Change
	@GetMapping("/status/{pid}/{statusname}")
	public ResponseEntity<String> StatusChange(@PathVariable int pid, @PathVariable String statusname) {
		String str = AppConstant.EMPTY_STR;

		Boolean changeStatus = this.planServices.changeStatus(pid, statusname);
		if (changeStatus) {
			str = AppConstant.PLAN_STATUSCHANGE_SUCCESSFULLY;
			logger.info(AppConstant.EXECUTION_COMPLETED);
		} else {
			str = AppConstant.PLAN_STATUS_CHANGEFAILED;
			logger.error(AppConstant.EXECUTION_FAILED);
		}

		return new ResponseEntity<String>(str, HttpStatus.OK);

	}
}
