package dtconsole;

import java.io.Serializable;
import java.util.Random;
/**
 * Grade is an enumerated type (enum) that takes on values V_LOW (Very Low), LOW, MEDIUM, 
 * HIGH and V_HIGH (Very High).Each of the grades has a multiplier from 1 to 5 respectively.
 * 
 * @author ngsm
 * @see <a href = "https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html">Enumerated Types</a>
 */
public enum Grade implements Serializable {
    V_LOW (1),
    LOW (2), 
    MEDIUM (3), 
    HIGH (4),
    V_HIGH (5);
    
    private int multiplier;
    
    /** 
     * Initializes all the grades and their respective multipliers.
     * @param multiplier 
     */
    Grade(int multiplier)
    {
        this.multiplier = multiplier;
    }
    
    /**
     * A method that returns the multiplier value, this can be used for calculations.A 
     * Grade of V_LOW returns 1, and V_HIGH returns 5.Other values are in between.
     * @return an integer representing a multiplier value from 1 to 5
     */
    public int getMultiplier()
    {
        return multiplier;
    }
    
    /** 
     * A method to generate a random grade from V_LOW to V_HIGH
     * @return a random grade value
     */
    public static Grade getRandomGrade(){
        Random rGen = new Random();
        int val = rGen.nextInt(5);
        switch(val)
        {
            case 0: return V_LOW; 
            case 1: return LOW; 
            case 2: return MEDIUM; 
            case 3: return HIGH; 
            case 4: return V_HIGH;
        }
        return null;
    }
    
    /**
     * A method that returns one grade higher than the grade entered.Repeat 
     * to get the next two grades higher, etc.If the current grade is V_HIGH then
     * there is no change.
     * @param currentGrade current grade of the grade
     * @return a grade that is one grade higher.
     */
    public static Grade nextGrade(Grade currentGrade)
    {
        switch(currentGrade)
        {
            case V_LOW: return LOW;
            case LOW: return MEDIUM;
            case MEDIUM: return HIGH;
            case HIGH: case V_HIGH: return V_HIGH;
            
        }
        return V_HIGH;
    }
}
