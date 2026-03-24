import java.sql.*;
import java.util.Scanner;

public class Practical_21 {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:8080/java_student";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {

            int choice;

            do {
                System.out.println("\n--- Student Information System ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertStudent(connection, scanner);
                        break;
                    case 2:
                        updateStudent(connection, scanner);
                        break;
                    case 3:
                        deleteStudent(connection, scanner);
                        break;
                    case 4:
                        displayStudents(connection);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 5);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---------------- INSERT ----------------
    private static void insertStudent(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            CallableStatement cs =
                    connection.prepareCall("{call insert_student(?,?,?,?)}");

            cs.setInt(1, id);
            cs.setString(2, name);
            cs.setInt(3, age);
            cs.setString(4, course);

            cs.execute();
            System.out.println("Student inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    // ---------------- UPDATE ----------------
    private static void updateStudent(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Student ID to Update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter New Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter New Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter New Course: ");
            String course = scanner.nextLine();

            CallableStatement cs =
                    connection.prepareCall("{call update_student(?,?,?,?)}");

            cs.setInt(1, id);
            cs.setString(2, name);
            cs.setInt(3, age);
            cs.setString(4, course);

            cs.execute();
            System.out.println("Student updated successfully!");

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    // ---------------- DELETE ----------------
    private static void deleteStudent(Connection connection, Scanner scanner) {
        try {
            System.out.print("Enter Student ID to Delete: ");
            int id = scanner.nextInt();

            CallableStatement cs =
                    connection.prepareCall("{call delete_student(?)}");

            cs.setInt(1, id);
            cs.execute();

            System.out.println("Student deleted successfully!");

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    // ---------------- DISPLAY ----------------
    private static void displayStudents(Connection connection) {
        try {
            CallableStatement cs =
                    connection.prepareCall("{call get_all_students()}");

            ResultSet rs = cs.executeQuery();

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("student_id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Course: " + rs.getString("course")
                );
            }

        } catch (SQLException e) {
            System.out.println("Display failed: " + e.getMessage());
        }
    }
}
