#Implement 3 stacks using a single list:

def __main__():
    # Creates the multi-stack and adds a number of entries to test functionality
    stack = triple_stack()
    stack.push("1", 1)
    stack.push("2", 1)
    stack.push("3", 2)
    stack.push("4", 1)
    stack.push("5", 2)
    stack.push("6", 3)
    stack.push("7", 3)
    stack.push("8", 2)
    stack.push("9", 3)
    stack.show()

    # Showing that removal works correctly
    print(f"Removed: {stack.pop(1)}")
    stack.show()
    print(f"Removed: {stack.pop(2)}")
    stack.show()

class triple_stack:

    # Uses a list to act as the stack
    def __init__(self):
        self.list = []

    # When popping from the stack, checks from the top down and pops the first element found that belongs to that stack number
    def pop(self, stack_number):
        for element in reversed(self.list):
            if element[1] == stack_number:
                return self.list.pop(self.list.index(element))

    # Things are added to the stat as part of a tuple containing the item and which stack it belongs too
    def push(self, item, stack_number):
        self.list.append((item, stack_number))

    # Prints the contents of the stack, for testing
    def show(self):
        print(self.list)

if __name__ == "__main__":
    __main__()