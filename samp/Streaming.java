package samp;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.log4j.BasicConfigurator;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Streaming {
    static boolean isrun=true;
	static void Streamtweets(String a) throws Exception {
		BasicConfigurator.configure();
	      ConfigurationBuilder cf=new ConfigurationBuilder();
	      cf.setDebugEnabled(true)
	      .setOAuthConsumerKey("JpFhshm6hYhAExEuIsLV4Eos4")
	      .setOAuthConsumerSecret("FtI07OwxUrmTe1tEvTk3QOf3JexlAPyxLVCMSDjmAHzaBV3KoZ")
	      .setOAuthAccessToken("1283736553781473282-VnwzDLc5AslKUnWJIzLmzuiYjrCBXH")
	      .setOAuthAccessTokenSecret("0fwMewyQ1gm2JYQFL2DILMOURS4JJPbNN70TxDAPMwNvN");  
		StatusListener listener = new StatusListener(){ 
			StreamingData sd=new StreamingData();
	        public void onStatus(Status status){
	            sd.add(new String[] {String.valueOf(status.getId()),status.getUser().getName(),status.getText(),
	            		status.getUser().getLocation(),status.getCreatedAt().toString(),String.valueOf(status.isRetweet()),status.getLang()});
	            try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            while(sd.ispause) {
	            	try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	            }
	            System.out.println(isrun);
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			public void onScrubGeo(long userId, long uptoStatusId) {}
			public void onStallWarning(StallWarning warning) {}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory(cf.build()).getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.sample();
		twitterStream.filter(a);
	}
}
