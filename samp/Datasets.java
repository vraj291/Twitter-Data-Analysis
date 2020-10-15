package samp;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYDataset;

import com.orsoncharts.data.xyz.XYZDataset;

import twitter4j.Status;
import twitter4j.User;

public class Datasets {
	   static CategoryDataset createDatasetforTweets(Status[] st) {
		   int i;
		   final String fv = "Favourites"; 
		   final String rt = "Retweeted"; 
		   final DefaultCategoryDataset dataset = 
				      new DefaultCategoryDataset( ); 
		   for(i=0;i<st.length;i++) {  
		      String name1 = st[i].getUser().getName();
		      dataset.addValue( st[i].getRetweetCount() , name1, rt );
		      dataset.addValue( st[i].getFavoriteCount() , name1 , fv ); 
		   }
		      return dataset; 
		   }
	   static CategoryDataset createDatasetforUsers(User[] u) {
		   int i;
		   final String fv = "Following"; 
		   final String rt = "Followers"; 
		   final DefaultCategoryDataset dataset = 
				      new DefaultCategoryDataset( ); 
		   for(i=0;i<u.length;i++) {  
		      String name1 = u[i].getName();
		      dataset.addValue( u[i].getFollowersCount() , name1, rt );
		      dataset.addValue( u[i].getFriendsCount() , name1 , fv ); 
		   }
		   return dataset; 
		   }
	   static CategoryDataset createDatasetforTrends(String trendname[],int vol[]) {             
		      final String tv = "Tweet Volume";                      
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( ); 
		      for(int i=0;i<vol.length;i++) {
		      dataset.addValue(vol[i], trendname[i], tv ); 
		      }      
		      return dataset; 
		   }
	   static XYDataset createDatasetforUsers_bub(User u[]) {
		      DefaultXYDataset dataset = new DefaultXYDataset(); 
		      int i;
			   for(i=0;i<u.length;i++) {  
			      dataset.addSeries(u[i].getName(),new double[][] {{u[i].getFollowersCount()},{u[i].getFriendsCount()}});
			   }             
		      return dataset; 
		   }
	   static XYDataset createDatasetforTweets_bub(Status[] st) {
		   int i; 
		   final DefaultXYDataset dataset = 
				      new DefaultXYDataset(); 
		   for(i=0;i<st.length;i++) {
		      dataset.addSeries( st[i].getUser().getName(),new double[][] {{st[i].getRetweetCount()},{st[i].getFavoriteCount()}});
		   }
		      return dataset; 
		   }
	   static CategoryDataset createDatasetforUserStatus(User[] u) {  
		   final String fv = "Tweets Posted"; 
		   final String rt = "Tweets Favorited";
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( ); 
		      for(int i=0;i<u.length;i++) {
		      dataset.addValue(u[i].getStatusesCount(),u[i].getName(),fv); 
		      dataset.addValue(u[i].getFavouritesCount(),u[i].getName(),rt);
		      }
		      return dataset; 
		      }
	   
	static XYDataset createDatasetforUserStatus_bub(User[] u) {
				   int i; 
				   final DefaultXYDataset dataset = 
						      new DefaultXYDataset();
				   for(i=0;i<u.length;i++) {
				      dataset.addSeries( u[i].getName(),new double[][] {{u[i].getStatusesCount()},{u[i].getFavouritesCount()}});
				   }
				      return dataset; 
				   }
}



