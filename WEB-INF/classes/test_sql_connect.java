import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test_sql_connect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql = "INSERT INTO t_test (id, test) VALUES (4, 'test_sql4');";
        Connection con = null;
        Statement stmt = null;

        try {
            // オブジェクト生成
            sql_connect sql_connect = new sql_connect();
            // psql接続
            con = sql_connect.return_con();
            // statement作成
            stmt = con.createStatement();
            // sql実行
            stmt.executeUpdate(sql);

            // 画面遷移
            response.sendRedirect("./../../test/tomcat_complete.html");
        } catch (Exception e) {
			e.printStackTrace();
            response.sendRedirect("./../../test/tomcat_complete.html");
        } finally{
            try{
                // オブジェクト開放
                if (con != null){
                    con.close();
                }
                if (stmt != null){
                    stmt.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
