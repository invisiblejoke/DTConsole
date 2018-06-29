/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtconsole;

import java.io.Serializable;
import java.util.Comparator;

/**
 * ResourceCostComparator, a class allow resource to be compare base on cost
 * @author ChinWeiQing
 * @version 2.0
 */
public class ResourceCostComparator implements Comparator<Resource> , Serializable{
    
    /**
     * compare resource r1 and r2 by price
     * @param r1 resource 1
     * @param r2 resource 2
     * @return returnValue integer
     */
    @Override
    public int compare(Resource r1, Resource r2){
        int returnValue = 0;

        if(r1.getCost() < r2.getCost()){
            returnValue =  -1;
        }else if(r1.getCost() > r2.getCost()){
            returnValue =  1;
        }else if(r1.getCost() == r2.getCost()){
            returnValue =  0;
        }
        return returnValue;

    }
    
}