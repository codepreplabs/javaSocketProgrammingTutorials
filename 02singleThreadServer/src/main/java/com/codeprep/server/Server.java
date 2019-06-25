package com.codeprep.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

	public static void main(String[] args) {
		
		Map<String, String> priceInfo = new HashMap<>();
		priceInfo.put("bag", "10$");

		try (ServerSocket serverSocket = new ServerSocket(9999)) {

			while (true) {
				Socket socket = serverSocket.accept();

				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();

				byte request[] = new byte[1024];
				inputStream.read(request);
				
				String product = new String(request).trim();

				if(priceInfo.get(product) != null) {
					outputStream.write(priceInfo.get(product).getBytes());
				}else {
					outputStream.write("Invalid Product!".getBytes());
				}
				socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
