public class BerkeleyMaster {
  public static void main(String[] args) throws InterruptedException {
   
  BerkeleySlave[] slaves = new BerkeleySlave[4];
  slaves[0] = new BerkeleySlave(1, 100);
  slaves[1] = new BerkeleySlave(2, 104);
  slaves[2] = new BerkeleySlave(3, 95);
  slaves[3] = new BerkeleySlave(4, 98);

  for (BerkeleySlave slave : slaves) {
    slave.start();
  }

   for (BerkeleySlave slave : slaves) {
    slave.join();
  }

  int masterTime = 102;
  System.out.println("\nMaster initial time: " + masterTime);

  int sum = 0;
  for (BerkeleySlave slave : slaves) {
   sum += (slave.getTime() - masterTime);
 }
 int avgDiff = sum/ (slaves.length + 1);
 System.out.println("Average time difference: " + avgDiff);

 for (BerkeleySlave slave : slaves) {
  int diff = (masterTime - slave.getTime()) + avgDiff;
  slave.setAdjustment(diff);
  slave.applyAdjustment();
}

masterTime += avgDiff;
System.out.println("\nSynchronized times:");
for (BerkeleySlave slave : slaves) {
  slave.printFinalTime();
}
System.out.println("Master adjusted time: " + masterTime);
}
}
  




