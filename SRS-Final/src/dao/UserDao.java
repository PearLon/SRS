package dao;

import model.Person;
import model.User;

public interface UserDao {

	public User login(String username,String password);

	public Person getPerson(String ssn,int type);

	public int addCourseToPerson(String ssn,String sectionno);
}
