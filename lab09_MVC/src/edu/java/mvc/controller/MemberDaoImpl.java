package edu.java.mvc.controller;

import edu.java.mvc.model.Member;

// Controller, DAO (Data Access Object)
public class MemberDaoImpl implements MemberDao{
    
    // Member 객체를 저장할 배열의 최대 크기
    private static final int MAX_LENGTH = 3;
    
    // Member 객체들을 저장할 배열
    private Member[] memberList = new Member[MAX_LENGTH];
    
    // 배열에 저장된 Member 객체의 수. Member 객체가 배열에 저장될 때마다 1씩 증가.
    private int count = 0;
    
    
    // Controller 클래스는 Singleton으로 설계 : 1) + 2) + 3)  
    
    // 1) 자기자신 타입의 private static인 변수 선언
    private static MemberDaoImpl instance = null;
    
    // 2) private 생성자
    private MemberDaoImpl() {
    }
    
    // 3) 자기자신 타입을 리턴하는 public static 메서드 정의
    public static MemberDaoImpl getInstance() {
        if(instance==null) {
            instance = new MemberDaoImpl();
        }
        return instance;
    }
    
    @Override
    public int create(Member m) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Member[] read() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Member read(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int update(int index, String password) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    
    
}

