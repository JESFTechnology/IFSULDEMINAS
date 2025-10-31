package model;

public class Scanner implements Scannable,Duplicable{

	@Override
	public void scanDocument(String content) {
		System.out.println("MP: Digitalizando documento: \n" + content);
	}
	
	@Override
	public void xeroxDocument(String content) {
		System.out.println("MP: Xerocando documento: \n" + content);
	}
}