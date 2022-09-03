package gui.practice;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Lesson07 {
	 public static void main(String[] args) {
		 JFrame frame = new JFrame("Table Prac.");
		 JPanel panel = new JPanel();
		 String [] headings = new String [] {"id","name","Contry"};
		 Object[] [] data = new Object[] [] {
			 {"1","byeon","kr"},
			 {"2","chan","fr"},
			 {"3","pee","jp"}
		 };
		 
		 // 테이블을 만들때 JTable 이고 2개의 파라미터를 가진다 왼쪽이 
		 // 안에 들어가는 데이터들이고
		 // 오른쪽이 위에 써지는 목차들이다.
		 JTable table = new JTable(data,headings);
		 
		 // 여기까지 와서 크기를 설정하기 위해서는 3가지 단계가 필요하다.
		 // 1. setPreferredScrollableViewportSize(new Dimension(가로 값, 세로 값));
		 // 2. .setFillsViewportHeight(true); // true로 설정해주기
		 // 3. panel.add(new JScrollPane(table)); 패널에 add 할때 스크롤이 가능하게 해주기
		 
		 // new Dimension 을 설정해주지 않으면 에러가 발생한다.
		 table.setPreferredScrollableViewportSize(new Dimension(700,500));
		 
		 // 
		 table.setFillsViewportHeight(true);
		 
		 panel.add(new JScrollPane(table));
		 
		 frame.add(panel);
		 
		 
		 
		 // 기본 설정
		 frame.setVisible(true);
		 frame.setSize(800,640);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocationRelativeTo(null);
	 }
}
