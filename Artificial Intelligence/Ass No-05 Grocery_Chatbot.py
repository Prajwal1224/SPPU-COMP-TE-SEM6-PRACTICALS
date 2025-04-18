import re

def chatbot_response(user_input):
    user_input = user_input.lower()

    # A dictionary of regex patterns mapped to responses
    responses = {
        r"(hi|hello|hey)": 
            "Hello! Welcome to our Grocery store. How can I help you today?",
        
        r"(order status|track order)": 
            "Please provide your order ID to check the status.",
        
        r"(order|place order|buy)": 
            "Sure! What would you like to order? Fruits, vegetables, dairy, or something else?",
        
        r"(groceries|grocery items|items)": 
            "We offer a wide range of groceries: fruits, vegetables, dairy, snacks, and more.",
        
        r"(shipping time|delivery time)": 
            "We offer same-day delivery and standard shipping (3-5 business days).",
        
        r"(return policy|return item|how to return)": 
            "You can return items within 7 days if unopened. Need help with a return?",
        
        r"(milk)": 
            "Milk is 30rs per liter.",
        
        r"(eggs)": 
            "A dozen eggs cost 80rs.",
        
        r"(rice)": 
            "Rice is 50rs per kg.",
        
        r"(vegetables|veggies)": 
            "We have fresh vegetables available. Which ones are you looking for?",
        
        r"(fruits)": 
            "We have apples, bananas, and oranges in stock. Which one do you need?",
        
        r"(snacks)": 
            "We have chips, biscuits, and chocolates available.",
        
        r"(beverages|drinks|juice|water)": 
            "We have soft drinks, juices, and bottled water. What would you like?",
        
        r"(payment methods|payment options|how to pay)": 
            "We accept cash, credit/debit cards, and UPI payments.",
        
        r"(store hours|timing|opening hours)": 
            "Our store is open from 8 AM to 10 PM every day.",
        
        r"(location|address|where are you)": 
            "We are located at XYZ Market, Main Street, City.",
        
        r"(bye|exit|goodbye)": 
            "Goodbye! Happy shopping! 🛍️"
    }

    # Match user input against each pattern
    for pattern, response in responses.items():
        if re.search(pattern, user_input):
            return response

    # Fallback if no pattern matches
    return "I am sorry, I didn't understand that. Can you rephrase or ask about a specific grocery item?"

def main():
    print("🛒 Welcome to our Grocery Chatbot! Type 'exit' to end the conversation.")

    while True:
        user_message = input("You: ")
        
        if user_message.lower() in ["exit", "bye", "goodbye"]:
            print("Chatbot: Goodbye! Happy shopping! 🛍️")
            break

        response = chatbot_response(user_message)
        print("Chatbot:", response)

if __name__ == "__main__":
    main()
