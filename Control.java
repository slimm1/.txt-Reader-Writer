package Interfaces;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;

public class Control extends FileFilter implements ActionListener
{
    private Window2 w;
    private JFileChooser chooser;
    private String output;
    public Control(){
        w = new Window2();
        chooser = new JFileChooser();
        w.loadFile.addActionListener(this);
        w.clear.addActionListener(this);
        w.save.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        chooser.setFileFilter(this);
        if(e.getSource()==w.loadFile){
            chooser.showOpenDialog(w);
            File in = chooser.getSelectedFile();
            if(in!=null){
                if(in.getName().indexOf(".")==-1 || !in.getName().substring(in.getName().indexOf(".")).equalsIgnoreCase(".txt")){
                    JOptionPane.showMessageDialog(w,"FORMATO ERRóNEO, only .txt is SUPPORTED","WRONG FORMAT",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    output="";
                    loadFile(in);
                    w.field.setText(output);
                }
            }
        }
        else if(e.getSource()==w.clear){
            w.field.setText(null);
        }
        else if(e.getSource()==w.save){
            if(w.field.getText().equals(output)){
                JOptionPane.showMessageDialog(w,"You must edit your File if you want to save","EDIT THEN SAVE",JOptionPane.WARNING_MESSAGE);
            }
            else if(w.field.getText().isBlank()){
                JOptionPane.showMessageDialog(w,"El fichero está vacío","EMPTY FILE",JOptionPane.WARNING_MESSAGE);
            }
            else{
                chooser.showSaveDialog(w);
                File out = chooser.getSelectedFile();
                if(out!=null){printFile(out); output=w.field.getText();}
            }
        }
    }
    
    public void loadFile(File f){
        try{
            Scanner in = new Scanner(f);
            while(in.hasNextLine()){
                output += in.nextLine()+"\n";
            }
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(w,"Could not find File!","ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void printFile(File f){
        try{
            FileWriter write = new FileWriter(f+".txt");   
            write.write(w.field.getText());
            write.close();
            JOptionPane.showMessageDialog(w,"File succesfuly saved","OK",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException i){
            JOptionPane.showMessageDialog(w,"Error de salida de datos!","ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean accept(File file){
        if(file.isDirectory() || file.getName().endsWith(".txt")){
            return true;
        }
        return false;
    }
    
    public String getDescription(){
        return ".txt files";
    }
}
