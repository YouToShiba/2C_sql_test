import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test_sql_connect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql = "INSERT INTO t_test (id, test) VALUES (3, 'test_sql3');";
        Statement stmt = null;

        try {
            // オブジェクト生成
            sql_connect sql_connect = new sql_connect();
            // psql接続
            stmt = sql_connect.return_stmt();
            // sql実行
            stmt.executeUpdate(sql);
            // stmtを閉じる
            sql_connect.close_psql(stmt);
        } catch (Exception e) {
			e.printStackTrace();
        }
    }
}
