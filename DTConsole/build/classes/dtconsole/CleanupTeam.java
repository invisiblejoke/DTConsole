/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.io.Serializable;

/**
 * CleanupTeam is subclass of Resource and inherit resource method/constructor
 * @author ChinWeiQing
 * @version 2.0
 */
public class CleanupTeam extends Resource implements Serializable{
    
    /** attributes, refer to class diagram given */
    private Grade capability;
    private static int nextNo = 300;

    /** constructor with argument to the CleanupTeam class
     * inherited resourceID, resourceName, cost constructor from superclass Resource. 
     * @param resourceName the resourceName of the cleanup team to be set
     * @param cost the cost of the cleanup team to be set
     * @param capability the capability of the cleanup team to be set
     * 
     */
    public CleanupTeam( String resourceName, int cost, Grade capability) {
        super( resourceName, cost);
        super.setResourceID("R"+nextNo++);
        setCapability(capability);
    }
    
     /**
     * Capability is graded by number type {@link Grade}
     * @return the current capacity grade of the cleanup team.
     */
    public Grade getCapability() {
        return capability;
    }

    /**
     * This method is used to reset the capability value of the CleanupTeam
     * Capability values take on the number type  {@link Grade}
     * @param capability the capability grade to be set. 
     */
    public void setCapability(Grade capability) {
        this.capability = capability;
    }

    @Override
    /**
        * toString() method returns the CleanupTeam detail as a String
        * @return the cleanup team information
        */
    public String getDescription(){
        return "CleanupTeam{" + "capability=" + capability + '}';
    }
    
    public String toString() {
         return super.toString() + ", capability=" + capability;
    }

   /**
     * method name inherited from Resource
     * Increase the site's cleanliness value by CleanupTeam capability
     * CleanupTeam capability to reduced to 70%
     * @param site the site to be set.
     */
    public void applyTo(Site site) {
        
        // retireve cleanupTeam capability between 1 or 3
        int multiply = (this.getCapability().getMultiplier());
        
        //reduce CleanupTeam capability to 70%
        int increaseCount=(int) (multiply*0.7);      
        
        //increase cleanliness of site by each value of increaseCount
        for(int i=0; i<increaseCount;i++)
            site.setCleanliness(Grade.nextGrade(site.getCleanliness()));
    }

    @Override
    public int compareTo(Resource o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
