#reduce (also known as fold) is a function that takes in an array, a combining function, and an initial value and 
#builds up a result by calling the combining function on each element of the array, left to right. For example, we can write sum() in terms of reduce:
#def add(a, b):
#    return a + b
#
#def sum(lst):
#    return reduce(lst, add, 0)
#
#This should call add on the initial value with the first element of the array, 
#and then the result of that with the second element of the array, and so on until we reach the end, when we return the sum of the array.
#Implement your own version of reduce.

def __main__():
    test_list = [1, 2, 3, 4, 5]
    print(reduce(test_list, add, 0))
    
def reduce(lst, func, init = 0):
    for i in range(len(lst)):
        init = func(init, lst[i])
    return init

#Function to test our reduce
def add(a, b):
    return a + b

if __name__ == "__main__":
    __main__()