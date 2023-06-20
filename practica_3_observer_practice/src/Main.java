import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        employeesManagement(subject);
    }

    private static void employeesManagement(Subject subject) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("" +
                "1- Inscribir Gerente\n" +
                "2- Agregar empleado \n" +
                "3- Salir");
        int menuOption = sc.nextInt();

        switch (menuOption){
            case 1:
                System.out.println("Agregue nombre de gerente nuevo");
                String nameToBeAdded = sc2.nextLine();

                EmployeeObserver employee = new EmployeeObserver(nameToBeAdded);
                subject.addObserver(employee);

                System.out.println("Gerente inscrito.");

                employeesManagement(subject);
                break;

            case 2:
                System.out.println("Agregue nombre de empleado nuevo");
                String nameToBeAdded2 = sc2.nextLine();
                Employee newEmployee = new Employee(nameToBeAdded2);
                subject.addEmployee(newEmployee);
                employeesManagement(subject);
                break;

            case 3:
                System.out.println("Gracias por utilizar nuestro sistema!");
                break;
            default:
                System.out.println("Opción incorrecta");
        }
        sc.close();
        sc2.close();
    }
}