package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            
            rs =stmt.executeQuery();
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
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
           
        }
        return list;
    }
    

    @Override
    public Blog select(Integer No) {
    	 Map<Integer,Blog> map = new HashMap<>();
    	 Blog blog = new Blog();
    	try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.prepareStatement(SQL_SELECT_BY_NO);
			
			stmt.setInt(1, No);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				Integer blogNo = rs.getInt(COL_BOLG_NO); // BOLG_NO 컬럼의 값(number)을 읽음.
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime createdDate = rs.getTimestamp(COL_CREATED_DATE).toLocalDateTime();
                LocalDateTime modifiedDate = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                Blog blog1 = new Blog(blogNo,title,content,author,createdDate,modifiedDate);
                map.put(blogNo, blog1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	
    	blog = map.get(No);
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return result;
    }

    @Override
    public int update(Blog blog) {
        // TODO Auto-generated method stub
        return 0;
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
                stmt.close();
                conn.close();
            } catch (SQLException e) {
               
                e.printStackTrace();
            }
        }
        
        return result;
    }
   

}
