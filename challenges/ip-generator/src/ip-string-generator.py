import random
#Given a string of digits, generate all possible valid IP address combinations.
#IP addresses must follow the format A.B.C.D, where A, B, C, and D are numbers between 0 and 255. Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
#For example, given "2542540123", you should return ['254.25.40.123', '254.254.0.123'].

def main():
    source_digits = "2542540123"
    new_ips = []

    if len(source_digits) not in range(4,13):
        raise SystemExit("Starting string either too long or too short to form a complete IP address.")
    
    new_ip_blocks = []
    for first_block in range(1,4):
        for second_block in range(1, 4):
            for third_block in range(1, 4):
                for fourth_block in range(1, 4):
                    block = [first_block, second_block, third_block, fourth_block]
                    if sum(block) == len(source_digits):
                        new_ip_blocks.append(block)

    for ip_block in new_ip_blocks:
        new_ip = []
        slice_offset = 0
        invalid = False
        for i in ip_block:
            ip_slice = source_digits[slice_offset:i+slice_offset]
            if int(ip_slice) not in range(0, 256) or (len(ip_slice) > 1 and ip_slice[0] == "0"):
                invalid = True
            else:
                new_ip.append(ip_slice)
            slice_offset += i

        if not invalid:
            ip_string = f"{new_ip[0]}.{new_ip[1]}.{new_ip[2]}.{new_ip[3]}"
            new_ips.append(ip_string)

    print(new_ips)

if __name__ == "__main__":
    main()