/* Alexia Leong
APCS2 pd1
HW51 -- Heaping Piles of Sordidness
2018-05-21 */

public class HeapSort{

  public static void Heapify(int[] arr, int pos){
    int lchild = (pos * 2) + 1;
    int rchild = (pos * 2) + 2;
    while(lchild < arr.length && rchild < arr.length){
      if(arr[lchild] > arr[pos]) swap(arr, pos, lchild);
      if(arr[rchild] > arr[pos]) swap(arr, pos, rchild);
        pos += 1;
        lchild = (pos * 2) + 1;
        rchild = (pos * 2) + 2;
      }
    }


  public static void swap(int arr[], int a, int b){    //b is the parent
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void heapsort(int[] arr){
    for(int i = 0; i < arr.length; i++){ //going left to right
      Heapify(arr, i);
      swap(arr, 0, i);
    }
  }

  public static String print(int[] arr){
    String rtn = "";
    for(int i:arr){
      rtn += i + " ";
    }
    return rtn;
  }

  public static void main(String[] args) {
    int[] chips = {7,1,5,12,3};
    int[] are = {2};
    int[] great = {8,4,2,7,2,6,8,8};

    //testing
    System.out.println("chips array: " + print(chips));
    heapsort(chips);
    System.out.println("After sorting: " + print(chips));

    System.out.println("great array: " + print(great));
    heapsort(great);
    System.out.println("After sorting: " + print(great));

    System.out.println("great array: " + print(great));
    heapsort(great);
    System.out.println("After sorting: " + print(great));
  }



}
