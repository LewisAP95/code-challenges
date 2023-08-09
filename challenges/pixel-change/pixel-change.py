#Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C,
#- replace the color of the given pixel and all adjacent same colored pixels with C.

def __main__(image, pixel, colour):
    print(f"Replacing pixel at index: {pixel} With colour: {colour} In starting image: \n")
    for i in image:
        print(i)

    #Make a list for our group of adjacent pixels and then run the group scanning function
    pixels_found = []
    scan_grouped(pixels_found, pixel, image)

    #Use the tuples containing indices of found colour matches in the group list to replace them all with the chosen colour
    for p in pixels_found:
        image[p[0]][p[1]] = colour

    print("Final image: \n")
    for i in image:
        print(i)

#For each time this is called:
# - We assume if it's been passed in then it's been confirmed part of the same colour as the group
# - We add it to the results list
# - Then each direction is checked one by one:
# -- If 'moving' in a direction would go OOB of the list, we skip that direction
# -- We then check if the new pixel is the same colour as the current one
# -- If it is, we make sure it isn't already in the results list to avoid infinite recursion
# -- If the new pixel has passed all these checks, we have this function call itself, and so on, until every adjacent pixel has been found
def scan_grouped(group_list, pixel, image):
    #Variable assignments to make things a little cleaner to look at 
    pixel_x = pixel[1]
    pixel_y = pixel[0]
    group_list.append(pixel)

    #Up
    if not pixel_y - 1 < 0:
        if image[pixel_y - 1][pixel_x] == image[pixel_y][pixel_x]:
            if (pixel_y - 1, pixel_x) not in group_list:
                scan_grouped(group_list, (pixel_y - 1, pixel_x), image)

    #Down
    if not pixel_y + 1 >= len(image):
        if image[pixel_y + 1][pixel_x] == image[pixel_y][pixel_x]:
            if (pixel_y + 1, pixel_x) not in group_list:
                scan_grouped(group_list, (pixel_y + 1, pixel_x), image)

    #Left
    if not pixel_x - 1 < 0:
        if image[pixel_y][pixel_x - 1] == image[pixel_y][pixel_x]:
            if (pixel_y, pixel_x - 1) not in group_list:
                scan_grouped(group_list, (pixel_y, pixel_x - 1), image)

    #Right
    if not pixel_x + 1 >= len(image[0]):
        if image[pixel_y][pixel_x + 1] == image[pixel_y][pixel_x]:
            if (pixel_y, pixel_x + 1) not in group_list:
                scan_grouped(group_list, (pixel_y, pixel_x + 1), image)

    return

if __name__ == "__main__":
    image = [
        ['B','B', 'W'],
        ['W', 'W', 'W'],
        ['W', 'W', 'W'],
        ['B', 'B', 'B']
    ]
    #Coords are (y, x) with y being inverse downwards
    pixel = (2, 2)
    colour = 'G'
    __main__(image, pixel, colour)