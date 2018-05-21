package me.corey.permission;

public class Manager extends Employee {

    public Manager(){
        super("");
    }

    public Manager(String s){
//        super("");
    }

    public void sayHi() {
        super.sayHi();
        System.out.println("xxx");
    }

    public void hh() {
        super.sayHi();
        System.out.println("hh");
    }


    @Override
    protected String getTag() {
        return "xxx";
    }

    public static void main(String[] args) {
//        Manager manager = new Manager();
//        manager.sayHi();

//        Manager manager1 = (Manager) new Employee();

//        Employee employee = new Manager("");
//
//        employee.sayHi();
//
//        Manager m = (Manager) employee;
//        m.hh();

        Employee em = new Manager();
        System.out.println(em.getTag());
    }


}
