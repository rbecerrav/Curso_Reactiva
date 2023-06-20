import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {


        SofkaU sofkau = new SofkaU();

        executeGame(sofkau);


    }

    private static void  executeGame(SofkaU sofkau) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("" +
                "1- suscribir sofkiano\n" +
                "2- desuscribir sofkiano \n" +
                "3- publicar podcast\n" +
                "8- Salir");
        int menuOption = sc.nextInt();

        switch (menuOption){
            case 1:
                System.out.println("Subscribir sofkiano");
                String nameToBeAdded = sc2.nextLine();

                Sofkiano sofkiano = new Sofkiano(nameToBeAdded);
                sofkau.addObserver(sofkiano);

                System.out.println("Sofkiano suscrito.");
                executeGame(sofkau);
                break;

            case 2:
                sofkau.getObservers().forEach(System.out::println);

                System.out.println("Desuscribir sofkiano");
                String nameToBeRemoved = sc2.nextLine();

                sofkau.removeByName(nameToBeRemoved);
                System.out.println("Sofkiano desuscrito.");
                executeGame(sofkau);
                break;

            case 3:
                System.out.println("Publicar Podcast");
                String link = sc2.nextLine();
                sofkau.addPodcast(link);
                executeGame(sofkau);
                break;
            case 8:
                System.out.println("Gracias por utilizar nuestro sistema!");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        sc.close();
        sc2.close();
    }
}