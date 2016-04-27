/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydataprojectapcompsci;

/**
 *
 * @author Alex
 */
public class WaterDataPoint {
    Info dim;
    int Value;
    
    public int getValue(){
        return Value;
    }
    
    /**
     *
     * @return
     */
    public String getCountry(){
        if(dim.gC() != null){
            return dim.gC();
        } else {
            return "";
        }
    }
}
