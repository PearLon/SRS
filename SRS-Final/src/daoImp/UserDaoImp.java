package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UserDao;
import model.Person;
import model.Professor;
import model.Student;
import model.User;
import util.DBUtil;

public class UserDaoImp implements UserDao {
	private Connection conn = DBUtil.open();
	
	@Override
	public User login(String username,String password) {
		String sql = "select * from user where username=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				return new User(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Person getPerson(String ssn, int type) {
		String sql = "select * from person where ssn=? and type=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ssn);
			pstmt.setInt(2, type);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				if(type==1){
					return new Professor(rs.getString("name"),ssn,
							rs.getString("title"),rs.getString("department"));
				}else{
					return new Student(rs.getString("name"),ssn,
							rs.getString("major"),rs.getString("degree"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public int addCourseToPerson(String ssn, String sectionno) {
		Connection conn = DBUtil.open();
		String sql = "update person set hassectionno = ? where ssn=?";
		String temp = "select hassectionno from person where ssn = ?";
		String var = "";
		try {
			PreparedStatement p = conn.prepareStatement(temp);
			p.setString(1, ssn);
			ResultSet rs = p.executeQuery();
			if(rs.next())	var = rs.getString("hassectionno");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, var+"£¬"+sectionno);
			pstmt.setString(2, ssn);
			System.out.println(var+"£¬"+sectionno);
			System.out.println(ssn);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return 0;
	}
}
