package simpledb.client;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

import simpledb.remote.SimpleDriver;

public class UpdateWorker implements Runnable {

	@Override
	public void run() {
		Connection conn = null;
		try {
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);

			//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			Statement stmt = conn.createStatement();

//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			for(int i = 0 ; i < 3; i++){
				String cmd;
				if(i % 2 == 0)
					cmd = "update STUDENT set MajorId=30 "
			           + "where SName = 'amy'";
				else
					cmd = "update STUDENT set MajorId=20 "
					           + "where SName = 'amy'";
				stmt.executeUpdate(cmd);
				System.out.println("Amy's major changed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println(conn.getTransactionIsolation());
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
