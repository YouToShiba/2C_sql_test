import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sql_connect extends HttpServlet {
    // SQLに接続し、conを返す
    public Connection return_con () {
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/team_one_db";
        Connection con = null;
        try {
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url,"al19100","bond");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
