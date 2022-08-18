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
		// 정수 타입 : byte, short, int, long, char
		// 실수 타입 : float, double
		// 논리 타입 : boolean
		
		// 변수 이름을 만드는 관습/문법 :
		// 1. 변수이름은 알파벳과 숫자 , _ 를 사용할 수 있음.
		// 2. 변수이름은 숫자로 시작할 수 없음
		// 3. 변수 이름은 소문자로 시작하는 것이 좋음.
		// 4. 변수 이름이 2개 이상의 단어로 이루어질 때는 camel 표기법을 사용하는 것을 권장. ex) int phoneNumber
		// 5. 같은 이름으로 변수를 2번 이상 선언할 수 없음.
		
		// 정수 2개의 사칙연산 결과를 출력
		int x = 123;
		int y = 10;
		int result;
		
		result = x + y;
		System.out.println(result);
		
		result = x - y;
		System.out.println(result);
		
		result = x * y;
		System.out.println(result);
		
		result = x / y;  // (정수) / (정수) 를 나누면 나눈 몫만 결고 값으로 출력 
		System.out.println(result);	
		
		result = x % y; 
		System.out.println(result);
		
		// 나누기 연산자(/)가 실수엣 사용되면 실수 계산을 사용
		double z = 123.0;
		double div = z / y;
		System.out.println(div);
				
	}

}
