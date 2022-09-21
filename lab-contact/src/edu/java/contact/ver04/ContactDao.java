package edu.java.contact.ver04;

import java.util.List;

// MVC 아키텍쳐에서 Controller에 해당하는 인터페이스.
// 인터페이스 구현은 ContactDaoImpl 클래스에서.
// DAO(Data Access Object) : 데이터의 CURD(Create, Read, Update, Delete) 기능을 담당.
public interface ContactDao {
    
    /**
     * 연락처 정보를 저장하고 있는 리스트를 리턴.
     * @return List<Contact>. 연락처가 하나도 없는 경우에는 빈 리스트를 리턴. null을 리턴하지 않는다.
     */
    List<Contact> read();
    
    /**
     * 인덱스 검색 기능.
     * @param index 연락처를 리스트에서 검색하기 위한 인덱스. 0 이상의 정수.
     * @return Contact 객체. 해당 인덱스의 연락처 정보가 없는 경우에는 null을 리턴.
     */
    Contact read(int index);
    
    
    /**
     * 새 연락처 추가 기능.
     * @param contact 리스트에 추가(add)할 연락처 정보.
     * @return 리스트에 저장 성공하면 1, 그렇지 않으면 0.
     */
    int create(Contact contact);
    
    
    /**
     * 연락처 정보 업데이트 기능
     * @param index 업데이트하려는 연락처의 인덱스. 0이상의 정수.
     * @param contact 업데이트할 정보
     * @return 업데이트 성공하면 1, 그렇지 않으면 0.
     */
    int upate(int index, String command);
    
    
    /**
     * 연락처 삭제 기능.
     * @param index 삭제하려는 연락처의 인덱스. 0이상의 정수.
     * @return 삭제 성공하면 1, 그렇지 않으면 0.
     */
    int delete(int index);
    
}
