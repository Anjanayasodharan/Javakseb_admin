import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;

public class Admin {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
        }
        catch (Exception e){
            System.out.println(e);
        }
        int choice;
        while (true) {
            System.out.println("select an option from the menu");
            System.out.println("1 add consumer")
            System.out.println("2 search consumer ")
            System.out.println("3 delete consumer")
            System.out.println("4 update consumer")
            System.out.println("5 view all consumer")
            System.out.println("6 generate bill")
            System.out.println("7 view bill")
            System.out.println("8 Top 2 high bill")
            System.out.println("9 exit")
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("insert student selected");
                    break;
                case 2:
                    System.out.println("select student selected");
                    break;
                case 3:
                    System.out.println("search student selected");
                    break;
                case 4:
                    System.out.println("delete student selected");
                    break;
                case 5:
                    System.out.println("update student selected");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
