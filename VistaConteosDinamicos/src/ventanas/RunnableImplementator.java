package ventanas;

public class RunnableImplementator implements Runnable{
 int intArray[];
 int intNumDIntento;
 public RunnableImplementator(int arr[]) {
  intArray=arr;
 }
 public RunnableImplementator(int arr[],int intItento) {
  intArray=arr;
  intNumDIntento=intItento;
 }
 public void run()
 {
  try
  {
//   new MyBarras(intArray);
   new MyBarras(intArray,intNumDIntento);
  }
  catch(Exception ex)
  {
   ex.printStackTrace();
  }
 }//end run()
}//end class RunnableImplementator
