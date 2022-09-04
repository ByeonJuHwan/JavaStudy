package gui.practice;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class ImagePanel extends JPanel{
	private Image img;      // image 를 불러올수있게 함
	
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null),img.getHeight(null)));  // null 값 추가시 최대값으로 가져올수있음.
		setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));  // 이걸 추가를 안해주면 그림이 뜨지않는다 똑같이 입력해준다.
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {    // paintComonent는 자동으로 panel을 열었을때 이미지가 비춰지게해줌 안에는 
		// Graphis가 들어간다.
		g.drawImage(img, 0,0,null);
		
	}
}

public class Lesson8 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640,480);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/mac.jpg").getImage());  // new ImageIcon 안에는 경로가 들어간다.
		
		frame.add(panel);
		frame.pack(); // 패널의 이미지에 맞게 자동처래햐주는것
		

	}

}
