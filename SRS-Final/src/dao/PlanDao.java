package dao;

import java.util.List;

import model.Course;

public interface PlanDao {

	public List<Course> getCourses(String ssn);


	public Course getCourseByNo(String courseNo);

}
