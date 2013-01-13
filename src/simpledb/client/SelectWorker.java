package simpledb.client;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import simpledb.remote.SimpleDriver;

public class SelectWorker implements Runnable {

	@Override
	public void run() {
		Connection conn = null;
		try {
			Driver d = new SimpleDriver();
			conn = d.connect("jdbc:simpledb://localhost", null);

			//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

			Statement stmt = conn.createStatement();
			String qry = "select SName, SId, MajorId " + "from STUDENT where SId = 2";

			for (int i = 0; i < 5; i++) {
				ResultSet rs = stmt.executeQuery(qry);
				
				// Step 3: loop through the result set
				System.out.println("Name\tMajor");
				while (rs.next()) {
					String sname = rs.getString("SName");
					Integer dname = rs.getInt("MajorId");
					System.out.println(sname + "\t" + dname.toString());
				}
				rs.close();
				System.out.println("Worker-1 : Insert - "+i+" Completed.");
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
