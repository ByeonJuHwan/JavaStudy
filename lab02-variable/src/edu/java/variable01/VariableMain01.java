package edu.java.variable01;

public class VariableMain01 {

	public static void main(String[] args) {
		// 변수(variable) : 프로그램에서 필요한 데이터를 저장하는 메모리 공간.
		// 변수 선언 : 변수의 데이터 타입과 변수의 이름을 선언.
		int age;
		
		// 변수 초기화 : 변수에 값을 할당 (저장).
		age = 16; // 변수 age에 값 16을 저장.
		
		System.out.println(age);  // 변수 age가 저장한 값을 추력.
		
		age = 17;
		System.out.println(age);
		
		//변수 선언과 초기화를 한 문장에서 작성.
		int salary = 100;
		System.out.println(salary);
		
		// 자바의 기본 데이터 타입
		// 정수 타입 : byte, short, int ,long, char
		// 실수 타입 : float, double
		// 논리 타입 : boolean
		
	}

}
