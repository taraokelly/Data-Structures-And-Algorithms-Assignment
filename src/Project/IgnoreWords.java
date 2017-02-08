package Project;

import java.io.*;
import java.util.*;

public class IgnoreWords {
	 private Set<String> ignoreWords = new TreeSet<String>();
	 //create tree set
	 public IgnoreWords(){
		 this.ignoreWords = new TreeSet<String>();
	 }
	 public IgnoreWords(String file){
		 
		 try{
		 Scanner stopWord = new Scanner(new File(file));
		  while (stopWord.hasNext()){//keep reading while file is not null
			  ignoreWords.add(stopWord.next().toUpperCase());//scan all stop words from file and populate TreeSet (ignoreWords)
		  }
		  stopWord.close();//close
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }//read in and parse text file
	 public boolean getIgnore(String ignore){
		 return ignore.contains(ignore.toUpperCase());
	 }
}//end
