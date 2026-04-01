import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {
    static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("Driver NOT found in classpath!");
    }
}

    private static final String url = "jdbc:mysql://localhost:3306/studentmanagementdb";
    private static final String username = "root";
    private static final String password = "Atharva@root26";
    public static Connection getconnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    public void adduser(String user, int userid, String username, String password) {
        String sql = "INSERT INTO "+user+" (ID, NAME, passwords) VALUES (?, ?, ?)";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, userid);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
        
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new "+user+" was registered successfully!");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String data(int ID,String user){
        String sql = "SELECT passwords FROM "+user+" WHERE ID = ?";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, ID);
            

            try (ResultSet rs = pstmt.executeQuery()) {
                if(!rs.next()) return ""; 
                return rs.getString("passwords"); 
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";  
    }
    public void addData(int userid, String syllabus) {
        String sql = "UPDATE professor SET SYLLABUS = ? WHERE ID = "+userid;
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            
            pstmt.setString(1, syllabus);
        
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Syllabus is updated successfully");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showSyllabus(int ID){
        String sql = "SELECT ID, NAME, Syllabus FROM professor WHERE ID = ?";
        try (Connection conn = getconnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, ID);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            // Map the database columns to a Java Object
            System.out.println("ID\t||\tNAME\t||\tSyllabus");
            System.out.println("----------------------------------------------------------");
            System.out.print(rs.getInt("ID")+"\t||\t");
            System.out.print(rs.getString("NAME")+"\t||\t"); 
            System.out.println(rs.getString("Syllabus"));        
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String dataStudent(int ID,String password){
        String sql = "SELECT passwords FROM students WHERE ID = ?";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, ID);
            

            try (ResultSet rs = pstmt.executeQuery()) {
                if(!rs.next()) return ""; 
                return rs.getString("passwords"); 
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return "";  
    }
    public void addComplain(String s,int ID){
        String sql = "UPDATE students SET Complaint = ? WHERE ID = "+ID;
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setString(1, s);
        
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Complaint sent successfully");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    public void displayCourses(){
        String sql = "SELECT * FROM Courses";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            System.out.println("Course ID\t||\tCourse name\t||\tCredits");
            System.out.println("---------------------------------------------------------");
            while (rs.next()) {
                String id = rs.getString("ID");
                String name = rs.getString("Name");
                int credit = rs.getInt("Credits");
                System.out.println(id+"\t\t||\t"+name+"\t||\t"+credit);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void registerCourse(String cid,int ID){
        String sql = "UPDATE students SET Course = ? WHERE ID = "+ID;
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setString(1, cid);
        
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Courses registered successfully");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }        
    }
    public void addCourse(String ID,String Name,int Credits){
        String sql = "INSERT INTO courses (ID,Name,Credits) VALUES (?,?,?)";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setString(1, ID);
            pstmt.setString(2, Name);
            pstmt.setInt(3, Credits);
        
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Course updated successfully");
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }     
    }
    public void showComplaints(){
        String sql = "SELECT Complaint FROM students";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            System.out.println("ID\t||\tComplaints");
            System.out.println("---------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String complaint = rs.getString("Complaint");
                System.out.println(id+"\t||\t"+complaint);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
