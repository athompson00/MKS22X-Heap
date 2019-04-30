import java.util.*;
public class Heap{

  public static void main(String[] args) {
    int[] data = {5, 12, -3, 2, -12, 4, 3, 6, 2, 9, 10, 2};
    System.out.println(Arrays.toString(data));
    //pushDown(data,data.length - 1, 1);
    heapsort(data);
    System.out.println(Arrays.toString(data));
  }
  //We discussed these 2 methods already:
  private static void pushDown(int[]data,int size,int index){
  /*
       - size  is the number of elements in the data array.
       - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
       - precondition: index is between 0 and size-1 inclusive
       - precondition: size is between 0 and data.length-1 inclusive.
       */
       int temp = index;
       if (2 * index + 1 == size){
         if (data[index] < data[index * 2 + 1]){
           int n = data[index * 2 + 1];
           data[index * 2 + 1] = data[index];
           data[index] = n;
           index = index * 2 + 1;
         }
       }
       while ((2 * index + 2) <= size){
         if ((index * 2) + 2 <= size){
           if (data[index * 2 + 1] >= data[index * 2 + 2]){
             if (data[index] < data[index * 2 + 1]){
               int n = data[index * 2 + 1];
               data[index * 2 + 1] = data[index];
               data[index] = n;
               index = index * 2 + 1;
             }
           } else
           if (data[index * 2 + 1] < data[index * 2 + 2]){
             if (data[index] < data[index * 2 + 2]){
               int n = data[index * 2 + 2];
               data[index * 2 + 2] = data[index];
               data[index] = n;
               index = index * 2 + 2;
             }
           }
       }
       if (index == temp){
         index = size + 1;
       } else {
         temp = index;
       }
     }
   }

  private static void pushUp(int[]data,int index){
  /*
       - push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
       - precondition: index is between 0 and data.length-1 inclusive.
  */
  while ((index - 1) / 2 >= 0 && data[index] > data[(index - 1) / 2]){
    int n = data[(index - 1) / 2];
    data[(index - 1) / 2] = data[index];
    data[index] = n;
    index = (index - 1) / 2;
  }

}
  //We will discuss this today:
  public static void heapify(int[] data){
  /*
      - convert the array into a valid heap. [ should be O(n) ]
      */
      for (int i = data.length - 1; i >= 0; i--){
        pushDown(data, data.length - 1, i);
      }
  }
  public static void heapsort(int[] data){
  /*
      - sort the array [ should be O(nlogn) ] :
       converting it into a heap
       removing the largest value n-1 times (remove places at end of the sub-array).
       */

       //heapify(data);
       heapify(data);
       //System.out.println(Arrays.toString(data));
       for (int i = data.length - 1; i > 0; i--){
         //System.out.println(Arrays.toString(data));
         int n = data[i];
         data[i] = data[0];
         data[0] = n;
         //System.out.println(Arrays.toString(data));
         pushDown(data, i - 1, 0);
        // System.out.println(Arrays.toString(data));
         //System.out.println('\n');
       }

  }
}
