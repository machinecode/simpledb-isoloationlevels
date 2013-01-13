package simpledb.client;

public class SimulationSelectUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateWorker worker1 = new UpdateWorker();
		SelectWorker worker2 = new SelectWorker();
		Thread thread1 = new Thread(worker1);
		Thread thread2 = new Thread(worker2);
		
		thread1.start();
		thread2.start();
		
		if(thread1.isAlive())
			System.out.println("Thread1 running");
		
		if(thread2.isAlive())
			System.out.println("Thread2 running");
	}

}
