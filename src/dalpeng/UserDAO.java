package dalpeng;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Park on 2017-04-08.
 */
public class UserDAO {
    private String DB_USERNAME = "test_user";
    private String DB_PASSWORD = "test_password";
    private String DB_DATABASE = "test_db";
    private Connection conn = null;
    String url="jdbc:mysql://localhost:3306";

    String jdbcurl = url + "/" + DB_DATABASE + "?autoReconnect=true&useSSL=false";
    public Connection getConnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcurl, DB_USERNAME, DB_PASSWORD);
            return conn;
        }catch (Exception e){
            System.out.print(e.getMessage());
            return null;
        }

    }
    private void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
    public void insert(User user) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement pstmt = null;

        String sql = "insert into user(id,pw) values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setInt(2, user.getPw());

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pstmt != null) {
                    pstmt.close();
                }
                closeConnection();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        }
    public ArrayList<User> check(){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from user";
        ArrayList prod = new ArrayList();
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                User User = new User(
                        rs.getInt("seq"),
                        rs.getString("id"),
                        rs.getInt("pwd")
                        );
                /*user.setId(rs.getString("id"));
                user.setPw(rs.getString("pw"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));*/
                prod.add(User);
            }
            pstmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return prod;
    }
    public ArrayList<word> check2(){
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from word";
        ArrayList prod = new ArrayList();
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()){
                word word = new word(
                        rs.getInt("seq"),
                        rs.getString("word"),
                        rs.getString("mean")
                );
                /*user.setId(rs.getString("id"));
                user.setPw(rs.getString("pw"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));*/
                prod.add(word);
            }
            pstmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return prod;
    }
}

