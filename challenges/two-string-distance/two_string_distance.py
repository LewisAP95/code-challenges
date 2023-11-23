# Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.
#For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
# return 1 because there's only one word "cat" in between the two words.

def __main__():
    input_string = "dog cat hello cat dog dog hello cat world"
    first_word = "hello"
    second_word = "world"

    finder = string_distance_finder()
    finder.find_distance(input_string, first_word, second_word)

class string_distance_finder():
    
    def find_distance(self, input_string, first_word, second_word):
        input_list = input_string.split()

        first_indices = []
        second_indices = []
        lowest_gap = len(input_list)

        for i in range(len(input_list)):
            if input_list[i] == first_word:
                first_indices.append(i)
            elif input_list[i] == second_word:
                second_indices.append(i)

        for a in first_indices:
            for b in second_indices:
                if (b - a) - 1 < lowest_gap and (b - a) - 1 >= 0:
                    lowest_gap = (b - a) - 1

        print(first_indices)
        print(second_indices)
        print(lowest_gap)

if __name__ == "__main__":
    __main__() 