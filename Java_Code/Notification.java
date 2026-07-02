import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
class Notify {
    String message;
    int weight;
    LocalDateTime time;
    boolean unread;
    Notify(String message, int weight, LocalDateTime time, boolean unread) {
        this.message = message;
        this.weight = weight;
        this.time = time;
        this.unread = unread;
    }
    double score() {
        long minutes = ChronoUnit.MINUTES.between(time, LocalDateTime.now());
        double recency = Math.max(0, 10000 - minutes);
        return weight * 1000 + recency;
    }
}
public class Notification {

    public static void main(String[] args) {
        ArrayList<Notify> al = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        al.add(new Notify("Event Participation", 10, now.minusHours(5), true));
        al.add(new Notify("Placement Drive Tomorrow", 30, now.minusMinutes(20), true));
        al.add(new Notify("Event Preparation", 15, now.minusHours(2), true));
        al.add(new Notify("Result Published", 20, now.minusMinutes(40), true));
        al.add(new Notify("Placement for Final Year", 40, now.minusMinutes(5), true));
        for (int i = 0; i < al.size() - 1; i++) {
            for (int j = i + 1; j < al.size(); j++) {
                if (al.get(i).score() < al.get(j).score()) {
                    Notify temp = al.get(i);
                    al.set(i, al.get(j));
                    al.set(j, temp);
                }
            }
        }
        System.out.println("Top Priority Notifications");
        int count = 0;
        for (Notify n : al) {
            if (n.unread) {
                System.out.println(n.message );
                count++;
            }
            if (count == 10)
                break;
        }
    }
}