package simpledb.client;

public class SimulationAll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateWorker worker1 = new UpdateWorker();
		SelectWorker worker2 = new SelectWorker();
		InsertWorker worker3 = new InsertWorker();
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		Thread thread3 = new Thread(worker3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		if(thread1.isAlive())
			System.out.println("Thread1 running");
		
		if(thread2.isAlive())
			System.out.println("Thread2 running");
		
		if(thread3.isAlive())
			System.out.println("Thread3 running");
	}

}
