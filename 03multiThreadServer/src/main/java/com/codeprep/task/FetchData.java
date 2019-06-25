package com.codeprep.task;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class FetchData implements Runnable {

	private Socket socket;
	private Map<String, String> cache = new HashMap<>();

	public FetchData(Socket socket, Map<String, String> cache) {
		super();
		this.socket = socket;
		this.cache = cache;
	}

	@Override
	public void run() {

		try {
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();

			byte request[] = new byte[1024];
			int bytesRead = inputStream.read(request);
			System.out.println("bytes read: "+ bytesRead);

			String product = new String(request).trim();

			if (cache.get(product) != null) {
				outputStream.write(cache.get(product).getBytes());
			} else {
				outputStream.write("Invalid Product!".getBytes());
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
