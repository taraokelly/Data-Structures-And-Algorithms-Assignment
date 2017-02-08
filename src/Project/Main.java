package Project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		String w, bkName = null;
		String EXIT ="ESC";
		boolean end = false;

		Book book = new Book();
		System.out.println("Enter the book you wish to use: ");
		bkName = in.nextLine();
		book = new Book(bkName);
		do{
			System.out.println("Please enter the word you want to search: ");
			System.out.println("Enter ESC to terminate. ");
			w = in.nextLine().toUpperCase();
			if(w.equalsIgnoreCase(EXIT)){
				end=true;
			}else{
				System.out.println(book.getKey(w));
			}
		}
		while(!end);
		
		in.close();
	}//main
}//end class
