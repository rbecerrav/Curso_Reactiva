import java.util.List;

// sujeto concreto
public class SofkaU extends Subject{

    private String podcast;


    public void addPodcast(String link){

        this.podcast = link;

        System.out.println("New podcast added");

        this.notifiy();
    }

    public String getPodcast() {
        return podcast;
    }

    @Override
    public void notifiy() {
        observers.forEach(observer -> observer.update(this.podcast));
    }

    public void removeByName(String name){
        this.removeObserver(observers.stream()
                .filter(observer -> observer instanceof  Sofkiano && ((Sofkiano) observer).getName().equals(name))
                .findFirst()
                .get());
    }

}
