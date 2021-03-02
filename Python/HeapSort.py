import time
def heapify(arr, n, i):
	largest = i 
	l = 2 * i + 1
	r = 2 * i + 2
	if l < n and arr[largest] < arr[l]:
		largest = l
	if r < n and arr[largest] < arr[r]:
		largest = r
	if largest != i:
		arr[i], arr[largest] = arr[largest], arr[i] 
		heapify(arr, n, largest)

def heapSort(arr):
	n = len(arr)
	for i in range(n//2 - 1, -1, -1):
		heapify(arr, n, i)
	for i in range(n-1, 0, -1):
		arr[i], arr[0] = arr[0], arr[i] 
		heapify(arr, i, 0)

arr = []
n = int(input("Enter length of array"))
print("Enter element of Unsorted Array")
for i in range(0,n):
    ele = int(input())
    arr.append(ele)
# arr = [ 4,3,2,6,8,3,56,34,67,73,2345,85,2,4,77,77,334,234,86,321,6575,434,3424,47,324,34,5667,424,4,4,34234,324,345,45,555,475,58,77,86,86,89,4524,332,456,9,85,452,435,214,13,11,245,345,46,67,56,88,99,56,345,4,2,234,3,333,535,66,788,463,123,1334,3,43445,45,666,76,7678,5657,723,7878,783,7823,776,65,22,33,44,5,55,6,77,888,996,54,3,33,3,56,6,77,]
# n = len(arr)
start_time = time.time()
heapSort(arr)
print("Sorted array is : ")
print(arr)
print("length of an Array is :")
print(n)
print("Time Required to sort an array by Heap sort is %s milli seconds "  % ((time.time() - start_time)*1000))