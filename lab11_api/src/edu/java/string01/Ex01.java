package edu.java.string01;

public class Ex01 {

    public static void main(String[] args) {
        // String 클래스의 메서드들을 사용
        
        // ex-1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
        String ssn = "990111-1234567";
        
        
        //String gender = ssn.substring(7, 8);   7포함 8미포함해서 문자열을 잘라서 저장해준다.
        //System.out.println(gender);
        
        System.out.println(ssn.charAt(7));
        
        System.out.println("---------------------");
        
        // ex-2 아래의 문자열 배열에서 "변주환"의 처음 등장하는 인덱스를 출력.
        // 만약에 "변주환"이 배열에 없는 경우에는 -1을 출력.
        
        String[] names = { "손흥민", "봉준호","Jane", "변주환"};
        
        int index = -1;
        for(int i=0; i<names.length; i++) {
            if(names[i].equals("변주환")) {
                index =i;
                break;  
            }
        }
        System.out.println(index);
        
        
        // ex-3 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력
        
        System.out.println("---------------------");
        
        String[] languages = {"JAVA","SQL","JavaScript","Python"};
        for(int i=0; i<languages.length; i++) {
            int length = languages[i].length();
            if(length>=5) {
                System.out.println(languages[i]);
            }
        }
        
        for(String s : languages) {
            if(s.length()>5) {
                System.out.println(s);
            }
        }
        
        // ex-4 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        
        System.out.println("---------------------");
        
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
        String[] tests2 = new String[tests.length];
        for(int i=0; i<tests.length; i++) {
            tests2[i]=tests[i].toLowerCase();
            
            if(tests2[i].indexOf("est")>=0) {
                System.out.println(tests[i]);
            }   
        }
        
        for(String s : tests) {
            if(s.toLowerCase().contains("est")) {
                System.out.print(s + " , ");
            }
        }
        System.out.println();
        // ex-5 아래의 "YYYY-MM--DD" 형식의 날짜 문자열에서 년/월/일 정보를
        // int 타입 변수에 저장하고 출력.
        
        System.out.println("---------------------");
        
        String date = "2022-09-07";
        
        String year = date.substring(0,4);
        
        String month = date.substring(5,7);
        
        String date1 = date.substring(8, 10);
        
        
        int year1 = Integer.parseInt(year);
        int month1 = Integer.parseInt(month);
        int date2 = Integer.parseInt(date1);
        System.out.println(year1 + "-" + month1 + "-" + date2);
        
        
        String [] array = date.split("-");
        System.out.println(array[0] + "-" + array[1] + "-" + array[2]);
    }

}
