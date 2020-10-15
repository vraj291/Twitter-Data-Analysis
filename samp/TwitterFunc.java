package samp;

import java.util.*;

import org.apache.log4j.BasicConfigurator;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterFunc {
	Twitter twitter;
	Trends trends;
	TwitterFunc(Twitter twitter){
		this.twitter=twitter;
	}
	List<Status> tweets;
	User user;
	public String getUserId(String search) {
		try {
			user=twitter.showUser(search);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return user.getName();
	}
	public long getUserFollowers() {
		return user.getFollowersCount();
	}
	public long getUserFollowing() {
		return user.getFriendsCount();
	}
    public String[][] searchUser(String search,int n) {
    	Paging page=new Paging(1,n);
    	int c=0;
    	try {
			tweets=twitter.getUserTimeline(search,page);
			if(tweets.size() < n)
				n=tweets.size();
			return store(tweets.subList(0, n)); 
		} catch (TwitterException e) {
			e.printStackTrace();
		}
    	return null;
    }
    public String[] convertString(String arr[][],int n) {
    	String args[]=new String[n];
    	for (int i=0;i<n;i++) {
           args[i]="LOCATION :"+arr[i][3]+"     LANGUAGE : "+arr[i][8]+"   TEXT : "+arr[i][2];
    	}
              	return args;
    }
    public void searchLocation(String search) {
    	
    }
    public void print(String arr[][]) {
    	int i=0,j=0;
    	 for (i=0;i<15;i++) {
             System.out.println("===========================================================================================================");
             System.out.println("["+(i+1)+"] \n");
             System.out.println("NAME : "+arr[i][0]);
             System.out.println("TEXT : \n\n"+arr[i][1]);
             System.out.println("\nLOCATION : "+arr[i][2]);
             System.out.println("TIME : "+arr[i][3]);
             System.out.println("===========================================================================================================");
    	 }
    }
    public String[][] store(List<Status> tweets){
    	String names[][]= new String[tweets.size()][9];
    	int i=0;
    	for (Status tweet:tweets){
    		names[i][0]=String.valueOf(tweet.getId());
			names[i][1]=tweet.getUser().getName();
            if(tweet.isRetweet())
            	names[i][2]=tweet.getRetweetedStatus().getText();
            else
            	names[i][2]=tweet.getText();	
            if(tweet.getUser().getLocation().isEmpty())
            	names[i][3]="Not Provided";
            else
                names[i][3]=tweet.getUser().getLocation();
            names[i][4]=tweet.getCreatedAt().toString();
            names[i][5]=String.valueOf(tweet.isRetweet());
            names[i][6]=String.valueOf(tweet.getFavoriteCount());
            names[i][7]=String.valueOf(tweet.getRetweetCount());
            names[i][8]=tweet.getLang();
            i++;
        }
    	return names;
    }
    public String[][] searchPhrase(String search,int n) 
    {      
      try {
	        Query query = new Query(search);
            query.setCount(n-1);
	        QueryResult result;
	             result = twitter.search(query);
	            tweets = result.getTweets();
	            return store(tweets); 
	    } catch (TwitterException te) {
	        te.printStackTrace();
	        System.out.println("Failed to search tweets: " + te.getMessage());
	    }
    	return null;
      }
   public Trends getTrends() {
	try {
		trends = twitter.getPlaceTrends(1);
		return trends;
	} catch (TwitterException e) {
		e.printStackTrace();
	}
        return null;
   }
   public String[] getTrendsNames() {
	   String str[]=new String[50];
	   String temp;
	   int count = 0;
       for (Trend trend : trends.getTrends()) {
               temp=trend.getName();
               if((int)temp.charAt(1)<256&&(int)temp.charAt(1)>=0) {	   
               str[count]=temp;	
               count++;
               }
           }
           return str;
   }
   public int[] getTrendsVolume() {
	   int vol[]=new int[50];
	   String temp;
	   int count=0;
       for (Trend trend : trends.getTrends()) {
               temp=trend.getName();
               if((int)temp.charAt(1)<256&&(int)temp.charAt(1)>=0) {
               vol[count]=trend.getTweetVolume();
               count++;
               }
           }
           return vol;
   }
   }