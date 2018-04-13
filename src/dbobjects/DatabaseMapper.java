package dbobjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojos.Student;

public class DatabaseMapper {

	public void saveStudents(Student studentData) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "root",
					"77@Jaiganpathi");
			// Statement myStat=myConn.createStatement();
			String myRs = "INSERT INTO testdb.student (StudentName,StudentAddress,StudentEmail,StudentTelephone,Comments)"
					+ "VALUES (?,?,?,?,?)";

			PreparedStatement preparedStmt = myConn.prepareStatement(myRs);
			preparedStmt.setString(1, studentData.getFirstName());
			preparedStmt.setString(2, studentData.getStreetAddress());
			preparedStmt.setString(3, studentData.getEmail());
			preparedStmt.setString(4, studentData.getTelphoneNumber());
			preparedStmt.setString(5, studentData.getComments());

			// execute the preparedstatement
			preparedStmt.execute();

			myConn.close();

			/*
			 * while(myRs.next()) { System.out.print(myRs.getString("empNo")); }
			 */
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public List<Student> getStudents() {
		Student student;
		List<Student> students = new ArrayList<Student>();
		int i = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "root",
					"77@Jaiganpathi");
			Statement myStat = myConn.createStatement();
			ResultSet myRs = myStat.executeQuery("SELECT * FROM testdb.student");

			while (myRs.next()) {
				student = new Student();
				student.setFirstName(myRs.getString("StudentName"));
				student.setStreetAddress(myRs.getString("StudentAddress"));
				student.setEmail(myRs.getString("StudentEmail"));
				student.setTelphoneNumber(myRs.getString("StudentTelephone"));
				student.setComments(myRs.getString("Comments"));

				students.add(i, student);
				i++;

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return students;
	}

}
