/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.io.Serializable;

/**
 * Resource class is a abstract class that should be allocated to each site
 * @author ChinWeiQing
 * @version 2.0
 */
public abstract class Resource implements Comparable<Resource> ,Serializable{
    
     /** attributes, refer to class diagram given */
    private String resourceID;
    private String resourceName;
    private int cost;
    private static int nextNo = 000;
    
    /**
     * constructor with argument for the resource class
     * @param resourceName the resourceName of the resource to be set
     * @param cost the cost of the resource to be set
     */
    public Resource(String resourceName,int cost){
        setResourceID("R"+nextNo++);
        setResourceName(resourceName);
        setCost(cost);
    }
     
    /**
     * method retrieve the resourceID of the resource
     * @return resourceID of the Resource 
     */ 
    public String getResourceID() {
        return resourceID;
    }

    /**
     * method retrieve the resource name of the resource
     * @return resource name of the resource 
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * method retrieve the resource cost of the resource
     * @return cost of the resource
     */
    public int getCost() {
        return cost;
    }

    /**
     * method set the resourceID to the resource
     * @param resourceID the resource id to set
     */
    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }
    /**
     * method set the resource name to the resource
     * @param resourceName the resource name to set
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    
    /**
     * method set the cost to the resource
     * @param cost the resource cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    /**
     * retrieve description of the resource
     * @return null
     */
    public String getDescription(){
        return null;
    }
            
    @Override
    /**
     * toString() method returns the Resource detail as a String
     * @return the resource's information
     */
    public String toString() {
        return "Resources{" + resourceID + resourceName + "/t" + cost +'}';
    }
    
    /**
     * applyTo() method allow all resource's subclass to inherit the method name
     * subclass method function may vary for each other 
     * @param site the site to set.
     */
    public abstract void applyTo(Site site);
    
    
    /**
     * hash code
     * @return hashcode
     */
     @Override
    public int hashCode() {
        return this.getResourceName().hashCode();
    }

    /**
     * compare the object
     * @param obj object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
       
        if (this == obj)
            return true;
        
        if (!(obj instanceof Resource))
            return false;
        
        Resource r = (Resource) obj;  // downcast
        if ( this.getResourceName().equals(r.getResourceName()))
            return true;
         return false;
     }
    
}
