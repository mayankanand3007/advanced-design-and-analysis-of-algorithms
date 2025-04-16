public class Main{
    public static void main(String[] args) {
        Exponential exp = new Exponential();
        int E,M,B;
        M = (int) Math.pow(2,62)-(int) Math.pow(1,16)-977;
        B = (int) Math.pow(2,33)-1301;
        E = (int) Math.pow(2,17)+(int) Math.pow(2,14)+(int) Math.pow(2,8)-7;
        long Result = exp.exponentiationMod(B, E, M);
        System.out.println("Result Value:"+Result);
    }
}