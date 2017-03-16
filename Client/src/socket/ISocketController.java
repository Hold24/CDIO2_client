package socket;

public interface ISocketController extends Runnable {
	
	public final static int PORT = 8000;
	public final static String address = "localhost";
	
	public void sendMessage(String msg);
	
	
}
