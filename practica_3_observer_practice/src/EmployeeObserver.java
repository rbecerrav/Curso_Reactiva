public class EmployeeObserver implements Observer {
    private String employeeName;


    public EmployeeObserver(String employeeName) {
        this.employeeName = employeeName;

    }

    @Override
    public void update(String name) {
        System.out.println(this.employeeName+" Se a agregado un nuevo empleado, su nombre: " + name);
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
