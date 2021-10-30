import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sql extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = null;
        Statement stmt = null;

        try {
			// 接続
            String sql = "INSERT INTO t_test (id, test) VALUES (2, 'test_sql2');";
			String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/team_one_db";

            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
			con = DriverManager.getConnection(url,"al19100","bond");

            stmt = con.createStatement();

            stmt.executeUpdate(sql);

            response.sendRedirect("./../../test/tomcat_complete.html");
        } catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                stmt.close();
                con.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
