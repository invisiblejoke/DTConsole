/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;
import java.io.*;
import javax.swing.*;

/**
 * A class to handle saving and loading of objects from files
 * You will have to downcast the object that is returned
 * @author ngsm
 */
public class FileHandling {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /**
     * A method that returns an object from a file
     * @param parent DTGUI
     * @return theObject
     */
    public static Object readFromFile(javax.swing.JFrame parent)		// from Lecture 7
    {
        // get the file using the private method below
        File file = openFileChooser(parent);
            Object theObject = null;
            FileInputStream fis= null;
            try {
                    fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    theObject = ois.readObject();
                    ois.close();
            }
            catch(Exception e) {
            System.out.println(e.getMessage());
            }
            finally {
                    if (fis!=null)
                            try {
                                    fis.close();
                            } catch (IOException e) {
                                    System.out.println(e.getMessage());
                            }
                    return theObject;
            }

       }

    /**
     * A method to select a file using filechooser
     * @param parent the JFrame that is the parent class of this dialog
     * @return 
     */
    private static File openFileChooser(javax.swing.JFrame parent)
    {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(parent);
         if (returnVal == JFileChooser.APPROVE_OPTION) 
             {
                    File file = fc.getSelectedFile();
                    return file;
                    }
         return null;
    }

    /** 
     * A method to save an Object into a File
     * @param parent the JFrame that is the parent
     * @param theObject to be saved 
     */
    public static void saveToFile(javax.swing.JFrame parent, Object theObject)
    {
        JFileChooser fc = new JFileChooser();
        File file=null;
            int returnVal = fc.showSaveDialog(parent);
           if (returnVal == JFileChooser.APPROVE_OPTION) 
            {
                    file = fc.getSelectedFile();
                    saveObject(file, theObject);
                    System.out.println("Saving: " + file.getName());
            } 
            else 
            {
             System.out.println("Save command cancelled by user.");
            }
    }

    /**
     * A method to save the object into the selected file
     * @param file
     * @param theObject 
     */
    private static void saveObject(File file, Object theObject)
    {
            FileOutputStream fos=null;
            try 	{
                    fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(theObject);
                    oos.flush();
                    oos.close();
            }
            catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
            }
            finally {
                    if (fos!=null) 
                            try {
                                    fos.close();
                            }
                    catch (IOException ioe) {
                            System.out.println(ioe.getMessage());
                    }
            }

    }

}

