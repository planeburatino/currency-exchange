import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        start();
    }

    static void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount in rubles (RUB):\nВведите сумму в рублях (RUB): ");
        int rubles = scanner.nextInt();
        System.out.println("Enter currency you want to convert this amount to (EUR/USD):\nВведите валюту, в которую вы хотите перевести эту сумму (EUR/USD): ");
        String currency = scanner.next();
        if(!currency.equals("EUR") &&  !currency.equals("USD")){
            System.out.println("Unsupported currency (expected EUR/USD)\nНеподдерживаемая валюта (ожидалось EUR/USD)");
            System.out.println("===============================");
            start();
        }
        String result = convert(rubles, currency);
        int dotIndex = result.indexOf(".");
        result = result.substring(0, dotIndex + 3);
        System.out.println("Your result/Ваш результат: " + result);
        System.out.println("===============================");
        start();
    }

    static String convert(int rubles, String currency){
        double euroExchangeRate = 92.95; // as for 04.11.2025
        double dollarExchangeRate = 80.90; // as for 04.11.2025
        switch(currency){
            case "EUR":
                return String.valueOf(rubles / euroExchangeRate);
            case "USD":
                return String.valueOf(rubles / dollarExchangeRate);
            default:
                return "Unsupported currency/Неподдерживаемая валюта";
        }
    }
}
