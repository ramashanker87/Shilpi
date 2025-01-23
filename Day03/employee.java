package com.rama.app;

public class Employee {
    String name;
    int age;
    String comp;
    String id;
    int salary;
    public Student(String name, int age, String comp, String id, int salary;) {
        this.name = name;
        this.age = age;
        this.comp = comp;
        this.id=id;
        this.salary=salary;
    }
}

public class EmployeeApp{
    public static void main(String[] args){
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee("Sita Ray", 35,"mnl","c123",35000));
        employeeList.add(new Employee("Raju Kumar", 25,"abc","c234",55000));
        employeeList.add(new Employee("Anjali Gupta", 28,"mnl","c112",60000));
        employeeList.add(new Employee("Aman Mishra", 30,"abc","c443",45000));

    System.out.println("Employees with salary>50000:");
    List<Employee> highSalEmp=employeeList.stream().filter(emp->emp.salary>50000).collect(Collectors.toList());
    highsalemp.forEach(System.out::println);

    System.out.println("\nEmployees with age<30:");
    List<Employee> youngEmployees=employeeList.stream().filter(emp->emp.age<30).collect(Collectors.toList());
    youngEmployees.forEach(System.out::println);

    System.out.println("\nEmployee Map:");
    Map<String, Employee> employeeMap=employeeList.stream().collect(Collectors.toMap(Employee))


    }
}

