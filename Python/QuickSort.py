import time
def partition(arr,low,high): 
    i = ( low-1 )         
    pivot = arr[high]    
  
    for j in range(low , high): 
        if   arr[j] < pivot: 
            i = i+1 
            arr[i],arr[j] = arr[j],arr[i] 
  
    arr[i+1],arr[high] = arr[high],arr[i+1] 
    return ( i+1 ) 
def quickSort(arr,low,high): 
    if low < high: 
        pi = partition(arr,low,high) 
        quickSort(arr, low, pi-1) 
        quickSort(arr, pi+1, high) 

arr = []
n = int(input("Enter length of array"))
print("Enter element of Unsorted Array")
for i in range(0,n):
    ele = int(input())
    arr.append(ele)

# arr = [ 4,3,2,6,8,3,56,34,67,73,2345,85,2,4,77,77,334,234,86,321,6575,434,3424,47,324,34,5667,424,4,4,34234,324,345,45,555,475,58,77,86,86,89,4524,332,456,9,85,452,435,214,13,11,245,345,46,67,56,88,99,56,345,4,2,234,3,333,535,66,788,463,123,1334,3,43445,45,666,76,7678,5657,723,7878,783,7823,776,65,22,33,44,5,55,6,77,888,996,54,3,33,3,56,6,77,]
# n = len(arr) 

start_time = time.time()
quickSort(arr,0,n-1) 
print ("Sorted array is:") 
print(arr)
print("length of an Array is :")
print(n)
print("Time Required to sort an array by Quick sort is %s milli seconds "  % ((time.time() - start_time)*1000))