package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import server.SkeletonDoServidor;

public class ServidorController implements Initializable {
	@FXML
	ImageView imagem;
	
	@FXML
	javafx.scene.control.ListView listaDeArquivos;
	
	SkeletonDoServidor servidor;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		servidor = new SkeletonDoServidor();
	}	
	
	@FXML
	public void handleDragOver(DragEvent e) {
		if(e.getDragboard().hasFiles()) {
			e.acceptTransferModes(TransferMode.ANY);
		}
		
	}
	
	@FXML
	public void handleDrop(DragEvent e) throws FileNotFoundException, RemoteException {
		List<File> files = e.getDragboard().getFiles();
		String extension = "";
		String nomeDoArquivo=files.get(0).getName();
		String caminho = files.get(0).getAbsolutePath();
		int i = caminho.lastIndexOf('.');
		
		if (i > 0) {
		    extension = caminho.substring(i+1);
		}
		
		//Verificar se arquivo é txt
		if(extension.equals("txt")) {
			System.out.println(nomeDoArquivo);
			//Adicionar a lista de arquivos -ListView da tela e hashmap
			listaDeArquivos.getItems().add(nomeDoArquivo);			
			servidor.adicionarArquivo(nomeDoArquivo, caminho);
		}
	}
	
	@FXML
	public void pararServidor() {
		System.exit(0);
	}
}
