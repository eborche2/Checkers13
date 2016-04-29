package checkers;

import javax.swing.*;
import java.io.*;
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
        InputStream is = null; 
        InputStreamReader isr = null;
        BufferedReader b = null;

        try{
           // open input stream test.txt for reading purpose.
           is = new FileInputStream("HowToPlay.txt");
           // create new input stream reader
           isr = new InputStreamReader(is);
           
           // create new buffered reader
           b = new BufferedReader(isr);
     
           
            try {
                while((str=b.readLine())!=null)
                    txt.append(str+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
