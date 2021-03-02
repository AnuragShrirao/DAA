import java.util.*;
class QuickSort{
    int partition(int arr[],int lowest,int highest){
        int pivot = arr[(lowest+highest)/2];
        while(lowest<=highest)
        {
         while(arr[lowest]<pivot)
        {
            lowest++;
        }
        while(arr[highest]>pivot)
        {
            highest--;
        }
        if(lowest<=highest)
        {
            int temp = arr[lowest];
            arr[lowest]=arr[highest];
            arr[highest]=temp;
            lowest++;
            highest--;
        }
        }
        return lowest; //final position of pivot
    }
    void QuickSortRecursion(int arr[],int low,int high)
    {
        int pi = partition(arr, low, high);
        if(low<pi-1)
        {
            QuickSortRecursion(arr, low, pi-1);
        }
        if(high>pi)
        {
            QuickSortRecursion(arr, pi, high);
        }
    }
    void SortedArray(int arr[])
    {  
        int n = arr.length;
        System.out.print("[");
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
        System.out.println("]");
    }
    public static void main(String []args)
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
        QuickSort qsmp = new QuickSort();
        qsmp.QuickSortRecursion(arr,0,leng-1);
        System.out.println("Sorted Array : ");
        qsmp.SortedArray(arr);
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println("Time required to sort array by Quick Sort of length "+ leng + " is " + totalTime/1000000+ " mili seconds ");
    } 

}