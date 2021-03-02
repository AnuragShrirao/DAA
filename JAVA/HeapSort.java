import java.util.*;
public class HeapSort {
	public void sort(int arr[])
	{
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}
	void heapify(int arr[], int n, int i)
	{
		int largest = i; 
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			heapify(arr, n, largest);
		}
	}
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner src = new Scanner(System.in);
        System.out.println("Enter The length of Array");
        int leng = src.nextInt();
        int arr[] = new int[leng];  
        System.out.println("Enter Element of Array");
        for ( int i=0;i<leng;i++ )
        {
            arr[i] = src.nextInt();
        }
        src.close();
        // int arr[] ={4,3,2,6,8,3,56,34,67,73,2345,85,2,4,77,77,334,234,86,321,6575,434,3424,47,324,34,5667,424,4,4,34234,324,345,45,555,475,58,77,86,86,89,4524,332,456,9,85,452,435,214,13,11,245,345,46,67,56,88,99,56,345,4,2,234,3,333,535,66,788,463,123,1334,3,43445,45,666,76,7678,5657,723,7878,783,7823,776,65,22,33,44,5,55,6,77,888,996,54,3,33,3,56,6,77};
        // int leng = arr.length;
        long startTime = System.nanoTime();
		HeapSort ob = new HeapSort();
		ob.sort(arr);
		System.out.println("Sorted array is");
		printArray(arr);
		long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Length of array is "+ leng);
        System.out.println("Time required to sort array by Heap Sort of length "+ leng + " is " + totalTime/1000000+ " mili seconds ");
	}
}
