import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sql_connect extends HttpServlet {

    public Connection con;

    // SQLに接続し、stmtを返す
    public Statement return_stmt () {
        String url = "jdbc:postgresql://tokushima.data.ise.shibaura-it.ac.jp:5432/team_one_db";

        Statement stmt = null;
        try {
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
            con = DriverManager.getConnection(url,"al19100","bond");
            stmt = con.createStatement();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return stmt;
    }

    // stmtを閉じる
    public void close_psql (Statement stmt) {
        try {
            stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
