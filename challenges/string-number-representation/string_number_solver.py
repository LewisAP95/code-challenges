# Given a string, return whether the string in its entirety represents a number

import re
# Final RegEx string: ^(-?\d+\.*\d*)(e-?\d+\.*\d*)?$

def __init__():
    # Put various examples in a list to iterate through them
    input_list = ["10", "-10", "10.1", "-10.1", "1e5", "a", "x 1", "a -2", "-", "5.07ee7", "x-", "x 1. .1", "4e8.1aefsnkj 030", "4e8.1 b"]

    for entry in input_list:
        print(f"Does '{entry}' represent a number? {regex_solve(entry)}")

def regex_solve(entry):

    # re.search returns None if no match is found so we show true or false based on that
    if re.search("^(-?\d+\.*\d*)(e-?\d+\.*\d*)?$", entry) != None:
        result = True
    else:
        result = False

    return result

if __name__ == "__main__":
    __init__()