package designpatterns.observer;

import java.util.Observable;

/**
 *
 * @author Migue
 */
public class NewsPublisher extends Observable{
    
    private String news;
    
    public void publish(String news){
        this.news = news;
        setChanged();
        notifyObservers();
    }
    
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();
        publisher.addObserver(new Suscriber());
        publisher.addObserver(new SMSSuscriber());
        publisher.publish("Todo será para mejor!");
    }

    public String getNews() {
        return news;
    }
    
}
