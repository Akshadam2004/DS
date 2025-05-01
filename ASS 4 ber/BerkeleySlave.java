public class BerkeleySlave extends Thread {
  private int id;
  private int localTime;
  private int adjustment = 0;

public BerkeleySlave(int id, int localTime) {
 this.id = id;
 this.localTime = localTime;
}

public int getTime() {
 return localTime;
}

public void setAdjustment(int adj){
  adjustment = adj;
}

public void applyAdjustment(){
  localTime += adjustment;
}

public void run() {
 System.out.println("Slave " + id + " initial time: " + localTime);
}

public void printFinalTime() {
 System.out.println("Slave " + id + " adjusted time: " + localTime);
}
}




