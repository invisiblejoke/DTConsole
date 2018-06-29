/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;
import java.io.Serializable;
import java.util.*;
/**
 * Pesticide is subclass of Resource and inherit resource method/constructor
 * @author ChinWeiQing
 * @version 2.0
 */

public class Pesticide extends Resource implements Serializable{
     
    /** attributes, refer to class diagram given */
    private Grade effectiveness;
    private Grade toxicity;

    /** A static variable used to auto-generating siteID */
    private static int nextNo = 100; 
   
    
    
    /** constructor with argument for the pesticide class
     * inherited resourceID, resourceName, cost constructor from superclass Resource. 
     * @param resourceName the resourceName of the pesticide to be set
     * @param cost the cost of the pesticide to be set
     * @param effectiveness the effectiveness of the pesticide to be set
     * @param toxicity the toxicity of the pesticide to be set
     */

    public Pesticide(String resourceName, int cost,Grade effectiveness,Grade toxicity) {
        super(resourceName, cost);
        super.setResourceID("R"+nextNo++);
        setEffectiveness(effectiveness);
        setToxicity(toxicity);
        
    }
    /**
     * Effectiveness is graded by enumerated type
     * @return the current effectiveness grade of the pesticide.
     */
    public Grade getEffectiveness() {
        return effectiveness;
    }

     /**
     * Toxicity is graded by enumerated  type 
     * @return the current toxicity grade of the pesticide.
     */
    public Grade getToxicity() {
        return toxicity;
    }

    /**
     * This method is used to reset the effectiveness value of the pesticide
     * Cleanliness values take on the enum type  {@link Grade}
     * @param effectiveness the effectiveness grade to be set. 
     */
    public void setEffectiveness(Grade effectiveness) {
        this.effectiveness = effectiveness;
    }

    /**
     * This method is used to reset the toxicity value of the pesticide
     * Toxicity values take on the enum type  {@link Grade}
     * @param toxicity the toxicity grade to be set. 
     */
    public void setToxicity(Grade toxicity) {
        this.toxicity = toxicity;
    }

    public String getDescription(){
        return  "effectiveness=" + effectiveness + ", toxicity=" + toxicity;
    }
    @Override
    /**
    * toString() method returns the Pesticide detail as a String
    * @return the Pesticide information
    */
    public String toString() {
        return  super.toString() + "\ttoxicity=" + toxicity + ", effectiveness=" + effectiveness;
    }

    @Override
    
    /**
     * method name inherited from Resource, and does 2 things
     * Random number generator times the effectiveness of pesticide to generate the probability of dengue infection, using {@link Random}
     * recalculate the revenue of the worker based on the the toxicity level    
     * @param site the site to be set.
     */
    public void applyTo(Site site) {
        //retrieve number between 1 to 5 for the current toxicity and effectiveness base on grade
        int toxic = toxicity.getMultiplier();
        int effect = effectiveness.getMultiplier();
        
        //Random number generator to set up aedes infection, using {@link Random}
        Random r =new Random();
        
        //random probability between 0.1 and 1
        double probability = r.nextDouble();
        
        //between 0.1 and 3,where number >0.7 will set the site to aedes free
        if ((probability * effect)>0.7)
            site.setHasAedes(false);
        
        //Reset the revenue of the healthy worker base on toxicity level
        site.setRevenuePerWorker(site.getRevenuePerWorker()-(toxic*0.09));
        
    }

    @Override
    public int compareTo(Resource o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


    }
    
