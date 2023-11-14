# A strobogrammatic number is a positive number that appears the same after being rotated 180 degrees. 
# For example, 16891 is strobogrammatic.
# Create a program that finds all strobogrammatic numbers with N digits.

def __main__():

    strobo = strobo_number_finder()
    print(strobo.find(4))

# Class for the strobogrammatic number finder
# Its find function takes an integer to act as the amount of digits desired in the final numbers
# And then returns an ascending sorted list of the results

class strobo_number_finder():

    def __init__(self):

        self.allowed = (0, 1, 8, 6, 9)
        # Defines a restricted set of numbers for use in 1 length numbers or at the exact center of odd-digit numbers
        self.allowed_restricted = (0, 1, 8)
        self.results = []

    def find(self, digits):
        if digits < 1:
            return self.results

        # Sets up an empty list of the desired length, then calls the pairs function using the first and last index of the list
        self.current_strobo = [0]*digits
        self.strobo_pairs(self.current_strobo, 0, len(self.current_strobo)-1)
        self.results.sort()
        return self.results
        
    # Takes the current strobo number, as well as the desired pair within this number to generate
    def strobo_pairs(self, strobo, pair_first, pair_second):

        # Checks to see if the generation is finished, either when all pairs have been worked through
        # Or the center of an odd-numbered amount of digits has been reached (this also deals with 1 length numbers)
        # It then passes the number to the strobo_join function to be finalised and added to the results
        if pair_first > pair_second:
            self.strobo_join(strobo)
        elif pair_first == pair_second:
            for i in self.allowed_restricted:
                strobo[pair_first] = i
                self.strobo_join(strobo)

        # Various checks for special cases on the number being currently placed:
        # If it is 0, skips it if the current pair is the outermost one, this-
        # -avoids creating numbers with leading or trailing zeros, or that are composed only of zeros.
        # If the number is a 6 or 9, makes sure its other half will be the matching part of that pair.
        # Otherwise generates as normal, then calls itself recursively, moving to the next pair inward
        else:
            for i in self.allowed:
                if i == 0:
                    if pair_first == 0:
                        continue
                    else:
                        strobo[pair_first] = strobo[pair_second] = 0
                elif i == 6:
                    strobo[pair_first], strobo[pair_second] = 6, 9
                elif i == 9:
                    strobo[pair_first], strobo[pair_second] = 9, 6
                else:
                    strobo[pair_first] = strobo[pair_second] = i
                self.strobo_pairs(strobo, pair_first + 1, pair_second - 1)

    # As the numbers are generated as a list, this function turns them into a single integer to be added to the results list
    def strobo_join(self, strobo):

        #built_num = "".join(str(i) for i in strobo)
        #self.results.append(int(built_num))
        self.results.append(int("".join(str(i) for i in strobo)))

if __name__ == "__main__":
    __main__()