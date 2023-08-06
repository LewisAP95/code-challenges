import random
#Given a string of digits, generate all possible valid IP address combinations.
#IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255. Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
#For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].

def main():
    source_digits = "2542540123"
    valid_ips = []
    invalid_ips = []

    if len(source_digits) not in range(4,13):
        raise SystemExit("Starting string either too long or too short to form a complete IP address.")
    
    #keep two lists, one of valid IPs and one of invalid ones, if by the end up the loop and IP has already been found in EITHER list, assume all combos are done and break the loop
    while(True):
        random_set = []
        new_ip = []
        new_ip_string = ""

        for i in range(4):
            random_set.append(random.randint(1, 3))

        if sum(random_set) > len(source_digits):
            continue

        slice_offset = 0
        for x in random_set:
            new_ip.append(source_digits[slice_offset:x+slice_offset])
            slice_offset += x

        for n in new_ip:
            if n not in range(0, 256) or (len(n) > 1 and n[0] == 0):
                #composite and add to reject list?
                continue
            else:
                #composite and add to success list

if __name__ == "__main__":
    main()