import java.util.Objects;

public class Sofkiano implements Observer{
    private String name;


    public Sofkiano(String name) {
        this.name = name;
    }

    @Override
    public void update(String param) {
        System.out.println(name + ": New podcast has been published, go to: " + param);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sofkiano{" +
                "name='" + name + '\'' +
                '}';
    }
}
