public class Main {

    public static void main(String[] args) {
	// 220-284
        int number1 = 220;
        int number2 = 284;

        int total1 = 0, total2 = 0;

        for (int i = 1; i < number1; i++) {
            if(number1 % i == 0){
                total1 += i;
            }
        }

        for (int i = 1; i < number2; i++) {
            if(number2 % i == 0){
                total2 += i;
            }
        }

        System.out.println((number1 == total2 && number2 == total1) ? "Arkadaş Sayı" : "Arkadaş Sayı Değil");
    }
}
