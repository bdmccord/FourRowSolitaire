package test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import FourRowSolitaire.WinScreen;

public class WinScreenTest extends JFrame{
	public static void main(String[] args){
		WinScreenTest winScreenTest = new WinScreenTest();
	}
	
	WinScreenTest(){
        setTitle("Four Row Solitaire");
        setSize(800,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/images/logo.png")).getImage());

        setVisible(true);
		WinScreen winScreen = new WinScreen(1, 1);
	}
}
