import random
#Given a string of digits, generate all possible valid IP address combinations.
#IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255. Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
#For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].

def __main__():
    source_digits = "2542540123"
    new_ips = []

    #Stop the script if the provided string of source digits is too long or short to work at all
    if len(source_digits) not in range(4,13):
        raise SystemExit("Starting string either too long or too short to form a complete IP address.")
    
    #Run through combinations of the length of all four 'blocks' that make up an IPV4 address
    for first_block in range(1,4):
        for second_block in range(1, 4):
            for third_block in range(1, 4):
                for fourth_block in range(1, 4):
                    block = [first_block, second_block, third_block, fourth_block]
                    #Run further construction and validation only if that block length combination will use all of the provided source digits
                    if sum(block) == len(source_digits):
                        new_ip = []
                        slice_offset = 0
                        invalid = False
                        for i in block:
                            #Generate a block of the actual IP address by using the block lengths to slice out portions of the source string
                            ip_slice = source_digits[slice_offset:i+slice_offset]
                            if int(ip_slice) not in range(0, 256) or (len(ip_slice) > 1 and ip_slice[0] == "0"):
                                #Raises the invalid flag if the newly sliced IP portion does not meet requirements
                                invalid = True
                            else:
                                new_ip.append(ip_slice)
                            slice_offset += i

                        if not invalid:
                            #If everything is good, adds the new full IP to the results list in the string format requested
                            new_ips.append(f"{new_ip[0]}.{new_ip[1]}.{new_ip[2]}.{new_ip[3]}")

    print(new_ips)

if __name__ == "__main__":
    __main__()