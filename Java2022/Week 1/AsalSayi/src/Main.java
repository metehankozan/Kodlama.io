public class Main {

    public static void main(String[] args) {
        int number = 41;
        boolean isPrime = true;

        if (number == 1) {
            System.out.println("Asal Değil");
            return;
        } else if (number < 1) {
            System.out.println("Geçersiz Sayı");
            return;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime ? "Asal" : "Asal Değil");
    }
}
