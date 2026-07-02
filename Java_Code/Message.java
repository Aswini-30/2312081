
import java.util.*;
class Notifications {
    String message;
    int weight;
    Notifications(String message, int weight) {
        this.message = message;
        this.weight = weight;
    }
}
public class Message {
    public static void main(String[] args) {
        ArrayList<Notifications> list = new ArrayList<>();
        list.add(new Notifications("Event Participation", 10));
        list.add(new Notifications("Placement Drive Tomorrow", 30));
        list.add(new Notifications("Event preparation is going on", 15));
        list.add(new Notifications("Result was published today", 20));
        list.add(new Notifications("Placement is going for Final Year Student", 40));
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).weight < list.get(j).weight) {
                    Notifications temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("Notifications in Priority Order:");
        for (Notifications n : list) {
            System.out.println(n.message + " - Priority Weight: " + n.weight);
        }
    }
}