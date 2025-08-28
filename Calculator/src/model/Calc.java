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
		if(firstNumber == 0 || secondNumber == 0) throw new IllegalArgumentException("Não existe  divisão por 0");
		String text = firstNumber+" / "+secondNumber+" = "+(firstNumber/secondNumber);
		addHistory(text);
		return firstNumber/secondNumber;
	}
	
	public float div_rem(float firstNumber, float secondNumber) {
		if(firstNumber == 0 || secondNumber == 0) throw new IllegalArgumentException("Não existe  divisão por 0");
		String text = firstNumber+" % "+secondNumber+" = "+(firstNumber/secondNumber);
		addHistory(text);
		return firstNumber%secondNumber;
	}
	
	public int fat(int firstNumber) {
		if(firstNumber == 0) return 1;
		int fact = 1;
		String text = "Fatorial de "+firstNumber+" | 1";
		for(int i = 2; i <= firstNumber; i++) {
			fact = fact * i;
			text += "*"+i+"";
		}
		text += " = "+fact;
		addHistory(text);
		int result = fact;
		return result;
	}
	
	public String decToBin(int firstNumber) {
        String result = "";
        String text;
        while (firstNumber > 0) {
            int resto = firstNumber % 2;
            result = resto + result;
            firstNumber = firstNumber / 2;
        }
        text = "Dec: "+firstNumber+" | Hex: "+result;
        addHistory(text);
		return result;
	}
	
	public String decToHex(int firstNumber) {
        String hexDigits = "0123456789ABCDEF";
        String result = "";
        String text;
        while (firstNumber > 0) {
            int resto = firstNumber % 16;
            result = hexDigits.charAt(resto) + result;
            firstNumber = firstNumber / 16;
        }
        text = "Dec: "+firstNumber+" | Hex: "+result;
        addHistory(text);
		return result;
	}
	
	public float percentSumvalue(float firstNumber, float percent) {
        float result = firstNumber+(firstNumber*(percent/100));
        String text = firstNumber+" + "+percent+"% ="+result;
        addHistory(text);
		return result;
	}
	
	public float percentSubvalue(float firstNumber, float percent) {
        float result = firstNumber-(firstNumber*(percent/100));
        String text = firstNumber+" - "+percent+"% = "+result;
        addHistory(text);
		return result;
	}
	
	public float percentOfvalue(float firstNumber, float percent) {
        float result = firstNumber*(percent/100);
        String text = percent+"% de "+firstNumber+" = "+result;
        addHistory(text);
		return result;
	}
	
	public String getHistoryAtIndex(int index){
		String historyIndex = history.get(index);
		return historyIndex;
	}
	
	public String getHistoryLast(){
		String historyLast = history.getLast();
		return historyLast;
	}
	
	public int getHistoryLenght() {
		int historySize = history.size();
		return historySize;
	}
	
	public List<String> getHistory(){
		List<String> history = this.history;
		return history;
	}
	
	public boolean addHistory(String text){
		boolean historyReturn = this.history.add(text);
		return historyReturn;
	}
}
