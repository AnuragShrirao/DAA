import time
def knapSack(W, wt, val, n): 
	K = [[0 for x in range(W + 1)] for x in range(n + 1)] 
	for i in range(n + 1): 
		for w in range(W + 1): 
			if i == 0 or w == 0: 
				K[i][w] = 0
			elif wt[i-1] <= w: 
				K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]) 
			else: 
				K[i][w] = K[i-1][w] 

	return K[n][W] 

val = []
wt =[]
n = int(input("Enter length of values"))
print("Enter values")
for i in range(0,n):
    ele = int(input())
    val.append(ele)
print("Enter wt for corresponding values")
for i in range(0,n):
    ele = int(input())
    wt.append(ele)
print("Enter capacity of knapsack")
W = int(input())
print("The knapsack is : ") 
start_time = time.time()
print(knapSack(W, wt, val, n)) 
print("Time Required to sort an array by Heap sort is %s milli seconds "  % ((time.time() - start_time)*1000))