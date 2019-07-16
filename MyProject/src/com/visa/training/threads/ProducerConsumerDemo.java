package com.visa.training.threads;

class Buffer {

	int data;
	boolean available = false;
	
	public synchronized void produce(int newData) throws Exception {
		while(available) {
			this.wait();//Thread.sleep(100);
		}
		System.out.println("Producer producing  -->" +newData);
		data=newData;
		available = true;
		this.notify();
	}
	
	public synchronized int consume() throws Exception{
		while(!available) {
			this.wait();//Thread.sleep(100);
		}
		System.out.println("Consuming -->" +data);
		available = false;
		this.notify();
		return data;
		
	}
}

class Producer extends Thread{
	
	Buffer buffer;
	public Producer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			try {
				buffer.produce(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer extends Thread{
	
	Buffer buffer;
	public Consumer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			try {
				System.out.println(buffer.consume());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class ProducerConsumerDemo{
	public static void main(String[] args) {
		Buffer buffer = new Buffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		producer.start();
		consumer.start();
		System.out.println();
	}
}
