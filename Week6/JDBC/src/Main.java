import java.sql.*;

public class Main  {
    public static final String DB_URL = "jdbc:mysql://localhost/employees";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {
        Connection connect = null;
        String sql = "SELECT * FROM ss";

        try {
            connect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement st = connect.createStatement();
            ResultSet data = st.executeQuery(sql);

            while(data.next()){
                System.out.println("ID : " + data.getInt("id"));
                System.out.println("Name : " + data.getString("name"));
                System.out.println("Position : " + data.getString("position"));
                System.out.println("Salary : " + data.getInt("salary"));
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}