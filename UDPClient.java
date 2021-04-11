import java.net.*;
import java.io.*;
import java.util.*;

public class UDPClient 
{

	static int serverPort = 50003;
	static String serverName = "localhost";

	public static void main(String[] args) 
	{
		DatagramSocket cSocket = null;
		Scanner scanner = new Scanner(System.in);
		String msg = "start";
		
		try 
		{			

			cSocket = new DatagramSocket();
			InetAddress aHost = InetAddress.getByName(serverName);
			
			//send request
			sendRequest(cSocket,msg,aHost);
			
			//receive response
			String result = receiveResponse(cSocket);
			menu();
			switch(scanner.next())
			{
			case "1": System.out.println(1);
					  sendRequest(cSocket, result, aHost);
				break;
			case "2": System.out.println(2);
					  sendRequest(cSocket, result, aHost);
				break;
			case "3": System.out.println("Exit");
				break;
			default: System.out.println(11);
					  sendRequest(cSocket, "", aHost);

				break;
			
			}
			
			
		} 
		catch (SocketException e) {
			System.out.println("Socket Error :" + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("IO Error :" + e.getMessage());
		}
		finally
		{
			if(cSocket!=null)
				cSocket.close();
		}
		
		
	}
	
	
	 static void sendRequest(DatagramSocket cSocket, String msg, InetAddress aHost) throws IOException
	{
		byte[] bufferRequest = msg.getBytes();			
		DatagramPacket request = new DatagramPacket(bufferRequest, bufferRequest.length,aHost,serverPort);
		cSocket.send(request);
		
	}
	
	static String receiveResponse(DatagramSocket cSocket) throws IOException
	{
		byte[] bufferResponse = new byte[1000];
		DatagramPacket response = new DatagramPacket(bufferResponse, bufferResponse.length);
		cSocket.receive(response);

//		System.out.println("Response : - " + new String(response.getData()));
		return new String(response.getData());

	}	
	
	static void menu()
	{
		System.out.println("**************TRAVEL KIOSK***************");
		System.out.println("                 1:IN                    ");
		System.out.println("                 2:OUT                   ");
		System.out.println("                 3:EXIT                  ");
		System.out.println("Enter:");
	}
	
	
	
}
