package appium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class testappium {

	public static void main(String[] args) throws Exception

	{

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 3; i++) {
		

				Runnable worker = new MyRunnable(i);
				executor.execute(worker);
		}
			
			executor.shutdown();
			// Wait until all threads are finish
			while (!executor.isTerminated()) {
	 
			}
			System.out.println("\nFinished all threads");
		

	}

	public static class MyRunnable implements Runnable {
		 private final int url;

		MyRunnable(int url) {
this.url=url;
		}

		@Override
		public void run() {

			String result = "";

			try {
				Process p = Runtime.getRuntime().exec(
						"F:\\Appium\\node.exe F:\\Appium\\node_modules\\appium\\bin\\appium.js --address 127.0.0.1 --port 4723");
				Thread.sleep(5000);
				BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = bfr.readLine();
				// System.out.println("Appim invoked, thread state is : "
				// + testSuite.getState());
				if (line == null) {
					bfr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
					line = bfr.readLine();
					System.out.println(line);
				}
				boolean flag = false;
				while (line != null) {
					//System.out.println("problemarea");
					//System.out.println(line);
					if (line.contains("Appium support")) {
						System.out.println(line);
						line = bfr.readLine();
					}
				}
				bfr.close();
			} catch (Exception e) {
				result = "->Red<-\t";
			}
			System.out.println( "\t\tStatus:" + url);
		}
	}
}
