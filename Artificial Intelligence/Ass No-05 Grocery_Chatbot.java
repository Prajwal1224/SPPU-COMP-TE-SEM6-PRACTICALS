import java.util.*;

public class GroceryBot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> priceList = new HashMap<>();
        Map<String, Integer> cart = new HashMap<>();

        // Item prices
        priceList.put("apple", 30);
        priceList.put("milk", 25);
        priceList.put("bread", 20);
        priceList.put("banana", 10);

        System.out.println("👋 Welcome to Simple Grocery Store!");
        System.out.println("You can order: apple, milk, bread, banana");
        System.out.println("Type 'bill' to see your bill or 'bye' to exit.");

        while (true) {
            System.out.print("\nYou: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("bye")) {
                System.out.println("Bot: Thanks for visiting! 👋");
                break;
            } else if (input.equals("bill")) {
                int total = 0;
                System.out.println("\n🧾 Your Bill:");
                for (String item : cart.keySet()) {
                    int qty = cart.get(item);
                    int price = priceList.get(item);
                    int cost = qty * price;
                    total += cost;
                    System.out.println(item + " x " + qty + " = ₹" + cost);
                }
                System.out.println("Total = ₹" + total);
            } else {
                // check if input contains known items
                boolean found = false;
                for (String item : priceList.keySet()) {
                    if (input.contains(item)) {
                        cart.put(item, cart.getOrDefault(item, 0) + 1);
                        System.out.println("Bot: Added 1 " + item + " to your cart.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Bot: Sorry, I didn't get that. Try 'apple', 'milk', 'bread', or 'banana'.");
                }
            }
        }
        scanner.close();
    }
}
