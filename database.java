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
    public boolean data(int ID){
        String sql = "SELECT ID FROM professor WHERE ID = ? LIMIT 1";
        try (Connection conn = getconnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, ID);
            

        try (ResultSet rs = pstmt.executeQuery()) {
            // rs.next() returns true if the ID exists in the table
            return rs.next(); 
        }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        return false;  
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

        if (rs.next()) {
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
}
