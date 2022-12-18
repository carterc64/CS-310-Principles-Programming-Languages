
#Carter Copen
#This follows academic integrity policy

lookUpTable = {1: 1}
def hypercake(n,k):
    def combinations(n,r):
        def factorial(n):

            if n <= 1:
                return 1
            if n in lookUpTable:
                return lookUpTable[n]
            else:
                result = factorial(n-1)*n
                lookUpTable[n] = result
                return result

        if 0 <= r and r <= n:
            return factorial(n) / (factorial(r)*(factorial(n-r)))   
        else:
            return 0

    result = 0
    for x in range(k+1):
        result += combinations(n,x)
    return result


n = input("Enter Cuts:")
k = input("Enter Dimensons:")
print(hypercake(int(n), int(k)))
