package service;

import java.util.List;

import dao.PlanDao;
import daoImp.PlanDaoImp;
import model.Course;

public class PlanService {
	private PlanDao dao = new PlanDaoImp();
	
	public List<Course> getCourses(String ssn){
		return dao.getCourses(ssn);
	}
	
}
