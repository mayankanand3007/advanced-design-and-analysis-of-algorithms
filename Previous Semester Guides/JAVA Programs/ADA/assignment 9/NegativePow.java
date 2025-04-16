package adaa;


	public class NegativePow {
		public static long mod_power(long base, long exponent, long modulus) {
			long result =1;
			if(exponent <0) {
				System.out.println("Invalid");
			}
			else {
				base%=modulus;
				if(base == 0) {
					return 0;
				}
				while(exponent >0) {
					if((exponent & 1) == 1) {
						result = result * base%modulus;
					}
					exponent >>= 1;
					base = base * base%modulus;
				}
			}
			return result;
	}

	public static void main(String[] args){
		long ex,mo,ba;
		mo = (int) Math.pow(2,62)-(int) Math.pow(1,16)-977;
		ba = (int) Math.pow(2,33)-1301;
		ex = (int) Math.pow(2,17)+(int) Math.pow(2,14)+(int) Math.pow(2,8)-7;
		long expression = mod_power(ba,ex,mo);

		// Displaying the result
		System.out.println(expression);
	}
	}


