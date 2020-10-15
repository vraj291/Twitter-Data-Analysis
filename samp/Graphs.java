package samp;
import java.awt.Rectangle;
import java.text.NumberFormat;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

import twitter4j.*;

public class Graphs extends ApplicationFrame {
   public Graphs(){
	   super(null);
   }
   JFreeChart graph;
   public Graphs(int i,Status st[]) {
      super( "Twitter Statistics" );
      switch(i){
    	  case 0:
             graph = ChartFactory.createBarChart3D(
             "Selected Tweets",           
            "Users",            
             "Number of retweets and favorited",            
             Datasets.createDatasetforTweets(st),          
             PlotOrientation.VERTICAL,           
             true, true, false);
          break;
    	  case 1:
    		  graph = ChartFactory.createMultiplePieChart(
    				  "Selected Tweets",                      
    			         Datasets.createDatasetforTweets(st),   
    			         TableOrder.BY_COLUMN,
    			         true, true, false);
    	 break;
    	  case 2:
    		 graph = ChartFactory.createScatterPlot(
    				 "Selected Tweets",           
    		            "Number of retweets",            
    		            "Number of favorited",
                      Datasets.createDatasetforTweets_bub(st),
                      PlotOrientation.VERTICAL,
                      true,true,false);
    		 long xval=0,yval=0,temp1,temp2;
    		 for(int j=0;j<st.length;j++) {
    			 temp1=st[j].getRetweetCount();
    			 temp2=st[j].getFavoriteCount();
    			if(temp1>xval)
    				xval=temp1;
    			if(temp2>yval)
    			    yval=temp2;
    		 }
    		 XYPlot plt=(XYPlot) graph.getPlot();
    		 NumberAxis dom=(NumberAxis) plt.getDomainAxis();
    		 dom.setRange(0,xval*1.3);
    		 NumberAxis ran=(NumberAxis) plt.getRangeAxis();
    		 ran.setRange(0,yval*1.3);
         break;		 
    	  case 3: 
    		   graph = ChartFactory.createLineChart3D(
    		             "Selected Tweets",           
    		            "Users",            
    		             "Number of retweets and favorited",            
    		             Datasets.createDatasetforTweets(st),          
    		             PlotOrientation.VERTICAL,           
    		             true, true, false); 
    		   break;
    	 default:
    		 System.out.println("Wrong Input");
      }
         
      ChartPanel chartPanel = new ChartPanel( graph ); 
      Rectangle r = new Rectangle(550,250,  570 , 360);
      setBounds(r); 
      setContentPane( chartPanel ); 
   }
   public Graphs(int cho,int i,User u[]) {
	      super( "Twitter Statistics" );
	    switch(cho) {
	    case 0:
	      switch(i){
	    	  case 0:
	             graph = ChartFactory.createBarChart3D(
	            		 "Outreach on Twitter","Users","Number of Friends and Followers",            
	             Datasets.createDatasetforUsers(u),          
	             PlotOrientation.VERTICAL,           
	             true, true, false);
	          break;
	    	  case 1:
	    		  graph = ChartFactory.createMultiplePieChart(
	    				  "Outreach on Twitter",                      
	    			         Datasets.createDatasetforUsers(u),   
	    			         TableOrder.BY_COLUMN,
	    			         true, true, false);
	    	 break;
	    	  case 2:
	    		 graph = ChartFactory.createScatterPlot("Outreach on Twitter",
	    				 "Number of Followers",
	                      "Number of Friends",
	                      Datasets.createDatasetforUsers_bub(u),
	                      PlotOrientation.VERTICAL,
	                      true,true,false);
	    		 long xval=0,yval=0,temp1,temp2;
	    		 for(int j=0;j<u.length;j++) {
	    			 temp1=u[j].getFollowersCount();
	    			 temp2=u[j].getFriendsCount();
	    			if(temp1>xval)
	    				xval=temp1;
	    			if(temp2>yval)
	    			    yval=temp2;
	    		 }
	    		 XYPlot plt=(XYPlot) graph.getPlot();
	    		 NumberAxis dom=(NumberAxis) plt.getDomainAxis();
	    		 dom.setRange(0,xval*1.3);
	    		 NumberAxis ran=(NumberAxis) plt.getRangeAxis();
	    		 ran.setRange(0,yval*1.3);
	         break;		
	    	  case 3:
		             graph = ChartFactory.createLineChart3D(
		            		 "Outreach on Twitter","Users","Number of Friends and Followers",            
		             Datasets.createDatasetforUsers(u),          
		             PlotOrientation.VERTICAL,           
		             true, true, false);
		          break;
	    	 default:
	    		 System.out.println("Wrong Input");
	      }
	      break;
	    case 1:
	    	switch(i){
	    	  case 0:
	             graph = ChartFactory.createBarChart3D(
	            		 "Outreach on Twitter","Users","Number of Tweets posted and favourited",            
	             Datasets.createDatasetforUserStatus(u),          
	             PlotOrientation.VERTICAL,           
	             true, true, false);
	          break;
	    	  case 1:
	    		  graph = ChartFactory.createMultiplePieChart(
	    				  "Outreach on Twitter",                    
	    			         Datasets.createDatasetforUserStatus(u),   
	    			         TableOrder.BY_COLUMN,
	    			         true, true, false);
	    	 break;
	    	  case 2:
	    		 graph = ChartFactory.createScatterPlot(
	    				 "Outreach on Twitter","Number of Tweets posted","Number of Tweets favourited",
	                      Datasets.createDatasetforUserStatus_bub(u),
	                      PlotOrientation.VERTICAL,
	                      true,true,false);
	    		 long xval=0,yval=0,temp1,temp2;
	    		 for(int j=0;j<u.length;j++) {
	    			 temp1=u[j].getStatusesCount();
	    			 temp2=u[j].getFavouritesCount();
	    			if(temp1>xval)
	    				xval=temp1;
	    			if(temp2>yval)
	    			    yval=temp2;
	    		 }
	    		 XYPlot plt=(XYPlot) graph.getPlot();
	    		 NumberAxis dom=(NumberAxis) plt.getDomainAxis();
	    		 dom.setRange(0,xval*1.3);
	    		 NumberAxis ran=(NumberAxis) plt.getRangeAxis();
	    		 ran.setRange(0,yval*1.3);
	    		 
	         break;		
	    	  case 3:
		             graph = ChartFactory.createLineChart(
		            		 "Outreach on Twitter","Users","Number of Tweets posted and favourited",            
		             Datasets.createDatasetforUserStatus(u),          
		             PlotOrientation.VERTICAL,           
		             true, true, false);
		          break;
	    	 default:
	    		 System.out.println("Wrong Input");
	      }
	      break;
	    }
	      ChartPanel chartPanel = new ChartPanel( graph ); 
	      Rectangle r = new Rectangle(550,250,  570 , 360);
	      setBounds(r); 
	      setContentPane( chartPanel ); 
	   }
   public Graphs(int i,String[] tr,int[] vol) {
	      super( "Twitter Statistics" );
	      switch(i){
    	  case 0:
             graph = ChartFactory.createBarChart3D(
             "Selected Trends",           
            "Hastags",            
             "Tweet Volume",            
             Datasets.createDatasetforTrends(tr,vol),          
             PlotOrientation.VERTICAL,           
             true, true, false);
          break;
    	  case 1:
    		  graph = ChartFactory.createMultiplePieChart(
    				  "Selected Trends",                      
    			         Datasets.createDatasetforTrends(tr,vol),   
    			         TableOrder.BY_COLUMN,
    			         true, true, false);
    	 break;
	      }
      ChartPanel chartPanel = new ChartPanel( graph ); 
      Rectangle r = new Rectangle(550,250,  570 , 360);
      setBounds(r); 
      setContentPane( chartPanel ); 
   }
}
