package edu.java.contact.ver02;

import java.util.Scanner;

// MVC 아키텍쳐에서 Controller (구현) 클래스
public class ContactDaoImpl implements ContactDao{

	public static final int MAX_LENGTH =3;
	
	Scanner scanner = new Scanner(System.in);
	
	private Contact[] contactList = new Contact[MAX_LENGTH];
	
	private int count =0;
	
	public int getCount() {
		return count;
	}
	
	// 싱글톤 생성
	// 1. 자기자신 타입의 private static 인 변수 선언
	private static ContactDaoImpl instance = null;
	
	// 2. private 생성자
	private ContactDaoImpl() {}
	
	// 3. 자기 자신을 리턴하는 public static 메서드 정의
	public static ContactDaoImpl getInstance() {
		if(instance ==null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	@Override
	public Contact[] show() {
		Contact[] contacts = new Contact[count];
		for(int i=0; i<count; i++) {
			contacts[i] = contactList[i];
		}
		return contacts;
	}

	@Override
	public Contact show(int index) {
		if(index>=0  && index<MAX_LENGTH  ) {
			return contactList[index];
		}
		return null;
	}

	@Override
	public int create(Contact c) {
		if(count>=MAX_LENGTH) {
			return 0;
		}
		contactList[count]=c;
		count++;
		return 1;
	}

	@Override
	public int update(int index, String command) {
		
		// 인데스0의 값이 null이어서 연락처가 등록이 되어있지 않을때
		
		if(index>=0 && index<count) {
			if(command != null && command.equals("이름")) {
				System.out.print("변경하고싶은 이름을 입력해주세요>> ");
				String name = scanner.nextLine();
				contactList[index].setName(name);
				return 1;
			}else if(command != null && command.equals("번호")) {
				System.out.print("변경하고싶은 번호를 입력해주세요>> ");
				String phone = scanner.nextLine();
				contactList[index].setPhone(phone);
				return 1;
			}else if(command != null && command.equals("이메일")) {
				System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
				String email = scanner.nextLine();
				contactList[index].setEmail(email);
				return 1;
			}else if (command != null && (command.equals("이름 번호") ||command.equals("번호 이름"))){
				System.out.print("변경하고싶은 이름을 입력해주세요>> ");
				String name = scanner.nextLine();
				contactList[index].setName(name);
				System.out.print("변경하고싶은 번호를 입력해주세요>> ");
				String phone = scanner.nextLine();
				contactList[index].setPhone(phone);
				return 1;
			}else if(command != null && (command.equals("이름 이메일") ||command.equals("이메일 이름"))) {
				System.out.print("변경하고싶은 이름을 입력해주세요>> ");
				String name = scanner.nextLine();
				contactList[index].setName(name);
				System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
				String email = scanner.nextLine();
				contactList[index].setEmail(email);
				return 1;
			}else if (command != null && (command.equals("번호 이메일") ||command.equals("이메일 번호"))) {
				System.out.print("변경하고싶은 번호를 입력해주세요>> ");
				String phone = scanner.nextLine();
				contactList[index].setPhone(phone);
				System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
				String email = scanner.nextLine();
				contactList[index].setEmail(email);
				return 1;
			}else if(command != null && (command.equals("이름 번호 이메일") ||command.equals("이름 이메일 번호" )
					||command.equals("번호 이름 이메일")|| command.equals("번호 이메일 이름")
					||command.equals("이메일 이름 번호")||command.equals("이메일 번호 이름"))) {
				System.out.print("변경하고싶은 이름을 입력해주세요>> ");
				String name = scanner.nextLine();
				contactList[index].setName(name);
				System.out.print("변경하고싶은 번호를 입력해주세요>> ");
				String phone = scanner.nextLine();
				contactList[index].setPhone(phone);
				System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
				String email = scanner.nextLine();
				contactList[index].setEmail(email);
				
				return 1;
			}
			
	}
		return 0;
	
	
	}	
	
}
