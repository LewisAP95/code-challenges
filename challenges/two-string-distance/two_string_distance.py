# Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.
#For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
# return 1 because there's only one word "cat" in between the two words.

def __main__():
    input_string = "dog cat hello cat dog dog hello cat world"
    first_word = "hello"
    second_word = "world"

    finder = string_distance_finder()
    print(f"Smallest amount of words between '{first_word}' and '{second_word}' was {finder.find_distance(input_string, first_word, second_word)}")

class string_distance_finder():
    
    def find_distance(self, input_string, first_word, second_word):
        # Turn the input string into a list and set up empty lists to contain the indices for the found words
        input_list = input_string.split()
        first_indices = []
        second_indices = []

        # Starting gap is set to the length of the list as no gap could ever be longer than this
        lowest_gap = len(input_list)

        # Loops through the list recording the positions of matches to either chosen word
        for i in range(len(input_list)):
            if input_list[i] == first_word:
                first_indices.append(i)
            elif input_list[i] == second_word:
                second_indices.append(i)

        # Compares the indices against each other and returns the distance between the closest pair
        # Does not count pairs that 'cross over' i.e. where word two is before word one
        for a in first_indices:
            for b in second_indices:
                if (b - a) - 1 < lowest_gap and (b - a) - 1 >= 0:
                    lowest_gap = (b - a) - 1

        return lowest_gap

if __name__ == "__main__":
    __main__() 