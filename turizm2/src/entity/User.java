package entity;

import core.Db;
import core.Helper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class User {
    private int id;
    private String name;
    private String uname;
    private String pass;
    private String type;


    public User(int id, String name, String uname, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public static User getFetch(String uname, String pass) {
        User obj = null;
        String query = "SELECT * FROM \"user\" WHERE lower(uname) = ? AND pass = ?";
        try{
            PreparedStatement pr = Db.getInstance().prepareStatement(query);
            pr.setString(1,uname.toLowerCase());
            pr.setString(2,pass);
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
              switch (rs.getString("type")){
                    case "admin":
                        obj = new Admin();
                        break;
                    case "employee":
                        obj = new Employee();
                        break;
                    default:
                        obj = new User();
                }
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return obj;
    }

    //User Arraylistimiz.
    public static ArrayList<User> getList(){
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM \"user\"";
        User obj;
        try {
            Statement st = Db.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;
    }

    //Veritabanından cagrılmak için yazılan getFetch metotumuz
    public static User getFetch(String uname){
        User obj = null;
        String query = "SELECT * FROM \"user\" WHERE lower(uname) = ?";
        try {
            PreparedStatement pr = Db.getInstance().prepareStatement(query);
            pr.setString(1,uname.toLowerCase());
            ResultSet rs = pr.executeQuery();
            if (rs.next()){
                obj = new User();
                obj.setId((rs.getInt("id")));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    //User ekleme kısmı
    public static boolean add(String name, String uname, String pass, String type) {
        String query = "INSERT INTO \"user\" (name, uname, pass, type) VALUES (?,?,?,?)";
        User findUser = getFetch(uname);
        if (findUser != null){
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiştir. Lütfen Farklı bir Kullanıcı adı Giriniz.");
            return false;
        }
        try {
            PreparedStatement pr = Db.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);

            int response = pr.executeUpdate();

            if(response == -1){
                Helper.showMsg("error");
            }
            return response !=-1;
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return true;
    }

    public static boolean delete(int id){
        String query = "DELETE FROM \"user\" WHERE id = ?";
        try {
            PreparedStatement pr = Db.getInstance().prepareStatement(query);
            pr.setInt(1,id);
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static String searchQuery(String name, String uname , String type){
        String query = "SELECT * FROM \"user\" WHERE lower(uname) LIKE '%{{uname}}%' AND name LIKE '%{{name}}%'";
        query = query.replace("{{uname}}" , uname.toLowerCase());
        query = query.replace("{{name}}" , name);
        if (!type.isEmpty()){
            query += " AND type='{{type}}'";
            query = query.replace("{{type}}" , type);
        }
        System.out.println(query);
        return query;
    }

    public static ArrayList<User> searchUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();
        User obj;
        try {
            Statement st = Db.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUname(rs.getString("uname"));
                obj.setPass(rs.getString("pass"));
                obj.setType(rs.getString("type"));
                userList.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public static boolean update(int id, String name, String uname,String pass, String type){
        String query = "UPDATE \"user\" SET name=?, uname=?, pass=?, type=? WHERE id = ?";
        User findUser = User.getFetch(uname);
        if(findUser != null && findUser.getId() != id) {
            Helper.showMsg("Bu kullanıcı adı daha önceden eklenmiş. Lütfen farklı bir kullanıcı adı giriniz.!");
            return false;
        }
        try {
            PreparedStatement pr = Db.getInstance().prepareStatement(query);
            pr.setString(1,name);
            pr.setString(2,uname);
            pr.setString(4,pass);
            pr.setString(5,type);
            pr.setInt(6,id);
            return  pr.executeUpdate() != -1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}