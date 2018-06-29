/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtconsole;
import java.util.*;
import java.io.Serializable;

/**
 * DengueFighter class act as a controller for the Dengue Fighter Stimulator
 * maintain a collection of site and collection of resources
 * @author ChinWeiQing
 * @version 2.0
 */
public class DengueFighter implements Serializable {
    
    /** attributes, refer to class diagram given */
    private String playerName;
    private double currentBudget;
    private int currentWeek=0;
    
    private String tempName;
    
     /** A DengueFighter has a collection of Site */
    private ArrayList<Site> dengueFighterSites;
    
     /** A DengueFighter has a collection of Resource */
    private ArrayList<Resource> dengueFighterResources;
 
    
    /**
     * constructor with argument for the DengueFighter class
     * current budget initialize as 0
     * @param playerName the playerName of the pesticide to be set
     */
    public DengueFighter(String playerName)
    {
       setPlayerName(playerName);
       setCurrentBudget(0);
       
        // initialize ArrayList for Site
        dengueFighterSites=new ArrayList<>();
        // initialize ArrayList for Resources
        dengueFighterResources=new ArrayList<>();     
    } 
 
    /**
     * constructor without argument for the DengueFighter class
     * dengueFighter name not set
     * current budget initialize as 0
     */
    public DengueFighter()
    {
       //dengueFighter name to be set later on
       setCurrentBudget(0);       
        // initialize ArrayList for Site
        dengueFighterSites=new ArrayList<>();
        // initialize ArrayList for Resources
        dengueFighterResources=new ArrayList<>();         
    } 
   
    /**
     * method to retrieve array list of resource own by dengue fighter
     * @return arraylist of resource
     */
    public ArrayList<Resource> getDengueFighterResources(){
        return dengueFighterResources;
    }
    
    /**
     * method to retrieve array list of site own by dengue fighter
     * @return arraylist of site
     */
    public ArrayList<Site> getDengueFighterSites(){
        return dengueFighterSites;
    }
    
    /**
    *  method to set the temporary name
    * @param tempName equal to input name
    */
    public void setTempName(String tempName) {
        this.tempName = tempName;
    }
    
    /**
     * method to retrieve the temporary name
     * @return tempName
     */
    public String getTempName(){
        return tempName;
    }

    /**
     * method to retrieve 
     * @param siteID id of site
     * @return Site
     */
    public Site getSite(String siteID){
        for(Site s:dengueFighterSites){
            if (s.getSiteID().equals(siteID))
                return s;
        }return null;
            
    }
    
    /**
     * method to record all resource usage of the current week and return as a string
    * @param week integer of the week to show site resource usage
    * @return allSiteResourceUsage 
    */
    public String showAllSiteResourceUsage(int week)
   {
       if (!Site.getResourceUsage(week).equals("")){
       String allSiteResourceUsage=String.format("%s\n%s\t%s\t%s\t%s\t%s\n","Resource Purchased","SiteID","Resource ID","Resource name","Quantity","Description");
            allSiteResourceUsage+=Site.getResourceUsage(week)+"\n";
       return allSiteResourceUsage;
       }else{
           return"No Resource Assign for the Week";
       }
   }
   
    /**
     * method set the Player's name to the Dengue Fighter
     * @param playerName the player's name of the Dengue Fighter Stimulation to be set
     */ 
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
   
    /**
     * method reset the Dengue Fighter currentBudget to the input amount
     *@param currentBudget the amount of budget to set
     */
       public void setCurrentBudget(double currentBudget) {
        this.currentBudget = currentBudget;
    }

    /**
     * method reset the Dengue Fighter stimulator week to the input week
     * @param currentWeek the integer week to set
     */
     public void setCurrentWeek(int currentWeek) {
        this.currentWeek = currentWeek;
    }
   
    /**
     * method retrieve the player's Dengue Fighter name
     * @return playerName the Dengue Fighter Stimulation player's name
     */ 
    public String getPlayerName() {
        return playerName;
    }
    
    /**
     * method retrieve the Dengue Fighter budget
     * @return currentBudget the Dengue Fighter Stimulation current budget
     */ 
    public double getCurrentBudget() {
        
        return (currentBudget);
    }
    
    /**
     * method retrieve the Dengue Fighter current week
     * @return currentWeek the Dengue Fighter Stimulation current week
     */ 
    public int getCurrentWeek() {
        return currentWeek;
    }
        
    /**
     * method to add site to Dengue Fighter site 
     * @param site the Dengue Fighter Stimulation sites
     */ 
    public void addSite(Site site){
        dengueFighterSites.add(site);
    }
   

    /**
     * method to compare the available site with site to be set
     * @param siteID the siteID to be set
     * @return return the site position if found, else null
     */
    public Site findSite(String siteID)
    {   
        for(int i=0; i<dengueFighterSites.size(); i++)
        {
            if(dengueFighterSites.get(i).getSiteID().equals(siteID))
                return dengueFighterSites.get(i);
        }return null;
    }        
    
    /**
     * method to add the resource to the dengue resource resource ArrayList
     * @param resource the resource to be set
     */
    public void addResource(Resource resource){
        dengueFighterResources.add(resource);
    }
 
