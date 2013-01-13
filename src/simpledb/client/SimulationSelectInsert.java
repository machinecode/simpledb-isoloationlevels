package simpledb.client;

public class SimulationSelectInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectWorker worker2 = new SelectWorker();
		InsertWorker worker3 = new InsertWorker();
		Thread thread2 = new Thread(worker2);
		Thread thread3 = new Thread(worker3);
		
		thread2.start();
		thread3.start();
				
		if(thread2.isAlive())
			System.out.println("Thread2 running");
		
		if(thread3.isAlive())
			System.out.println("Thread3 running");
	}

}
