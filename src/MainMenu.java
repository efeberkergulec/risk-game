import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu {
	JButton newGame = new JButton("New Game");
	JButton quit = new JButton("Quit");
	
	static int newGameState = 0;
	
	public JButton getNewGame() {
		return newGame;
	}

	public void setNewGame(JButton newGame) {
		this.newGame = newGame;
	}

	public MainMenu(){
		JFrame men = new JFrame("Risk of Thrones");
		JLabel menu = new JLabel();
		
		men.setIconImage(new ImageIcon("ICON.jpg").getImage());
		men.setSize(new Dimension(960, 600));
		men.getContentPane().add(menu);
		men.setVisible(true);
		men.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setIcon(new ImageIcon("WALLPAPER.jpg"));
		men.getContentPane().add(menu);
		
		newGame.setBounds(405, 350, 150, 50);
		newGame.setBackground(Color.DARK_GRAY);
		newGame.setForeground(Color.WHITE);
		newGame.isVisible();
		men.getContentPane().add(newGame);
		
		
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGameState++;
				if (newGameState % 2 == 0) {
					newGameState = 0;
				}

				if (newGameState == 1) { //	Enters Map screen
					Frame frame = new Frame();
				}

			}
		});
	}	
	
}