    /**
     * method to find the resource in the Dengue Fighter resource ArrayList
     * @param resourceID the resourceID to be set
     * @return the particular resource
     */
    public Resource findResource(String resourceID)
    {   
        for(Resource r: dengueFighterResources)
        {
            if(r.getResourceID().equals(resourceID))
                return r;
        }return null;
    } 
    
    /**
     * check the available resource for the week for the input site
     * @param s Site input to show the site available resource
     * @return unusedResource ArrayList
     */
    public ArrayList<Resource> findAvailableResourceForWeek(Site s)
    {
        //duplicate all resource
        ArrayList<Resource> unusedResource =new ArrayList<Resource>(dengueFighterResources);
        
        //set purchased resource list for the week
        ArrayList purchasedResource = Site.ResourcePurchasedForWeek(currentWeek,s);
        
        unusedResource.removeAll(purchasedResource);
        
        return unusedResource;
    }
    
    /**
     * method to sum Dengue Fighter site revenue to the the budget
     * @param currentBudget the budget to be set.
     * @return the current budget
     */
    public double budgetCalculator(double currentBudget)
    {
        for (Site s: dengueFighterSites)
        {
            currentBudget+=s.getRevenue();   
        }return currentBudget;
    }   
    
    /**
     * updateAllsite() method to update all the Dengue Fighter site with the infection
     */
    public void updateAllsite(){
        for (Site s: dengueFighterSites)
            s.updateInfections();
    }
    
    /**
     * activateResourcePurchase() method to active the resources stored in the resource usage of the current week
     */
    public void activateResourcePurchase(){
        for(Site s: dengueFighterSites)
            s.activateResourceUsage(getCurrentWeek());
    }
      
    /**
     * method to check if the budget is sufficient to purchase the quantity of resource
     * if budget is sufficient,update budget
     * @param quantity the quantity to be set
     * @param resource the resource to be set
     * @return true if budget is sufficient, else return false
     */
    public boolean budgetCheck(int quantity,Resource resource)
    {
        
        double price = quantity * resource.getCost();
        if (currentBudget > (price))
        {
            currentBudget=currentBudget-price;
            return true;
        }return false;              
    }

    /**
     * showSite() method record all dengue fighter site detail and return as a String
     * @return all site information
     */
    public String showSite(){

        String str = String.format("%s\t%s\t%s\t%s\t%s\t%s\n", "SiteID", "Cleanliness","Population","Revenue","Num infections", "has Aedes");
        for (Site s: dengueFighterSites)
        {
            str += String.format("%s\t%s\t%s\t%s\t%s\t%s\n", s.getSiteID(),s.getCleanliness(),s.getPopulation(),Double.toString(s.getRevenue()),s.getNumInfected(),s.hasAedes());
        }
        return str;
    }
    
    /**
     * find the type of resource base on site resource ID
     * @param site retrieve resource ID base on the input site 
     * @return resourceType String of resource type
     */
    public String resourceType(String site){
        String s = site.substring(1, 2);    
        int siteNum = Integer.parseInt(s);
        if (siteNum==1)
            return "Pesticide";
        else if(siteNum==2)
            return "MedicalService";
        else
            return "CleanupTeam";
    }
   
    /**
     * showResource() method record all dengue fighter resource detail and return as a String
     * @return all resource information
     */
    public String showResource()
    {
        String str1 = String.format("%s\t%s\t%s\t%s\n", "ResID", "Resource Name","Cost","Description");
        for (Resource s: dengueFighterResources)
        {
            str1 += String.format("%s\t%s\t$%s\t%s\t\n",s.getResourceID(),s.getResourceName(),s.getCost(), s.getDescription());
        }
        return  str1;
    }
    
    /**
     * method record all dengue fighter resource detail in the order of cost
     * return as a String
     * @return all resource information in order of lowest to highest cost
     */
    public String showResourceByCost()
    {
        ArrayList<Resource> ResourceCopy =new ArrayList<Resource>(dengueFighterResources);
        String str1 = String.format("%s\t%s\t%s\t%s\t%s\n", "ResID","ResType", "Resource Name","Cost","Description");   
        Collections.sort(ResourceCopy,new ResourceCostComparator());
        for (Resource s: ResourceCopy)
        {
            str1 += String.format("%s\t%s\t%s\t$%s\t%s\t\n",s.getResourceID(),resourceType(s.getResourceID()),s.getResourceName(),s.getCost(), s.getDescription());
        }
        return  str1;
    }
    
    /**
     * method record all dengue fighter resource detail in the order of type
     * return as a String
     * @return all resource information in order of lowest to highest resource ID
     */
    public String showResourceByType()
    {
        ArrayList<Resource> ResourceCopy =new ArrayList<Resource>(dengueFighterResources);
        String str1 = String.format("%s\t%s\t%s\t%s\t%s\n", "ResID","ResType", "Resource Name","Cost","Description");   
        Collections.sort(ResourceCopy,new ResourceTypeComparator());
        for (Resource s: ResourceCopy)
        {
            str1 += String.format("%s\t%s\t%s\t$%s\t%s\t\n",s.getResourceID(),resourceType(s.getResourceID()),s.getResourceName(),s.getCost(), s.getDescription());
        }
        return  str1;
    }
    
    @Override
    /**
        * toString() method returns the DengueFighter status as a String
        * @return the player's DengueFighter information
        */
    public String toString() {
        return "DengueFighter{" + "playerName=" + playerName + ", currentBudget=" + currentBudget + '}';
    }

   
    }