import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDataInsertion {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database"; // Replace 'your_database' with actual database name
        String user = "root"; // Replace with your username
        String password = "0604"; // Replace with your password

        String insertQuery = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        // Data to insert
        int[][] employeeData = {
                {101, 25, 10000},
                {102, 30, 20000},
                {103, 20, 40000},
                {104, 40, 80000},
                {105, 25, 90000}
        };

        String[] employeeNames = { "Jenny", "Jacky", "Joe", "John", "Shameer" };

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            for (int i = 0; i < employeeData.length; i++) {
                pstmt.setInt(1, employeeData[i][0]); // empcode
                pstmt.setString(2, employeeNames[i]); // empname
                pstmt.setInt(3, employeeData[i][1]); // empage
                pstmt.setInt(4, employeeData[i][2]); // esalary
                pstmt.executeUpdate(); // Execute insertion query
            }
            System.out.println("Data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
