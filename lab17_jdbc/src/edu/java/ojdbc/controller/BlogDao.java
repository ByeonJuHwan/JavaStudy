package edu.java.ojdbc.controller;

import java.util.List;

import edu.java.ojdbc.model.Blog;

public interface BlogDao {
    
    List<Blog> select(); // SQL_SEELCT_ALL
    Blog select(Integer blogNo); // SQL_SELECT_BY_NO
    int insert(Blog blog); // SQL_INSERT
    int update(Blog blog); // SQL_UPDATE
    int delete(Integer blogNo); //SQL_DELETE
    

}
