package com.codeprep.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			Socket socket = serverSocket.accept();
			
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			byte buffer[] = new byte[1024];
			inputStream.read(buffer);
			
			System.out.println("Recieved from client: "+ new String(buffer).trim());
			outputStream.write("server: ack: ".getBytes());
			
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
