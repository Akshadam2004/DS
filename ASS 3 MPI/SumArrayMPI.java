import mpi.*;

public class SumArrayMPI{
 public static void main(String[] args)throws Exception{
  MPI.Init(args);
  int size = MPI.COMM_WORLD.Size();
  int rank = MPI.COMM_WORLD.Rank();
  int N = 100;
  int[] arr = new int[N];
  int sum = 0;

  if(rank == 0){
    for(int i = 0; i<N; i++){
       arr[i] = i+1;
  }
}

int localSize = N/size;
int[] localArr = new int[localSize];
MPI.COMM_WORLD.Scatter(arr, 0, localSize, MPI.INT, localArr, 0, localSize, MPI.INT, 0);

for(int i =0; i<localSize; i++){
  sum += localArr[i];
}

System.out.println("Process " + rank + "sum:" + sum);

int[] totalSum = new int[1];
MPI.COMM_WORLD.Reduce(new int[]{sum}, 0, totalSum, 0, 1, MPI.INT, MPI.SUM, 0);

if(rank == 0){
  System.out.println("Total sum:" + totalSum[0]);
}
 MPI.Finalize();
}
}
