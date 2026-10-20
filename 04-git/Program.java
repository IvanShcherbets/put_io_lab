import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Użycie: java 04-git/Program.java liczba cena rabat");
            System.exit(1);
        }

        try {
            int quantity = Integer.parseInt(args[0]);
            double unitPrice = Double.parseDouble(args[1]);
            double discount = Double.parseDouble(args[2]);

            if (!Double.isFinite(unitPrice) || unitPrice < 0
                    || !Double.isFinite(discount) || discount < 0 || discount > 100) {
                System.err.println("Błąd: cena musi być nieujemna, a rabat od 0 do 100.");
                System.exit(1);
            }

            if (quantity < 0) {
                System.err.println("Błąd: liczba produktów nie może być ujemna.");
                System.exit(1);
            }
            double subtotal = quantity * unitPrice;
            double total = subtotal - discount;
            System.out.printf(Locale.ROOT, "Cena: %.2f%n", total);
        } catch (NumberFormatException e) {
            System.err.println("Błąd: podaj liczbę całkowitą produktów oraz liczbową cenę i rabat.");
            System.exit(1);
        }
    }
}
