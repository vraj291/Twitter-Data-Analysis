package samp;

import java.awt.Color;
import java.awt.Rectangle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.util.TableOrder;

import twitter4j.Status;
import twitter4j.User;

public class PieChart extends ApplicationFrame {
	   int ver=0;
	   int hor=0;
	   public PieChart(int v,int h){
		   super(null);
		   this.ver=v;
		  this.hor=h;
	   }
	   public PieChart(CategoryDataset cd,String name,String x,String y ) {
	      super( "Twitter Statistics" );        
	      JFreeChart pieChart = ChartFactory.createMultiplePieChart(
	         name,                      
	         cd,   
	         TableOrder.BY_COLUMN,
	         true, true, false);
	         
	      ChartPanel chartPanel = new ChartPanel(pieChart );
	      Rectangle r = new Rectangle(ver, hor,  800 , 500);
	      setBounds(r);       
	      setContentPane( chartPanel ); 
	   }
	   static PieDataset createpieDatasetforUsers(Status id1,Status id2 ) {
	      final String name1 = id1.getUser().getName();        
	      final String name2 = id2.getUser().getName();               
	      final String rt = "Retweets";        
	      final String fv = "Favourated";               
	      final DefaultPieDataset dataset = 
	      new DefaultPieDataset( ); 
	      dataset.setValue(name1,id1.getRetweetCount());        
	      //dataset.setValue(name1,id1.getFavoriteCount() );                
	      dataset.setValue(name2,id2.getRetweetCount());        
	      //dataset.setValue(name2,id2.getFavoriteCount() ); 
	      return dataset; 
	   }
	
}
