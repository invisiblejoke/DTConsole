/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.io.Serializable;

/**
 *
 * @author ChinWeiQing
 * @version 2.0
 */
/** MedicalServices is subclass of Resource and inherit resource method/constructor  */
public class MedicalServices extends Resource implements Serializable {
    
    /** attributes, refer to class diagram given */
    private int patientCapacity;
    private static int nextNo = 200;

/**
 * Constructor with argument for the MedicalServices class
 * inherited resourceID, resourceName, cost constructor from superclass Resource. 
 * @param resourceName the resourceName of the medical service to be set
 * @param cost the cost of the medical service to be set
 * @param patientCapacity the patient capacity of the medical service to set.
 */
    public MedicalServices(String resourceName, int cost, int patientCapacity) {
        super( resourceName, cost);
        super.setResourceID("R"+nextNo++);
        setPatientCapacity(patientCapacity);
        
    }
    
    /**
     * Return the number of patient capacity of the medical service can hold.
     * @return the patient capacity of the medical service.
     */
    public int getPatientCapacity() {
        return patientCapacity;
    }

    /**
     * Set the number of patient capacity of the medical service
     *use it to reduce the number of infected patient.
     * @param patientCapacity the patient capacity integer to be set.
     */
    public void setPatientCapacity(int patientCapacity) {
        this.patientCapacity = patientCapacity;
    }

    public String getDescription(){
        return "MedicalServices{" + "patientCapacity=" + patientCapacity + '}';
    }
    /**
    * toString() method returns the MedicalServices detail as a String
    * @return the MedicalServices information
    */
    @Override
    public String toString() {
        return super.toString() + "\tpatient capacity=" + patientCapacity;
    }



/**
 * method name inherited from Resource
 * Reduce the number of infected patient by increasing the number of medical service
 * @param site the site to be set.
 */
    public void applyTo(Site site) {
        
        //patient counter
        int numOfPatient = (site.getNumInfected() -this.getPatientCapacity());
        
        //if medical center can hold more then the current patient, patient equal to zero.
        if(numOfPatient>0)
        {
            site.setNumInfected (numOfPatient);
        }else{
            site.setNumInfected (0);
       }  
    }

    @Override
    public int compareTo(Resource o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
  
    

    
    
    
        
    
}
