

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	
}
