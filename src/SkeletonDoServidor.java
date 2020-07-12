


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SkeletonDoServidor {
	// Constantes que indicam onde est´a sendo executado o servi¸co de registro,
	// qual porta e qual o nome do objeto distribu´ıdo
	private static String nomeServidor = "127.0.0.1";
	private static int porta = 12344;
	private static final String NOMEOBJDIST = "ServidorDeArquivos";
	
	public static void main(String args[]){
		try {
			// Criando
			Servidor c = new Servidor();
			
			System.setProperty("java.security.policy", "java.policy");
			if (System.getSecurityManager() == null) {
			 System.setSecurityManager(new SecurityManager());
			 }
			
			System.setProperty("java.security.policy","file:java.policy");
             
			// Definindo o hostname do servidor
			System.setProperty("java.rmi.server.hostname", nomeServidor);
			
			InterfaceDoServidor stub = (InterfaceDoServidor)
			UnicastRemoteObject.exportObject(c, 0);
			
			// Criando serviço de registro
			Registry registro = LocateRegistry.createRegistry(porta);
			
			// Registrando objeto distribu´ıdo
			registro.bind(NOMEOBJDIST, stub);
			
			System.out.println("Servidor de arquivos pronto!\n");
			System.out.println("Endere�o: "+nomeServidor+"\nPorta: "+porta+"\n");
			System.out.println("Pressione CTRL + C para encerrar...");
		} catch (RemoteException | AlreadyBoundException ex) {
		Logger.getLogger(SkeletonDoServidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}