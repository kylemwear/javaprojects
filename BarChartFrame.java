
package barchart;
import javax.swing.*;
import java.awt.*;



public class BarChartFrame extends JFrame{
    
    BarChartPanel bcp;
    public BarChartFrame(String title, int[] values, String[] labels, String[] info) {
        
        bcp = new BarChartPanel(values, labels, info, values.length);
        getContentPane().add(bcp, BorderLayout.CENTER);        
	setSize(800,400);
        this.setTitle(title);
	show();  
        
    }

    
    public static void main(String[] args){
        
        // set up data
        int[] values = {10,20,30};
        String[] labels = {"one","two","three"};
        String[] info = {"one stuff\nhi","two stuff\n\tbye","three stuff\n\thi\n\tbye"};
        
        // instantiate and display
        BarChartFrame bcf = new BarChartFrame("Test title", values,labels, info);
        
        // only do this if you want the application to exit when window is closed
        bcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
