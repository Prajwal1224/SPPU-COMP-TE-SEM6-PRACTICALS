import java.util.Scanner;

public class RedBusChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Welcome to RedBus Chat Support----\n");
        System.out.println("How can I assist you today? (Type 'bye' to exit)");

        while (true) {
            System.out.print("User: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println("Chatbot: Thank you for using RedBus. Have a safe journey! 🚌");
                break;
            }

            String response = getBotResponse(userInput);
            System.out.println("Chatbot: " + response);
        }

        scanner.close();
    }

    public static String getBotResponse(String userInput) {
        if (userInput.contains("book") || userInput.contains("ticket")) {
            return "You can book bus tickets by visiting our website or using the RedBus app. Where would you like to travel?";
        } else if (userInput.contains("available") || userInput.contains("buses")) {
            return "Please mention your source and destination to check available buses.";
        } else if (userInput.contains("cancel") || userInput.contains("cancellation")) {
            return "To cancel a booking, go to 'My Bookings' section on our website or app.";
        } else if (userInput.contains("refund")) {
            return "Refunds are processed within 5-7 business days after cancellation.";
        } else if (userInput.contains("support") || userInput.contains("contact")) {
            return "You can reach our 24x7 customer support at support@redbus.in or call 080-12345678.";
        } else if (userInput.contains("offers") || userInput.contains("discount")) {
            return "We offer discounts and promo codes on selected routes. Check the 'Offers' section on our website/app.";
        } else if (userInput.contains("luggage") || userInput.contains("baggage")) {
            return "Each passenger can carry up to 15kg of luggage. Please check bus-specific policies.";
        } else if (userInput.contains("seat") || userInput.contains("seating")) {
            return "You can choose your preferred seat during the booking process.";
        } else if (userInput.contains("payment") || userInput.contains("methods")) {
            return "We accept UPI, credit/debit cards, net banking, and wallets like Paytm and PhonePe.";
        } else {
            return "I'm sorry, I didn't understand. Could you please rephrase or ask another question?";
        }
    }
}
