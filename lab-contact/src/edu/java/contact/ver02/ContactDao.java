package edu.java.contact.ver02;

//  MVC 아키텍쳐에서 Controller의 인터페이스 - 메서드 선언
public interface ContactDao {
	
	/**
	 * 1번메뉴 Select_ALL 에 들어갈메서드 
	 * Contact 연락처 전부를 보여준다.
	 * @return 저장된 연락처의 배열
	 */
	Contact[] show();
	
	/**
	 * 2번메뉴 Select_By_Index에 들어갈메서드
	 * 인덱스를 사용한 연락처 검색 기능. 배열에서 해당 인덱스의 연락처를 찾아서 보여준다.
	 * 
	 * @param index 검색할 연락처의 인덱스. 0이상의 정수
	 * @return 배열의 index에 위치한 null이 아닌 연락처가 있으면 그 객체를 리턴,
	 *  배열의 범위 밖에 있거나, 해당 인덱스의 배열 원소가 null이면 null을 리턴.
	 */
	Contact show(int index);
	
	/**
	 * 새로운 연락처 객체를 받아서 저장
	 * @param c 새로운 연락처 정보
	 * @return 성공하면 1을 리턴, 실패시 0리턴
	 */
	int create(Contact c);
	
	
	/**
	 * 수정할 연락처의 index를 받고 이름, 연락처, 이메일중 무엇을 
	 * 수정할지 받은후에 알맞게 수정한다.
	 * @param index 수정할 연락처의 배열 인덱스. 0이상의 정수
	 * @param command 이름, 번호, 이메일을 받아서 알맞게 수정
	 * @return 수정 성공시 1리턴, 실패시 0리턴
	 */
	int update(int index, String command);
}
