package checkers;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Help extends JDialog {
    JScrollPane hlp=new JScrollPane();
    JTextArea txt=new JTextArea();

    Help(){
        setupGUI();
    }

    private void setupGUI() {
        hlp.setViewportView(txt);
        txt.setEditable(false);
        txt.setLineWrap(true);
        txt.setWrapStyleWord(true);
        txt.setFont(new Font("Dialog",Font.PLAIN,14));
        hlp.getHorizontalScrollBar().setEnabled(false);
        addText();        
        add(hlp);


        setLocation((int)getToolkit().getScreenSize().getWidth()/2-250,(int)getToolkit().getScreenSize().getHeight()/2-300);
        setVisible(false);
        add(hlp);
        setSize(500,600);
        setResizable(false);
        setTitle("How To Play");
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    }

    private void addText() {
        String str;
        //InputStream is = null; 
        //InputStreamReader isr = null;
        BufferedReader b = null;

        
           // open input stream test.txt for reading purpose.
           //is = new FileInputStream(getClass().getResource("/HowToPlay.txt"));
           // create new input stream reader
        	URL url = getClass().getResource("/HowToPlay.txt");
           try {
			b = new BufferedReader( new InputStreamReader(url.openStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
           
           // create new buffered reader
          
     
           
            try {
                while((str=b.readLine())!=null)
                    txt.append(str+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
       
    }
}
