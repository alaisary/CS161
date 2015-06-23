import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// Khalid Alharthi

public class P1 {

	public static void main(String[] args) {
		P1 p1 = new P1();
//		p1.readTweets(args[0]);
//		System.out.println(Arrays.toString(p1.readTweets(args[0])));
//		System.out.println(Arrays.toString(p1.readStopWords(args[1])));
//		p1.mostCommonWord(p1.readTweets(args[0]));
		System.out.println((p1.mostCommonWord(p1.readTweets(args[0]))));
		System.out.println(p1.mostCommonWordExcludingStopWords(p1.readTweets(args[0]), p1.readStopWords(args[1])));
		
	}
	
	public String[] tweets;
	public String[] stopWords;
	
	public String [] readTweets(String fileName){
		try {
			

			Scanner lineScanner = new Scanner(new File( fileName));
			int count = 0;
			while(lineScanner.hasNextLine()) //to count tweets number
			{
				String line = lineScanner.nextLine();
				count++;		
			}
			lineScanner.close();	
				tweets= new String[count];
				Scanner lineScanner2 = new Scanner(new File(fileName));
				int dd =1;
		while(lineScanner2.hasNextLine()) // allocates tweets to an array
		{
			
			String line2 = lineScanner2.nextLine();
			StringTokenizer st2 = new StringTokenizer(line2,"\t");
		        	
				        st2.nextToken();
				         st2.nextToken();
		        	tweets[dd-1]= st2.nextToken();
		        	dd++;
		}	
		lineScanner2.close();
				return tweets;
		
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tweets;
		
		
		
		
	    
		
	}
	
	public String [] readStopWords(String fileName){
		try {
			Scanner in = new Scanner(new File(fileName));
			int num =0;
			while(in.hasNext())
			{
				String word = in.next();
				in.nextLine();
				num++;
			}
			stopWords = new String[num];
			Scanner in2= new Scanner(new File(fileName));
			int y = 0;
			while(in2.hasNext())
			{
				String word2 = in2.next();
				stopWords[y] = word2;
				in2.nextLine();
				y++;
			}
				return stopWords;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return stopWords;
	}
	//String.trim() : removes extra spaces
	public String mostCommonWord(String[] tweets) {
        int big = -100000;
        String mostCommon = null;
        for (String tweet : tweets) {// = for(int i = 0 ; i<tweets.length;i++) { String tweet = tweets[i] }
                for (String word : tweet.split(" ")) {
                        int amt = 0;
                        for (String tweet2 : tweets)
                                for (String word2 : tweet2.split(" "))
                                        if (word2.equals(word))
                                                amt++;
                        if (amt > big) {
                                big = amt;
                                mostCommon = word;
                        }
                }
        }
        return mostCommon;
}
	
	
	public String mostCommonWordExcludingStopWords(String [] tweets, String [] stopWords) {
        int big = -100000;
        String mostCommonNoStop = null;
        for (String tweet : tweets) {
                for (String word : tweet.split(" ")) {
                        boolean stopWord = false;
                        for(String s : stopWords)
                                if(word.equals(s))
                                        stopWord = true;
                        if(stopWord)
                                continue; //= skip next lines if stopword appears
                        int amt = 0;
                        for (String tweet2 : tweets)
                                for (String word2 : tweet2.split(" "))
                                        if (word2.equals(word))
                                                amt++;
                        if (amt > big) {
                                big = amt;
                                mostCommonNoStop = word;
                        }
                }
        }
        return mostCommonNoStop.toLowerCase();


	}}

