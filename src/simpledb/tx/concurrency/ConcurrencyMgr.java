package simpledb.tx.concurrency;

import simpledb.file.Block;
import java.util.*;

/**
 * The concurrency manager for the transaction.
 * Each transaction has its own concurrency manager. 
 * The concurrency manager keeps track of which locks the 
 * transaction currently has, and interacts with the
 * global lock table as needed. 
 * @author Edward Sciore
 */
public class ConcurrencyMgr {
   
   /**
    * The global lock table.  This variable is static because all transactions
    * share the same table.
    */
   private static LockTable locktbl = new LockTable();
   private Map<Block,String> locks  = new HashMap<Block,String>();
   
   /**
    * Obtains an SLock on the block, if necessary.
    * The method will ask the lock table for an SLock
    * if the transaction currently has no locks on that block.
    * @param blk a reference to the disk block
    */
   public void sLock(Block blk) {
      if (locks.get(blk) == null) {
         locktbl.sLock(blk);
         locks.put(blk, "S");
         System.out.println("S-Lock on" + blk.toString());
      }
    //alttaki 3 satırı ben yazdım
//    else {
//		throw new LockAbortException();
//	}
      
   }
   
   public void releaseSLock(Block blk) {
	      if (locks.get(blk) != null) {
	         locktbl.unlock(blk);
	         System.out.println("S-Lock released on" + blk.toString());
	      }
	   }
   
   /**
    * Obtains an XLock on the block, if necessary.
    * If the transaction does not have an XLock on that block,
    * then the method first gets an SLock on that block
    * (if necessary), and then upgrades it to an XLock.
    * @param blk a refrence to the disk block
    */
   public void xLock(Block blk) {
      if (!hasXLock(blk)) {
         sLock(blk);
         locktbl.xLock(blk);
         locks.put(blk, "X");
         System.out.println("X-Lock on" + blk.toString());
      }
      //alttaki 3 satırı ben yazdım
//      else {
//		throw new LockAbortException();
//	}
   }
   
   /**
    * Releases all locks by asking the lock table to
    * unlock each one.
    */
   public void release() {
      for (Block blk : locks.keySet())
         locktbl.unlock(blk);
      locks.clear();
      System.out.println("All locks released.");
   }
   
   private boolean hasXLock(Block blk) {
      String locktype = locks.get(blk);
      return locktype != null && locktype.equals("X");
   }
   
   
}
