package com.visa.training.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class RunnablePrimeSearch implements Runnable{

	long start,end;
	int count;
	// For Thread pool, Create boolean var for ready.. to see if pool is done with the job
	volatile boolean resultReady;
	
	public RunnablePrimeSearch(long start,long end){
		this.start=start;
		this.end=end;
	}
	
	private boolean isPrime(long i) {
		if(i<2) {
			return true;
		}
		for(long j =2;j<i;j++) {
			if(i%j==0)
				return false;
		}
		return true;
	}
	@Override
	public void run() {
		for(long i = start;i <= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		resultReady= true;
	}

}

class CallablePrimeSearch implements Callable<Integer>{

	long start,end;
	int count;
	// For Thread pool, Create boolean var for ready.. to see if pool is done with the job
	volatile boolean resultReady;
	
	public CallablePrimeSearch(long start,long end){
		this.start=start;
		this.end=end;
	}
	
	private boolean isPrime(long i) {
		if(i<2) {
			return true;
		}
		for(long j =2;j<i;j++) {
			if(i%j==0)
				return false;
		}
		return true;
	}
	@Override
	public Integer call() {
		for(long i = start;i <= end; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		resultReady= true;
		return count;
	}

}

public class PrimeSearchApp{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunnablePrimeSearch v1= new RunnablePrimeSearch(1,100000);
		RunnablePrimeSearch v2= new RunnablePrimeSearch(100000,250000);
		
		//ooooold style
		/*Thread t1= new Thread(v1);
		Thread t2= new Thread(v2);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Primes b/w 1 and 100000  "+v1.count);
		System.out.println("Primes b/w 100000 and 250000  "+v2.count);
		*/
		
		//Using Thread Pool
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		/*pool.execute(v1);
		pool.execute(v2);
		
		while(!(v1.resultReady && v2.resultReady)) {
			Thread.sleep(200);
		}
		System.out.println("Primes b/w 1 and 100000  "+v1.count);
		System.out.println("Primes b/w 100000 and 250000  "+v2.count);
		pool.shutdown();
		*/
		
		//for Callable
		CallablePrimeSearch w1= new CallablePrimeSearch(1,10000);
		CallablePrimeSearch w2= new CallablePrimeSearch(10000,25000);
		
		Future<Integer> r1 = pool.submit(w1);
		Future<Integer> r2 = pool.submit(w2);
		
		System.out.println("Primes b/w 1 and 100000  "+ r1.get());
		System.out.println("Primes b/w 100000 and 250000  "+ r2.get());
		
		pool.shutdown();
	}
}
