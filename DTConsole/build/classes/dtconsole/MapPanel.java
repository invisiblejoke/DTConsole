/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * a panel for the map dialog, consist of the site information
 * @author ChinWeiQing
 * @version 2.0
 */
public class MapPanel extends JPanel implements Serializable{

    private ArrayList<Site> sList;

    /**
     * input the site array list and set it to sList
     * @param s the arraylist
     */
    public MapPanel(ArrayList<Site> s){
        sList = s;        
    }
     
     /**
      * retrieve siteID by checking the if the input x and y is within site area
      * @param x double x position
      * @param y double y position
      * @return siteID
      */
    public String getSiteNo(double x, double y){
        for(Site s:sList){
            double xDist = x - s.getX();
            double yDist = y - s.getY();
            if(xDist>=0 && xDist <=60 && yDist>=0&& yDist<=60)
                return s.getSiteID();
            }
        return null;    
    } 
    
    /**
     * color the site area base on the current cleanliness
     * add red circle overlay if aides exist, else black circle overlay
     * @param area graphic area
     */
    public void paintComponent(Graphics area){
        super.paintComponent(area);
        
        //extend graphic in 2dimesinal shape. Allow color mangement control over geometry, coordinate transformations, textlayout
        Graphics2D area2D = (Graphics2D) area;
        
         // draw transparent background
         area2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
         
         // turn on opacity
         area2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
         
         //for each site, draw filled circle with black outer circle line
        for (Site s:sList)
        {
             double x = s.getX() ;
             double y = s.getY(); 
             

             int X = (int)x;
             int Y =(int)y;                     
             
             
             //set color base on the grade
            if(s.getCleanliness()==Grade.V_HIGH)
            {
                area2D.setColor(Color.GREEN);
            }
            else if (s.getCleanliness()==Grade.HIGH)
            {
                area2D.setColor(Color.CYAN);
            }
            else if (s.getCleanliness()==Grade.MEDIUM)
            {
                area2D.setColor(Color.ORANGE);
            }
            else if (s.getCleanliness()==Grade.LOW)
            {
                area2D.setColor(Color.RED);
             }else 
            {
                area2D.setColor(Color.MAGENTA);    
            }
            
            //draw and stack multiple filloval to darken the color 
            for(int i=0; i<10; i++) {
            area2D.fillOval(X, Y, 60, 60);  
            }
            
            //draw a black line circle outside the filled circle
            if(s.hasAedes()==true)
                area.setColor(Color.RED);
            else
                area2D.setColor(Color.BLACK);
             
            area2D.setStroke(new BasicStroke(4));
            area2D.drawOval(X, Y, 60, 60);

        }
    } 
}
