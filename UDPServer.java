import java.net.*;
import java.io.*;


public class UDPServer 
{

	static int serverPort = 50003;
//	static String serverName = "localhost";
	
	public static void main(String[] args) 
	{
		DatagramSocket sSocket = null;
		try 
		{

			sSocket = new DatagramSocket(serverPort);
			byte[] bufferRequestReceived = new byte[1000];
			byte[] bufferServerResponse = new byte[1000];

			
			while(true)
			{
				//request received from client
				DatagramPacket clientRequestReceived = new DatagramPacket(bufferRequestReceived, bufferRequestReceived.length);
				sSocket.receive(clientRequestReceived);
				String receivedRequest = new String(clientRequestReceived.getData());
//				System.out.println("Client Requests: " + receivedRequest);
				
				if(receivedRequest.equals("1"))
				receivedRequest = "3";
				//Cases
//				switch()
				
				
				//send response to client
				bufferServerResponse = receivedRequest.getBytes();
				DatagramPacket serverResponse = new DatagramPacket(bufferServerResponse, bufferServerResponse.length,clientRequestReceived.getAddress(),clientRequestReceived.getPort());
				sSocket.send(serverResponse);
			}
			
		} 
		catch (SocketException e) {
			System.out.println("Server: Socket Error! " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Server: IO Error! " + e.getMessage());
		}
		finally
		{
			if(sSocket!=null)
				sSocket.close();
		}
	}
	
}
