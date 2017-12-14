/* Team You Go Glen Coco- Alexia Leong and Jude Grodesky
   APCS1 pd2
   HW 53 -- Solid Comparative Analysis
   2017-12-13 */

import java.util.ArrayList;

public class SortTester{
    public static void main (String[] args){
	/* Bubble sort:
	 * best case- when the array is already sorted because then you only need to pass through the array only one time without swapping items, all that is needed is to compare and not switch.
	 *Worst case- worst case is when the array is in descending order because you would have to compare and swap everything to move them from one end of the array to another. It's the most amount of swapping. */
	//best case - asending order
	ArrayList bestbub = new ArrayList<Integer>();
	bestbub.add(1);
	bestbub.add(3);
	bestbub.add(5);
	bestbub.add(7);
	bestbub.add(12);
	System.out.println("ArrayList for best bubble sort before sorting: \n" + bestbub);
	MySorts.bubbleSort(bestbub);
	System.out.println("ArrayList for best bubble sort after sorting: \n" + bestbub);
	//worst case- descending order
	System.out.println("-----------------------------------------------");
	ArrayList worstbub = new ArrayList<Integer>();
	worstbub.add(12);
        worstbub.add(7);
	worstbub.add(5);
	worstbub.add(3);
	worstbub.add(1);
	System.out.println("ArrayList for worst bubble sort before sorting: \n" + worstbub);
	MySorts.bubbleSort(worstbub);
	System.out.println("ArrayList for worst bubble sort after sorting: \n" + worstbub);
	/*Selection sort:
	  There is no best/worst case scenario because no matter the situation, you still have to go through the array and always will find the min value and compare no matter the order of the array. . */
	//ascending numbers
	System.out.println("-----------------------------------------------");
	ArrayList ascendSel = new ArrayList<Integer>();
	ascendSel.add(1);
	ascendSel.add(2);
	ascendSel.add(3);
	ascendSel.add(4);
	ascendSel.add(5);
	System.out.println("ArrayList for ascending selection sort before sorting: \n" + ascendSel);
	MySorts.selectionSort(ascendSel);
	System.out.println("ArrayList for ascending selection sort after sorting: \n" + ascendSel);
	System.out.println("-----------------------------------------------");
	//descending numbers
	ArrayList descendSel = new ArrayList<Integer>();
	descendSel.add(5);
        descendSel.add(4);
	descendSel.add(3);
	descendSel.add(2);
	descendSel.add(1);
	System.out.println("ArrayList for descending selection sort before sorting: \n" + descendSel);
	MySorts.selectionSort(descendSel);
	System.out.println("ArrayList for descending selection sort after sorting: \n" + descendSel);
        System.out.println("-----------------------------------------------");
	//random places
	ArrayList randSel = new ArrayList<Integer>();
	randSel = MySorts.populate(5,1,100);
	System.out.println("ArrayList for random order for selection sort before sorting: " + randSel);
	MySorts.selectionSort(randSel);
	System.out.println("ArrayList for random order for selection sort after sorting: " + randSel);
	
	/*Insertion sort:
	 *Best case - The best case is when the array is already sorted, there is no numbers that need to be walked to a different position because they're already at their final resting position. All that is needed is comparing.
	 *Worst case - The worst case is when the array is in descending order because everytime there's a pass and a switch, none of the numbers will be in their final resting place until the whole array is sorted. There's always going to be comparing and moving of numbers up until the end when everything is sorted. */
	//best case - asending order
	System.out.println("-----------------------------------------------");
	ArrayList bestIns = new ArrayList<Integer>();
	bestIns.add(1);
	bestIns.add(3);
	bestIns.add(5);
	bestIns.add(7);
	bestIns.add(12);
	System.out.println("ArrayList for best Insertion sort before sorting: \n" + bestIns);
	MySorts.insertionSort(bestIns);
	System.out.println("ArrayList for best Insertion sort after sorting: \n" + bestIns);
	//worst case- descending order
	System.out.println("-----------------------------------------------");
	ArrayList worstIns = new ArrayList<Integer>();
	worstIns.add(12);
        worstIns.add(7);
	worstIns.add(5);
	worstIns.add(3);
	worstIns.add(1);
	System.out.println("ArrayList for worst Insertion sort before sorting: \n" + worstIns);
	MySorts.insertionSort(worstIns);
	System.out.println("ArrayList for worst Insertion sort after sorting: \n" + worstIns);

    }
}
