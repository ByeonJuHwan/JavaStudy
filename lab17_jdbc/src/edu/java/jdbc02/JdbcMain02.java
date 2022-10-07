package edu.java.jdbc02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleDriver;
import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.model.Blog.Entity.*;
public class JdbcMain02 {

    public static void main(String[] args) {
        // JDBC를 이용한 INSERT
        
        Scanner scanner = new Scanner(System.in);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 라이브러리 관리자에게 오라클 라이브러리를 등록.
            DriverManager.registerDriver(new OracleDriver());
            
            // 라이브러리 관리자를 이용해서 데이터베이스와 연결
            conn= DriverManager.getConnection(URL, USER, PASSWORD);
            
            // SQL 문장 - INSERT
            String sql = String.format("insert into %s (%s,%s,%s) values (?,?,?)", 
                                        TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_AUTHOR);
            System.out.println(sql);
            
            // PreparedStatement 생성
            stmt = conn.prepareStatement(sql);
            
            // 콘솔 창에서 블로그 글 제목, 내용, 작성자를 입력
            System.out.print("제목을 입력하세요>> ");
            String title = scanner.nextLine();
            System.out.print("내용을 입력하세요>> ");
            String content = scanner.nextLine();
            System.out.print("작성자를 입력하세요>> ");
            String author = scanner.nextLine();
            
            // PreparedStatement 객체에 입력받은 값들을 설정:
            stmt.setString(1, title);  // stmt에서 첫번째 ?를 변수 title 값으로 대체.
            stmt.setString(2, content); // stmt에서 두번째 ?를 변수 content 값으로 대체.
            stmt.setString(3, author); // stmt에서 세번째 ?를 변수 author 값으로 대체.
            
            
            // SQL 문장 실행
            int result = stmt.executeUpdate(); // 행의 개수가 리턴된다.
            
            // 실행결과 출력.
            System.out.println(result+" 개 행이 삽입됬습니다.");
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
