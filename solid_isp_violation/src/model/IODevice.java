package model;

// Interface para equipamentos de I/O 
public interface IODevice {
	void faxDocument(String content);

	void printDocument(String content);

	void scanDocument(String content);

	void xeroxDocument(String content);
}