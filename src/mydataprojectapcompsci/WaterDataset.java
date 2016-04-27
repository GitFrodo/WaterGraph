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
public class WaterDataset {
    Legend[] dimension;
    WaterDataPoint[] fact;
    
    public WaterDataset(){
        dimension = null;
        fact = null;
    }
    
    public WaterDataPoint[] getDataSet(){
        return fact;  
    }
}
