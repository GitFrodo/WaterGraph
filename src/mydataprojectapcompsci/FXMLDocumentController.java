/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydataprojectapcompsci;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author Alex
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private BarChart<String,Number> chart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL earl = null;
        try {
            earl = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(earl.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson gson;
        gson = new Gson();
        WaterDataset pds = gson.fromJson(str, WaterDataset.class);
        WaterDataPoint[] pdp = pds.getDataSet();
        
        XYChart.Series<String, Number> waterChart = new XYChart.Series();

        //adding to the maps
        for (WaterDataPoint dp : pdp) {
            waterChart.getData().add(new XYChart.Data(dp.getCountry(), dp.getValue()));
        }
        chart.getData().add(waterChart);
    }
}
