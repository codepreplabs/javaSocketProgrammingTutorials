package com.codeprep.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.codeprep.task.FetchData;

public class Server {

	public static void main(String[] args) {
		
		Map<String, String> priceInfo = new HashMap<>();
		priceInfo.put("bag", "10$");

		try (ServerSocket serverSocket = new ServerSocket(9999)) {

			while (true) {
				Socket socket = serverSocket.accept();
				
				ExecutorService executorService = Executors.newFixedThreadPool(10);
				executorService.execute(new FetchData(socket, priceInfo));
				executorService.shutdown();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
