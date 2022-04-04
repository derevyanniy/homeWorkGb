package ru.gb.java_core1;

public class Person {
    private String name;
    private String position;
    private String Email;
    private String PhoneNumber;
    private int salary;
    private int age;

    public Person(String name, String position, String Email, String PhoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.salary = salary;
        this.age = age;
    }

   void printPeron() {
        System.out.printf(" Name: %s,\n Position: %s,\n Email: %s,\n PhoneNumber: %s,\n Salary: %s,\n Age: %s", name, position, Email, PhoneNumber, salary, age);
    }

    int getAge() {
       return this.age;
    }

    public static void main(String[] args) {
        Person first = new Person("Vasiliy Sergeevich Zdravin", "SeniorJavaDeveloper", "SeniorJava@mail.ru", "89116845566", 200000, 29 );
        // first.printPeron();

        Person[] staff = new Person[5];
        staff[0] = first;
        staff[1] = new Person("Petr Semenovich Gnezdov", "HR", "HR007@mail.ru", "89815608899", 120300, 41 );
        staff[2] = new Person("Elizaaveta Andreevna Bratova", "Manager", "ManagerTheBest@mail.ru", "89115903456", 76030, 33 );
        staff[3] = new Person("Semen Evgenievich Vasin", "Direktor", "DirektorTvoegoO@mail.ru", "89819938373", 130500, 46 );
        staff[4] = new Person("Dmitriy Viktorovych Zimin", "Trainee", "Junior228@mail.ru", "89062242356", 62300, 22 );

        for (int i = 0; i < staff.length; i++) {
            if(staff[i].getAge() > 40) {
                staff[i].printPeron();
            }
        }
    }
}
