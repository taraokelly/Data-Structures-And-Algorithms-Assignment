package Project;

import java.io.*;
import java.util.*;

public class Book {
	
	private int page1=1, line1=1;
	Map<String, Details> wordMap = new HashMap<String, Details>();
	IgnoreWords ignore = new IgnoreWords("stopwords.txt");
	Dictionary dictionary = new Dictionary("dictionary.csv");
	
	public Book() {
		this.wordMap = new HashMap<String, Details>();
	}//Constructor
	//@SuppressWarnings("resource")

	public Book(String file) throws Exception{
		BufferedReader br;
		String [] words=null;
		String line;
		Details dets;
		long totalTime, endTime, startTime = System.currentTimeMillis();//for running time
		int i;
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		//reads text from a charater input stream
		br.readLine();
		while((line = br.readLine())!=null){ //line counter
			line1++;
			if(line1 % 40 == 0){ //page counter
				page1++;//every 40  pages turn page
			}
			words = line.split(" ");
			for(i=0;i < words.length;i++){
				/*
				 * if - ignore has the word skip in it
				 * else if - the map contains the word, assign dets to the word
				 * else - assign dets to a new page & put the words & dets into the map 
				 */
				if(ignore.getIgnore(words[i])){
					continue;
				}//if in stopwords.txt skip it
				if(wordMap.containsKey(words[i].toUpperCase())){
					//returns true if words[i] exists in map
					dets = wordMap.get(words[i].toUpperCase());
					dets.addIndex(page1); //if word found add current page to index
				}else {
					dets = new Details(page1);
					dets.setDefintion((dictionary.getDefine(words[i]))); //get and set the defintion for the word
					wordMap.put(words[i].toUpperCase(), dets);	
				}//else
			}//for
		}//while
		br.close(); //close file
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("Book parsed in: " + totalTime + "ms");//O(n) performance proportional to the size of the input data set
	}//book
	
	public String getKey(String k){
		long totalTime, endTime, startTime = System.currentTimeMillis();
		Details dets = wordMap.get(k.toUpperCase());
		String res;
		
		if(dets != null){
			res = dets.toString();//calls to string method
		} else res = "Not Found";//returns not found
		
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		return res +"\n Query Executed in: " + totalTime + "ms";
	}
	
	public Details getValue(String v){
		return wordMap.get(v);
	}
	
	public int getPage(){
		return this.page1;
	}
	public int getLine(){
		return this.line1;
	}
}//end class
