/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.io.Serializable;

/**
 *ResourceUsage class save the assign resources
 * @author ChinWeiQing
 * @author ChinWeiQing
 * @version 2.0
 */
public class ResourceUsage implements Serializable {    
        
     /** attributes, refer to class diagram given */
    private int WeekNo;
    private int numUnitsPurchased;
    private Resource resource;
    private Site site; 
    
    
    /**
     * constructor with argument to the class ResourceUsage
     * @param weekNo the weekNo of the resource usage to be set
     * @param numUnitsPurchased the numUnitsPurchased of the resource usage to be set
     * @param resource the resource of the resource usage to be set
     * @param site the site of the resource usage to be set
     */
    public ResourceUsage(int weekNo, int numUnitsPurchased, Resource resource, Site site){
	setWeekNo(weekNo);
        setNumUnitsPurchased(numUnitsPurchased);
	setResource(resource);
	setSite(site);
	}
	
    /**
     * return the resource of the resource usage
     * @return the resource of resource usage 
     */
    public Resource getResource() {
        return resource;
    }
    
    /**
     * set the resource to the resource usage
     * @param resource the resource resource to be set
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
    /**
     * Return the site resource usage
     * @return the site of the resource usage
     */
    public Site getSite() {
        return site;
    }

    /**
     * set the site to the resource usage
     * @param site the site site to be set
     */
    public void setSite(Site site) {
        this.site = site;
    }

    /**
     * return the week number of the resource usage
     * @return the week number of resource usage
     */
    public int getWeekNo() {
        return WeekNo;
    }

    /**
     * set the week number of the resource usage
     * @param weekNo the integer week number to be set
     */
    public void setWeekNo(int weekNo) {
        this.WeekNo = weekNo;
    }

    /**
     * return the number of units of purchase of the resource usage
     * @return number of units purchased of the resource usage
     */
    public int getNumUnitsPurchased() {
        return numUnitsPurchased;
    }
    
    
    /**
     * set the number of unit purchased to the resource usage
     * @param numUnitsPurchased of the resource usage
     */
    public void setNumUnitsPurchased(int numUnitsPurchased) {
        this.numUnitsPurchased = numUnitsPurchased;
    }
  
        @Override
        /**
        * toString() method returns the resource usage detail as a String
        * @return the resource usage information
        */
    public String toString() {
        return "resource +[WeekNo=" + WeekNo + ", numUnitsPurchased="
				+ numUnitsPurchased + "]";
    }
        
}