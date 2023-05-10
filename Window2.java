package Interfaces;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window2 extends JFrame
{
    public JPanel leftP, rightP;
    public JButton loadFile, save, clear;
    public JTextArea field;
    public JLabel title, space;
    public JScrollPane bar;
    public Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public Window2(){
        super("File Loader");
        setSize(new Dimension((int)screen.width/2, (int)screen.height/2));
        setLayout(new FlowLayout(FlowLayout.LEADING));
        initComponents();
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initComponents(){
        leftPanel();
        rightPanel();       
    }
    
    public void leftPanel(){
        leftP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        leftP.setPreferredSize(new Dimension((int)(screen.width/3), (int)(screen.height/2.2)));
        
        title = new JLabel("*** BRAND NEW Java text editor by MRAMONDA ***");
    
        field = new JTextArea(27,55);
        bar = new JScrollPane(field);
        
        leftP.add(title);
        leftP.add(bar);
        this.add(leftP);        
    }
    
    public void rightPanel(){
        rightP = new JPanel(new FlowLayout(FlowLayout.CENTER,10,11));
        rightP.setPreferredSize(new Dimension((int)(screen.width/6.6), (int)(screen.height/2.2)));
        
        space = new JLabel("                      ");
        loadFile = new JButton("LOAD NEW FILE");      
        loadFile.setBackground(Color.ORANGE);
        loadFile.setPreferredSize(new Dimension((int)(screen.width/8), (int)(screen.height/8)));
        
        save = new JButton("SAVE COPY OF THIS DOC");
        save.setBackground(Color.ORANGE);
        save.setPreferredSize(new Dimension((int)(screen.width/8), (int)(screen.height/8)));
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.ORANGE);
        clear.setPreferredSize(new Dimension((int)(screen.width/8), (int)(screen.height/8)));
        
        rightP.add(space);
        rightP.add(loadFile);
        rightP.add(save);
        rightP.add(clear);
        this.add(rightP);
    }
}
