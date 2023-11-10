# A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:
# if n is even, the next number in the sequence is n / 2
#  if n is odd, the next number in the sequence is 3n + 1 
# It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

def __main__():
    seq_solver = collatz_sequence_solver()
    for x in range(1, 101):
        print(seq_solver.solve(x))

class collatz_sequence_solver():
    
    def __init__(self):
        pass

    def solve(self, n):
        if n == 1:
            return n
        elif n < 1:
            return 0
        elif n % 2 == 0:
            return self.solve(n / 2)
        elif n % 2 == 1:
            return self.solve(3*n + 1)

if __name__ == "__main__":
    __main__()