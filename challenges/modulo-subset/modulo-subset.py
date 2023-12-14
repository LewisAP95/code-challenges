# Given a set of distinct positive integers, find the largest subset such that every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.
# For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. Given [1, 3, 6, 24], return [1, 3, 6, 24].

def __main__():
    example_set_one = [3, 5, 10, 20, 21]
    example_set_two = [1, 3, 6, 24]
    modset = modulo_subset()
    print(modset.find_largest_subset(example_set_one))
    print(modset.find_largest_subset(example_set_two))

class modulo_subset():
    # Finds and returns the largest subset within a given set
    # Where each pair satisfies either i % i+1 = 0 or vice versa
    
    def find_largest_subset(self, input_list):
        results = []
        working_set = []

        #Moves through the list examining pairs
        for i in range(len(input_list) - 1):
            if (input_list[i] % input_list[i+1] == 0) or (input_list[i+1] % input_list[i] == 0):
                #If a new subset is being built then adds i, otherwise only adds i+1
                if len(working_set) == 0:
                    working_set.append(input_list[i])
                working_set.append(input_list[i+1])
            #Once a 'failed' pair is found, provided the subset consists of at least one pair, adds it to the results
            #And clears it to beging a new subset
            else:
                if len(working_set) > 1:
                    results.append(working_set)
                    working_set.clear
        #Adds a valid subset if the end of the list has been reached
        if len(working_set) > 1:
                    results.append(working_set)
                    working_set.clear

        #Tracks the shortest found subset and returns it once all results have been checked
        shortest = 0
        for set_index in range(len(results)):
             if len(results[set_index]) < len(results[shortest]):
                  shortest = set_index
        return results[shortest]

if __name__ == "__main__":
    __main__()