public class Main {
    static final String alphabet = "ACGT";
    public static String compressDNA(String DNA)
    {
        StringBuilder compressedDNA = new StringBuilder();
        for (int i = 0; i < DNA.length(); i++) {
            compressedDNA.append(String.format("%2s", Integer.toBinaryString(alphabet.indexOf(DNA.charAt(i)))).replace(' ', '0'));
        }
        return compressedDNA.toString();
    }

    public static String expandDNA(String compressedDNA)
    {
        StringBuilder DNA = new StringBuilder();
        for (int i = 0; i < compressedDNA.length(); i+=2) {
            String code = compressedDNA.substring(i, i+2);
            DNA.append(alphabet.charAt(Integer.parseInt(code, 2)));
        }
        return DNA.toString();
    }

    public static String compressBitstream(String bitstream)
    {
        StringBuilder compressedBitstream = new StringBuilder();
        int count = 0;
        int pos = 0;
        char bit;
        char lastBit = '0';    // always start with 0s
        boolean repeat = false;
        while (bitstream.length() > pos) {
            bit = bitstream.charAt(pos);
            if(bit != lastBit) {
                compressedBitstream.append(String.format("%2s", Integer.toHexString(count)).replace(' ', '0'));
                count = 0;
                lastBit = bit;
            }
            else  {
                if (count == 255)
                {
                    compressedBitstream.append(String.format("%2s", Integer.toHexString(count)).replace(' ', '0'));
                    count = 0;
                    compressedBitstream.append(String.format("%2s", Integer.toHexString(count)).replace(' ', '0'));
                }
            }
            count++;
            pos++;
        }
        compressedBitstream.append(String.format("%2s", Integer.toHexString(count)).replace(' ', '0'));
        return compressedBitstream.toString();
    }

    public static String expandBitstream(String compressedBitstream) {
        StringBuilder bitstream = new StringBuilder();
        String bit = "0";
        int pos = 0;
        while(compressedBitstream.length() > pos) {
            int count = Integer.parseInt(compressedBitstream.substring(pos, pos+2), 16);
            bitstream.append(bit.repeat(count));
            pos += 2;
            bit = (bit.equals("0")) ? "1" : "0";
        }
        return bitstream.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressDNA("ATAGATGCATAGCGCATAGCTAGATGTGCTAGCAT"));
        System.out.println(expandDNA("0011001000111001001100100110010011001001110010001110111001110010010011"));

        System.out.println(compressBitstream("0000000000000001111111000000011111111111"));
        System.out.println(expandBitstream("0f07070b"));
    }
}