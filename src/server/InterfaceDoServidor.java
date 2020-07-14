package server;


import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;

import models.Arquivo;

//Criando a interface (Skeleton) do servidor
public interface InterfaceDoServidor extends Remote{

	public ArrayList<String> receberLista() throws RemoteException;
	public Arquivo enviarArquivo(String nome) throws RemoteException, IOException;
	public void adicionarArquivo(String nome, String caminho) throws RemoteException;
	public void receberArquivo(Arquivo arquivo) throws RemoteException, ParseException;
}
