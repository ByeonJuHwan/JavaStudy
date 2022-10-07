package edu.java.contact.ver03;

//MVC 아키텍쳐 Model에 해당하는 클래스
public class Contact {
	 // field
    private String name;
    private String phone;
    private String email;
    
 // 기본 생성자 (default constructor)
    public Contact() {}
    
    // argument를 갖는 생성자
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // getters / setters
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    @Override
    public String toString() {
    	
    	return String.format("연락처(이름=%s, 연락처=%s, 이메일=%s)", name,phone,email);
    }
    
    
}
