package server;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.Patch;

import models.Arquivo;

public class Servidor implements InterfaceDoServidor, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static HashMap<String,String> listaDeArquivos =new HashMap<String, String>();
	
	@Override
	public ArrayList<String> receberLista() throws RemoteException {
		System.out.println("Servidor de Arquivos - Cliente Solicitou lista de arquivos. Enviando...\n");
		ArrayList<String> listaDeArquivos1 = new ArrayList<String>(listaDeArquivos.keySet());
		return listaDeArquivos1;
	}
	
	public Arquivo enviarArquivo(String nome) throws IOException {
		String caminho = listaDeArquivos.get(nome);
		String dataDeModificacao = pegarDataDeModificacao(caminho);
		System.out.println("Data de modificacao: "+dataDeModificacao);
		Arquivo arquivo = new Arquivo();
		arquivo.setConteudo(controller.Arquivo.lerArquivo(caminho));
		arquivo.setNome(nome);
		arquivo.setDataDeModificacao(dataDeModificacao);
		
		return arquivo;
	}
	
	public void receberArquivo(Arquivo arquivo) throws RemoteException, ParseException{
		System.out.println("Gravar Arquivo");
		System.out.println(arquivo.getNome());
		System.out.println(listaDeArquivos.get(arquivo.getNome()));
		controller.Arquivo.gravarArquivoTexto(listaDeArquivos.get(arquivo.getNome()), arquivo.getConteudo());
	}
	
	public void adicionarArquivo(String nome, String caminho) throws RemoteException{
		listaDeArquivos.put(nome, caminho);
	}
	
	public String pegarDataDeModificacao(String caminho) throws IOException {
		File file = new File(caminho);
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 
		
		return (""+formatter.format(file.lastModified()));
	}
	
}
