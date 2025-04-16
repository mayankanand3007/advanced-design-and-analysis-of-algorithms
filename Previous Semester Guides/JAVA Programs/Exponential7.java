public class Exponential
{
    public long exponentiationMod(long base, long exponent, long modulus) {
        long result =1;
        if(exponent < 0) {
            System.out.println("Exponent should not be negative");
            System.exit(0);
        }
        try {
            base%=modulus;
            while(exponent > 0) {
                if((exponent & 1) == 1) {
                    result = result * base%modulus;
                }
                base = base * base%modulus;
                exponent >>= 1;
            }
        }
        catch(Exception e) {

        }
        return result;
    }
}

