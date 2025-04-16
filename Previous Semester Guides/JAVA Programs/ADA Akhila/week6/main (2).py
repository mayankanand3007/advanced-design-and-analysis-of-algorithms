from PIL import Image

def toPCX(pixels):
    pcx_pixels = []
    count = 0
    pos = 0
    last_px = pixels[0]
    while(len(pixels) > pos):
        px = pixels[pos]
        if(px is not last_px):
            pcx_pixels.append(count+192)
            pcx_pixels.append(last_px)
            count = 0
            last_px = px
        else:
            if(count == 63):
                pcx_pixels.append(count + 192)
                pcx_pixels.append(last_px)
                count = 1
        count += 1
        pos += 1
    return pcx_pixels

def toPCX2(pixels):
    pcx_pixels = []
    count = 0
    pos = 0
    last_px = pixels[0]
    while(len(pixels) > pos):
        px = pixels[pos]
        if(px is not last_px):
            if(count > 1):
                pcx_pixels.append(count+192)
                pcx_pixels.append(last_px)
                count = 0
                last_px = px
            else:
                if(last_px < 192):
                    pcx_pixels.append(last_px)
                    count = 0
                    last_px = px
                else:
                    pcx_pixels.append(count + 192)
                    pcx_pixels.append(last_px)
                    count = 0
                    last_px = px
        else:
            if(count == 63):
                pcx_pixels.append(count + 192)
                pcx_pixels.append(last_px)
                count = 1
        count += 1
        pos += 1
    return pcx_pixels

if __name__ == '__main__':
    img = Image.open('main_image_star-forming_region_carina_nircam_final-5mb-8bit.bmp')
#    img.show()
    pixels = list(img.getdata())
    width, height = img.size
    print(len(pixels))
    print(len(toPCX(pixels)))
    print(len(toPCX2(pixels)))
