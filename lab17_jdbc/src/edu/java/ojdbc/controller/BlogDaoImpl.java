package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.java.ojdbc.model.Blog;
import oracle.jdbc.OracleDriver;
import static edu.java.ojdbc.OracleJdbc.*;
import static edu.java.ojdbc.controller.JdbcSql.*;
import static edu.java.ojdbc.model.Blog.Entity.COL_AUTHOR;
import static edu.java.ojdbc.model.Blog.Entity.COL_BOLG_NO;
import static edu.java.ojdbc.model.Blog.Entity.COL_CONTENT;
import static edu.java.ojdbc.model.Blog.Entity.COL_CREATED_DATE;
import static edu.java.ojdbc.model.Blog.Entity.COL_MODIFIED_DATE;
import static edu.java.ojdbc.model.Blog.Entity.COL_TITLE;

public class BlogDaoImpl implements BlogDao {
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    // Singleton 적용
    private static BlogDaoImpl instance = null;
    private BlogDaoImpl() {}
    public static BlogDaoImpl getInstance() {
        if(instance == null) {
            instance = new BlogDaoImpl();
        }
        return instance;
    }
    
    // executeUpdate 일 경우
    private void closeResources(Connection conn, Statement stmt) throws SQLException{
        stmt.close();
        conn.close();
    }
    
    // executeQuery 일경우 
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException{
        rs.close();
        closeResources(conn,stmt);
    }
    
    
    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>(); // 리턴하기위한 ArrayLst - select의 결과를 저장
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_ALL); // SQL 문장 준비
            
            rs =stmt.executeQuery(); // SQL 문장 실행
            while(rs.next()) { // ResultSet에 row 데이터가 있으면
                // row에서 각 column에 이쓴 값들을 분석.
                Integer blogNo = rs.getInt(COL_BOLG_NO); // BOLG_NO 컬럼의 값(number)을 읽음.
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                // Blog 타입 객체 생성
                Blog blog = new Blog(blogNo,title,content,author,createdDate,modifiedDate);
                list.add(blog); // 결과 ArrayList에 추가.
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                closeResources(conn, stmt, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    

    @Override
    public Blog select(Integer No) {
    	 Blog blog = null; // (DB에서 검색한) 리턴할 Blog 타입 객체.
    	try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			System.out.println(SQL_SELECT_BY_NO);
			stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
			
			stmt.setInt(1, No);
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				Integer blogNo = rs.getInt(COL_BOLG_NO); // BOLG_NO 컬럼의 값(number)을 읽음.
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                blog = new Blog(blogNo,title,content,author,createdDate,modifiedDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return blog;
    	
    }

    @Override
    public int insert(Blog blog) {
    	int result=0;
    	try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, blog.getTitle());
			stmt.setString(2, blog.getContent());
			stmt.setString(3, blog.getAuthor());
			
			result = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return result;
    }

    @Override
    public int update(Blog blog) {
    	int result = 0;
    	try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, blog.getTitle());
			stmt.setString(2, blog.getContent());
			stmt.setInt(3, blog.getBlogNo());
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return result;
    }

    @Override
    public int delete(Integer blogNo) {
        int result=0;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_DELETE);
            int no = blogNo;
            
            stmt.setInt(1, no);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }finally {
            try {
                closeResources(conn, stmt);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }
	@Override
	public List<Blog> selectByColumn(String category ,String text) {
		List<Blog> list = new ArrayList<>();
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn  = DriverManager.getConnection(URL, USER, PASSWORD);
			
			if(category.equals("제목")) {
				category = COL_TITLE;
			}else if(category.equals("내용")){
				category = COL_CONTENT;
			}else {
				category = COL_AUTHOR;
			}
		
			stmt = conn.prepareStatement(SQL_SELECT_BY_COLUMN+" where " + category + " like '%" + text +"%'"+" order by "+COL_BOLG_NO+" desc");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Integer blogNo = rs.getInt(COL_BOLG_NO); // BOLG_NO 컬럼의 값(number)을 읽음.
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                Blog blog = new Blog(blogNo,title,content,author,createdDate,modifiedDate);
                list.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeResources(conn, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}