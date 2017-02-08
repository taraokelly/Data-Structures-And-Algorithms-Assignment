package Project;

import java.util.*;

public class Details {
	
	private List<String>defintion = new LinkedList<String>();
	private List<Integer>page = new LinkedList<Integer>();
	
	public Details(){
		this.defintion = new LinkedList<String>();
		this.page = new LinkedList<Integer>();
	}
	
	public Details(int p){
		addIndex(p);
	}

	public void addIndex(int p){
		this.page.add(p);
	}
	
	@Override
	public String toString(){
		return "Defintion: " +getDefintion()+ "\n" + "Pages: " +getPage(); 
	}
	public List<String> getDefintion() {
		return defintion;
	}

	public void setDefintion(List<String> defintion) {
		this.defintion = defintion;
	}

	public List<Integer> getPage() {
		return page;
	}

	public void setPage(List<Integer> page) {
		this.page = page;
	}
}
