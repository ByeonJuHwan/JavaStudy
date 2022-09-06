package edu.java.mvc.controller;

import edu.java.mvc.model.Member;

// Controller, DAO (Data Access Object)
public class MemberDaoImpl implements MemberDao{
    
    // Member 객체를 저장할 배열의 최대 크기
    public static final int MAX_LENGTH = 3;
    
    // Member 객체들을 저장할 배열 Member의 메서드도 사용가능
    private Member[] memberList = new Member[MAX_LENGTH];
    
    // 배열에 저장된 Member 객체의 수. Member 객체가 배열에 저장될 때마다 1씩 증가.
    private int count = 0;
    
    public int getCount() {
    	return count;
    }
    
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
    		if(count >= MAX_LENGTH) {  // 배열에 저장할 공간이 부족할 때
    			return 0;
    		}
    		memberList[count]=m;
            count++;
            
            return 1;
    }

    @Override
    public Member[] read() {
    	//  memberList를 그대로 리턴하지 말고, 
    	// 실제로 저장된 Member 개수만큼만 배열을 새로 생성해서 리턴.
    	Member [] members = new Member[count];
    	for(int i=0; i<count; i++) {
    		members[i] = memberList[i];
    	}
    	
        return members;
    }

    @Override
    public Member read(int index) {
      
    	if(index>=0 && index <MAX_LENGTH) {
    		return memberList[index];
    	}else {
    		return null;
    	}
        
    }

    @Override
    public int update(int index, String password) {
       
    	if(index>=0 && index<count) {
    		memberList[index].setMemberPassword(password); 
            return 1;
    	}else {
    		return 0;
    	}
        
    }
    
    
    
}

