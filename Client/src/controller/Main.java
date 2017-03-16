package controller;

import socket.ISocketController;
import socket.SocketController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISocketController socketController = new SocketController();
		IMainController mainController = new MainController(socketController);
		mainController.start();
		System.out.println("");
	}
}
