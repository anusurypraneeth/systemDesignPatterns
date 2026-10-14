import java.util.*;


interface Observer{
    void update(String message);
}

class MobileUser implements Observer{
    private String name;

    public MobileUser(String name){
        this.name=name;
    }

    @Override
    public void update(String message){
        System.out.println(name +" received (Mobile): "+messgae);
    }
}

class EmailUser implements Observer {
    private String email;

    public EmailUser(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println(email + " received (Email): " + message);
    }
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// ================= CONCRETE SUBJECT =================
class YouTubeChannel implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String latestVideo;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void uploadVideo(String title) {
        System.out.println("\n📢 New video uploaded: " + title);
        this.latestVideo = title;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update("New Video: " + latestVideo);
        }
    }
}

// ================= MAIN CLASS =================
public class ObserverDesign {
    public static void main(String[] args) {

        // Create Subject
        YouTubeChannel channel = new YouTubeChannel();

        // Create Observers
        Observer user1 = new MobileUser("Praneeth");
        Observer user2 = new EmailUser("user@gmail.com");

        // Subscribe
        channel.addObserver(user1);
        channel.addObserver(user2);

        // Trigger Event
        channel.uploadVideo("Observer Design Pattern Explained");

        // Unsubscribe one user
        channel.removeObserver(user1);

        // Trigger again
        channel.uploadVideo("Strategy Pattern Explained");
    }
}