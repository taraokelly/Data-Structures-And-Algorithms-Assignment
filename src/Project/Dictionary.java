package Project;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	Map<String, List<String>> wordMap = new HashMap<String, List<String>>();
//	File theFile = new File("dictionary.csv");
	public Dictionary() {
		this.wordMap = new HashMap<String, List<String>>();
	}//constructor
	public Dictionary(String file) {
	
	try{
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder d = new StringBuilder();
		//word;
		br.readLine();
		String line = br.readLine();

		while((line = br.readLine()) != null){
			//read in the word and definition
			if(line.charAt(0)=='"'){ //separated values
				String word = line.substring(1, line.indexOf('"',1));
				do{
					d.append(line + "\n");
					line = br.readLine();
				}//while the next line is not equal to null and char a t pos 0 is not equal to null
			while((line = br.readLine())!= null && line.charAt(0)!='"');
			setDefine(word.toUpperCase(), d.toString());
			d = new StringBuilder();
			}//if
		}//while line read in from buffer reader is not null
		br.close();	
	}catch(Exception e){
			e.printStackTrace();
		}//try catch
	}//read in and parse the dictionary
	public List<String> getDefine(String word){
		return wordMap.get(word.toUpperCase());		
	}//get 

	public void setDefine(String word, String definition){
		if(wordMap.get(word)==null){
			List<String> ls = new LinkedList<String>();
			ls.add(definition);
			wordMap.put(word, ls);
		}//word not in dictionary
		else
			wordMap.get(word).add(definition);
		}//word in dictionary, add definition to it
	}//set

