package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class ServidorDeArquivos implements InterfaceDoServidorDeArquivos, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static HashMap<String,String> listaDeArquivos =new HashMap<String, String>();
	
	@Override
	public ArrayList<String> receberLista() throws RemoteException {
		ArrayList<String> listaDeArquivos1 = new ArrayList<String>(listaDeArquivos.keySet());
		return listaDeArquivos1;
	}
	
	
}
