package model;

import java.util.ArrayList;
import java.util.List;

public class Calc {
	private List<String> history;
	
	public Calc() {
		history = new ArrayList<>(); // Initialize the history list
	}
	
	public float sum(float firstNumber, float secondNumber) {
		String text = firstNumber+" + "+secondNumber+" = "+(firstNumber+secondNumber);
		addHistory(text);
		return firstNumber+secondNumber;
	}
	
	public float sub(float firstNumber, float secondNumber) {
		String text = firstNumber+" - "+secondNumber+" = "+(firstNumber-secondNumber);
		addHistory(text);
		return firstNumber-secondNumber;
	}
	
	public float mult(float firstNumber, float secondNumber) {
		String text = firstNumber+" * "+secondNumber+" = "+(firstNumber*secondNumber);
		addHistory(text);
		return firstNumber*secondNumber;
	}
	
	public float div(float firstNumber, float secondNumber) {
		String text = firstNumber+" / "+secondNumber+" = "+(firstNumber/secondNumber);
		addHistory(text);
		return firstNumber/secondNumber;
	}
	
	public String getHistoryAtIndex(int index){
		return history.get(index);
	}
	
	public String getHistoryLast(){
		return history.getLast();
	}
	
	public int getHistoryLenght() {
		return history.size();
	}
	
	public List<String> getHistory(){
		return history;
	}
	
	public boolean addHistory(String text){
		return history.add(text);
	}
}
