package edu.java.ojdbc.controller;

import static edu.java.ojdbc.model.Blog.Entity.*;

public interface JdbcSql {

    // 전체검색 - 블로그 글 번호 내림차순 정렬
    String SQL_SELECT_ALL = String.format("select * from %s order by %s desc", TBL_BLOGS,COL_BOLG_NO);
    
    // 블로그 글 번호로 검색.
    String SQL_SELECT_BY_NO = String.format("select * from %s where %s =?", TBL_BLOGS,COL_BOLG_NO);

    // 블로그 새 글 저장.
    String SQL_INSERT = String.format("insert into %s (%s,%s,%s) values (?,?,?)", TBL_BLOGS,COL_TITLE,COL_CONTENT,COL_AUTHOR);

    // 블로그 글 업데이트(수정).
    String SQL_UPDATE = String.format("update %s set %s=?, %s=?, %s=sysdate where %s=?" , TBL_BLOGS,COL_TITLE,COL_CONTENT,COL_MODIFIED_DATE,COL_BOLG_NO);
    
    // 블로그 글 삭제.
    String SQL_DELETE = String.format("delete from %s where %s = ?", TBL_BLOGS, COL_BOLG_NO);

    // 제목/내용/작성자로 검색하기
    // TODO
    String SQL_SELECT_BY_COLUMN = String.format("select * from %s", TBL_BLOGS);
}
