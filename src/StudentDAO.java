// StudentDAO.java
// Handles DB operations for Student

import java.sql.*;
import java.util.*;
import customexceptions.*;

public class StudentDAO {

    public void addToDatabase(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO students (name, prn, age, cgpa) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, student.getName());
            stmt.setLong(2, student.getPrn());
            stmt.setInt(3, student.getAge());
            stmt.setDouble(4, student.getCgpa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database Error while adding student: " + e.getMessage());
        }
    }

    public void deleteFromDatabase(long prn) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM students WHERE prn = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setLong(1, prn);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database Error while deleting student: " + e.getMessage());
        }
    }

    public void updateInDatabase(Student student) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE students SET name = ?, age = ?, cgpa = ? WHERE prn = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setDouble(3, student.getCgpa());
            stmt.setLong(4, student.getPrn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Database Error while updating student: " + e.getMessage());
        }
    }

    public void loadAllFromDatabase(ArrayList<Student> list) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student s = new Student(
                        rs.getString("name"),
                        rs.getLong("prn"),
                        rs.getInt("age"),
                        rs.getDouble("cgpa")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Database Error while loading students: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Validation error loading students: " + e.getMessage());
        }
    }
}
