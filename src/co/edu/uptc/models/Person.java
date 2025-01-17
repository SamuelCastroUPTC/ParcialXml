package src.co.edu.uptc.models;

public class Person {
    
    private int age;
    private String name;
    private String lastname;
    private int salary;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(){
        return "Name: "+this.name+" Apellido: "+this.lastname+" Edad: "+this.age+" Salario: "+this.salary;
    }

}
