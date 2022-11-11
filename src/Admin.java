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
            System.out.println("1 add consumer");
            System.out.println("2 search consumer ");
            System.out.println("3 delete consumer");
            System.out.println("4 update consumer");
            System.out.println("5 view all consumer");
            System.out.println("6 generate bill");
            System.out.println("7 view bill");
            System.out.println("8 Top 2 high bill");
            System.out.println("9 exit");
            Scanner sc = new Scanner(System.in);

            choice = sc.nextInt();
            int code,phone;
            String name,address,email;
            switch (choice) {
                case 1:
                    System.out.println("Add customer details...");
                    System.out.println("Enter the customer code");
                    code=sc.nextInt();
                    System.out.println("Enter the  name:--");
                    name=sc.next();
                    System.out.println("Enter the Address:--");
                    address=sc.next();
                    System.out.println("Enter the phone:--");
                    phone=sc.nextInt();
                    System.out.println("Enter the email:--");
                    email=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="INSERT INTO `consumer`(`code`, `name`, `address`, `phno`, `email`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement((sql));
                        stmt.setInt(1,code);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,phone);
                        stmt.setString(5,email);
                        stmt.executeUpdate();
                        System.out.println("value inserted successfully.........!");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 2:
                    System.out.println("1.search using name");
                    System.out.println("2.search using phone number");
                    System.out.println("3.search using code");
                    int choice1 = sc.nextInt();
                    switch (choice1)
                    {
                        case 1:
                            System.out.println("enter the name:-");
                            name = sc.next();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `name`='"+name+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phno = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.println("enter phone number for search :-");
                            phone = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `phno`='"+phone+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phno = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                        case 3:
                            System.out.println("Enter customer code for search");
                            code = sc.nextInt();
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb", "root", "");
                                String sql = "SELECT  `name`, `address`, `phno`, `email` FROM `consumer` WHERE `code`='"+code+"'";
                                Statement stmt=con.createStatement();
                                ResultSet rs=stmt.executeQuery(sql);
                                while(rs.next()){
                                    name = rs.getString("name");
                                    address = rs.getString("address");
                                    phone = rs.getInt("phno");
                                    email = rs.getString("email");
                                    System.out.println("name = "+name);
                                    System.out.println("address = "+address);
                                    System.out.println("phno = "+phone);
                                    System.out.println("Email id = "+email+'\n');
                                }
                            }
                            catch (Exception e){
                                System.out.println(e);
                            }
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Delete customer");
                    System.out.println("enter the code ");
                    code=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admindb","root","");
                        String sql="DELETE FROM `consumer` WHERE `code`="+String.valueOf(code);
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully.....");
                    }
                    catch (Exception e){
                        System.out.println((e));
                    }
                    break;
                case 4:
                    System.out.println("update consumer selected");
                    break;
                case 5:
                    System.out.println("view all consumer selected");
                    break;
                case 6:
                    System.out.println("generate bill");
                    break;
                case 7:
                    System.out.println("view bill");
                    break;
                case 8:
                    System.out.println("Top 2 high bill");
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    }
}
