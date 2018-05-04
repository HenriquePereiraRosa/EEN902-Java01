/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileapplication;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class FileApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileApplication app = new FileApplication();
        app.executa();
        app.read();
    }

    private void executa() {
        File file = new File("D:\\Meus documentos\\GoogleDrive\\MAUA\\2018\\EEN902 Java I\\Aulas\\Aula05\\FileApplication\\file\\file.txt");
                
        try{
//            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            
            ObjectOutputStream oos = new ObjectOutputStream(
                    new BufferedOutputStream(new FileOutputStream(file)));
            
            Gatinho gato = new Gatinho("Gato", "Siamês", 8);
            oos.writeObject(gato);
            
            oos.close();
            
//            bf.write("Henrique");
//            bf.newLine();
//            bf.write("Rosa");
//            bf.close();
                    
        } catch(IOException ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        } 
    }

    private void read() {
        File file = new File("D:\\Meus documentos\\GoogleDrive\\MAUA\\2018\\EEN902 Java I\\Aulas\\Aula05\\FileApplication\\file\\file.txt");
                
        try{
            ObjectInputStream ois = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(file)));
            
                Gatinho gato = (Gatinho)ois.readObject();
                
                System.out.println(gato);
                ois.close();
                
                
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(FileApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
