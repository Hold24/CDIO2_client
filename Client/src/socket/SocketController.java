package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketController implements ISocketController {

	DataOutputStream toSocket;
	BufferedReader fromSocket;
	int counter = 0;


	public void run() {

		while(true){
			connect();
		}


	}

	public void connect() {
		try (Socket socket = new Socket(address, PORT);){

			if(socket.isConnected() && counter == 0){
				System.out.println("Connection established.");
				counter++;
			}

			toSocket = new DataOutputStream(socket.getOutputStream());
			//fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader fromUser = new BufferedReader(new InputStreamReader(System.in));
			Scanner inFromSocket = new Scanner(socket.getInputStream());
			String inLine;


			if(fromUser != null){
				System.out.println("Type a msg to the socket");
				String msg = fromUser.readLine();
				sendMessage(msg + " \n\r");

			}

			
			
			while(inFromSocket.hasNext()){
				inLine = inFromSocket.nextLine();
				switch(inLine.charAt(0)){
					
				
				}
				System.out.println(inLine);
			}

			inFromSocket.close();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void sendMessage(String msg) {

		if (toSocket != null) {
			try {
				toSocket.writeBytes(msg);
				//toSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	public String receiveMessage() throws NoInputFoundException {

		String msg = "";
		if(fromSocket != null) {
			try {
				msg = fromSocket.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(msg != null)
			return msg;


		throw new NoInputFoundException("No input from socket.");


	}

	public void closeConnection(Socket socket) {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







}
