package controller;

import socket.ISocketController;

public class MainController implements IMainController {
	
	private ISocketController socketController;
	
	public MainController(ISocketController socketController) {
		this.socketController = socketController;
	}
	
	public void start(){
		new Thread(socketController).start();
		//socketController.run();
		
	}

}
