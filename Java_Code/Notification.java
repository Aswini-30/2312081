import java.util.*;
class Notify{
    String message;
    int weight;
    Notify(String message,int weight){
        this.message=message;
        this.weight=weight;
    }
}
public class Notification {
    public static void main(String[] args){
        ArrayList<Notify> al=new ArrayList<>();
        al.add(new Notify("Event Participation",10));
        al.add(new Notify("Placement Drive Tomorrow",30));
        al.add(new Notify("Event preparation is going on",15));
        al.add(new Notify("Result was published today",20));
        al.add(new Notify("Placement is going for Final Year Student",40));
        for(int i=0;i<al.size()-1;i++){
            for(int j=i+1;j<al.size();j++){
                if(al.get(i).weight<al.get(j).weight){
                    Notify temp=al.get(i);
                    al.set(i,al.get(j));
                    al.set(j,temp);
                }
            }
        }
        System.out.println("Notification in Priority order");
        for(Notify i:al){
            System.out.println(i.message+" "+i.weight);
        }
    }
}
