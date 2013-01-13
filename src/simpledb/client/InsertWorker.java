package simpledb.client;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

import simpledb.remote.SimpleDriver;

public class InsertWorker implements Runnable{

	@Override
	public void run() {
		Connection conn = null;
		try {
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);

			//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			Statement stmt = conn.createStatement();
			//String qry = "select SName, SId, MajorId " + "from STUDENT where SId = 2";

			String s = "insert into STUDENT(SId, SName, MajorId, GradYear) values ";
			String[] studvals = {"(10, 'ezgi', 10, 2004)",
								 "(11, 'ömer', 20, 2004)",
								 "(12, 'emine', 30, 2005)",
								 "(13, 'güray', 20, 2005)",
								};
			for (int i=0; i<studvals.length; i++)
				stmt.executeUpdate(s + studvals[i]);
			System.out.println("STUDENT records inserted.");
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
