package com.visa.training.threads;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


public class FileSearch {
	public static void main(String[] args) throws Exception {
		
		String fileName = args[0];
		String folderName = args[1];
		File folder = new File(folderName);
		File[] contents = folder.listFiles();
		Queue<File> filesQueue = new ConcurrentLinkedQueue<File>();
		filesQueue.addAll(Arrays.asList(contents));
		List<File> results = Collections.synchronizedList(new ArrayList<>());
		
		SearchWorker w1 = new SearchWorker(fileName, filesQueue, results);
		w1.start();
		SearchWorker w2 = new SearchWorker(fileName, filesQueue, results);
		w2.start();
		SearchWorker w3 = new SearchWorker(fileName, filesQueue, results);
		w3.start();
		SearchWorker w4 = new SearchWorker(fileName, filesQueue, results);
		w4.start();
		
		//main will wait for these 4 threads to finish
		w1.join();
		w2.join();
		w3.join();
		w4.join();
		
		System.out.println("There were "+ results.size()+ " matches found.");
		results.forEach(f-> System.out.println(f.getAbsolutePath()));
	}
}
class SearchWorker extends Thread{
	String fileName;
	Queue<File> fileQueue;
	List<File> results;
	public SearchWorker(String fileName, Queue<File> fileQueue, List<File> results) {
		super();
		this.fileName = fileName;
		this.fileQueue= fileQueue;
		this.results = results;
	}
	
	public void run() {
		while(true) {
			File aFileOrFolder = fileQueue.poll();
			if(aFileOrFolder == null) {
				break;
			}
			if(aFileOrFolder.isFile() && aFileOrFolder.getName().equalsIgnoreCase(fileName)) {
                results.add(aFileOrFolder);
            }else if(aFileOrFolder.isDirectory() && aFileOrFolder.canRead()) {
                File[] contents = aFileOrFolder.listFiles();
                fileQueue.addAll(Arrays.asList(contents));
            }
		}
	}
	
}
