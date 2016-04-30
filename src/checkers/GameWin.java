package checkers;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameWin extends JDialog{
    Point p;
    JLabel masseage=new JLabel();
    
    GameWin(String winner,Point p){
    	setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
    	setModal(true);
        this.p=p;
        masseage.setText("          "+winner+" Wins!");
        setupGUI();
	}

	private void setupGUI()
	{
        new PlaySound("/Win.wav").start();
        masseage.setFont(new Font("dialog",Font.BOLD,16));
        add(masseage);

        setAlwaysOnTop(true);
        setLocation((int)p.getX()+100,(int)p.getY()+200);
        setResizable(false);
        setSize(200,80);
        setTitle("Game Over");
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
