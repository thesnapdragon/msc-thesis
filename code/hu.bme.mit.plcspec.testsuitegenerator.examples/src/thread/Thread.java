package thread;

public class Thread {
   public int start() {
      return 1;
   }
   public int terminate() {
      return 3;
   }
   public int sleep() {
      return 2;
   }
   public int wait1() {
      return 2;
   }
   public int join1() {
      return 2;
   }
   public int wait2() {
      return 4;
   }
   public int join2() {
      return 4;
   }
   public int waitForLock() {
	   return 5;
   }
   public int timeout() {
	   return 1;
   }
   public int notify1() {
	   return 1;
   }
   public int notifyAll1() {
	   return 1;
   }
   public int monitorLockAcquired() {
	   return 1;
   }
}
