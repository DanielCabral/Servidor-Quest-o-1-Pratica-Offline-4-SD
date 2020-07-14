package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {
	public static void main(String [] args) throws IOException, ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 
		File file = new File("LICENSE");
		File file2 = new File("C:\\Users\\Daniel\\Desktop\\Conceito de sistema distribuído.txt");
		Date date1= formatter.parse(formatter.format(file.lastModified()));
		Date date2= formatter.parse(formatter.format(file2.lastModified()));
		System.out.println(file2.lastModified());
		if(date1.compareTo(date2) > 0) {
			System.out.println(date1);
		}else {
			System.out.println(date2);
		}
		
	}
	
	public boolean arquivoMaisRecente(String nomeArquivo1, String nomeArquivo2) throws ParseException {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 
		File file = new File("LICENSE");
		File file2 = new File("java.policy");
		Date date1= formatter.parse(formatter.format(file.lastModified()));
		Date date2= formatter.parse(formatter.format(file2.lastModified()));
		if(date1.compareTo(date2) > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static String pegarDataDeModificacao(String caminho) throws IOException {
		File file = new File("LICENSE");

		return ""+file.lastModified();

	}
}
