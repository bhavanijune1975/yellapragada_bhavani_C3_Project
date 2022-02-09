import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<Item> itemsInOrder = new ArrayList<Item>();
    int n;
    public String[] nameItem = new String[n];

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        LocalTime time = LocalTime.now();
        int value1 = openingTime.compareTo(time);
        int value2 = closingTime.compareTo(time);
        if (value1 < 0 && value2 > 0) {
            return true;
        } else {
            return false;
        }
    }

    public LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    public List<Item> getMenu() {
        ArrayList<String> listOfItems = new ArrayList<String>();
        return menu;

        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    private Item findItemByName(String itemName) {
        for (Item item : menu) {
            if (item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
    }

    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails() {
        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    public String getName() {
        return name;
    }

    public void addItemsToOrder(String name, int price) {
        Item orderedItem = new Item(name, price);
         itemsInOrder.add(orderedItem);
        //return itemsInOrder;

    }

    public int orderTotal(List<Item> items){
        int total=0;

        for (Item item : itemsInOrder){
            total=total+item.getPrice();
        }
        return total;
    }
}