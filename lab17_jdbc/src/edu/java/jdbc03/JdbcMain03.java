package edu.java.jdbc03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;
import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.model.Blog.Entity.*;

public class JdbcMain03 {

    public static void main(String[] args) {
        // JDBC를 사용한 update
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            String sql = String.format("update %s set %s=?, %s=? , %s = sysdate where %s = ?",
                    TBL_BLOGS,COL_TITLE,COL_CONTENT,COL_MODIFIED_DATE,COL_BOLG_NO);
            System.out.println(sql);
            
            stmt = conn.prepareStatement(sql);
            
            System.out.print("업데이트 할 글 번호>> ");
            int no = Integer.parseInt(scanner.nextLine());
            System.out.print("업데이트 할 제목>> ");
            String title = scanner.nextLine();
            System.out.print("업데이트할 내용을 입력하세요>> ");
            String content = scanner.nextLine();
            
            
            stmt.setString(1, title);
            stmt.setString(2, content);
            stmt.setInt(3, no);
            
            int result = stmt.executeUpdate();
            System.out.println(result + " 개 행이 업데이트됐습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
