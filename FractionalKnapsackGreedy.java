import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsackGreedy {
    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static double fractionalKnapsack(ArrayList<Item> items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Collections.sort(items, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.value / item1.weight;
                double ratio2 = (double) item2.value / item2.weight;
                return Double.compare(ratio2, ratio1);
            }
        });  

        double maxValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                // Add the entire item to the knapsack
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                // Add a fraction of the item to the knapsack
                double fraction = (double) capacity / item.weight;
                maxValue += fraction * item.value;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();

        ArrayList<Item> items = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter weight for item " + i + ": ");
            int weight = sc.nextInt();
            System.out.print("Enter value for item " + i + ": ");
            int value = sc.nextInt();
            items.add(new Item(weight, value));
        }

        System.out.print("Enter the knapsack capacity: ");
        int capacity = sc.nextInt();

        double maxValue = fractionalKnapsack(items, capacity);

        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
