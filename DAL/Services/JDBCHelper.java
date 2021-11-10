package DAL.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {

    private static final String URL = "jdbc:sqlserver://localhost;database=QLBanDienThoai";
    private static final String DRIVE = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "1234";

    static {
        try {
            Class.forName(DRIVE);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static PreparedStatement prepareStatement(String sql, Object... args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = connection.prepareCall(sql);
        } else {
            pstmt = connection.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }

    public static void executeUpdate(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = prepareStatement(sql, args);
        try {
            stmt.executeUpdate();
        } finally {
            stmt.getConnection().close();
        }
    }

    public static ResultSet executeQuery(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            if (rs.next()) {
                rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static int update(String sql, Object...args){
        try {
            PreparedStatement stmt = JDBCHelper.prepareStatement(sql, args);
            try {
                return stmt.executeUpdate();
            } finally{
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
