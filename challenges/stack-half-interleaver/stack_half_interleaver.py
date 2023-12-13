#Given a stack of N elements, interleave the first half of the stack with the second half reversed using only one other queue. This should be done in-place.
#Recall that you can only push or pop from a stack, and enqueue or dequeue from a queue.
#For example, if the stack is [1, 2, 3, 4, 5], it should become [1, 5, 2, 4, 3]. If the stack is [1, 2, 3, 4], it should become [1, 4, 2, 3].

def __main__():
    test_stack_one = [1, 2, 3, 4 ,5]
    test_stack_two = [1, 2, 3, 4]
    test_stack_three = [1, 2, 3, 4, 5, 6, 7, 8]

    il = stack_half_interleaver()
    il.interleave(test_stack_one)
    il.interleave(test_stack_two)
    il.interleave(test_stack_three)
    print(test_stack_one)
    print(test_stack_two)
    print(test_stack_three)

class stack_half_interleaver():
    #Pop and append are used to have the input act as a stack
    #Inserting(at position 0) and popping is used to mimic enque and deque

    #Doing the steps in this manner causes the order of the remaining elements to invert after each step
    #This results in the stack being correctly interleaved with it's second half reverse by the end of the process 
    #This is done in place with the only extra data structure being the working queue
    
    def interleave(self, input_stack):
        self.working_queue = []
        self.step = 1
        self.elements_to_move = len(input_stack) - self.step

        while(self.elements_to_move > 0):
            for i in range(1, self.elements_to_move+1):
                #Pops from the stack and enques it into the start of the queue
                self.working_queue.insert(0, input_stack.pop())
            for i in range(1, self.elements_to_move+1):
                #Deques from the end of the queue and pushes it onto the top of the stack
                input_stack.append(self.working_queue.pop())
            self.step += 1
            self.elements_to_move = len(input_stack) - self.step

if __name__ == "__main__":
    __main__()