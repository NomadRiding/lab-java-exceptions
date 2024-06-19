package org.example;

public class Main {
    public static void main(String[] args) {

                    PersonsList personList = new PersonsList();

                try{
                    personList.getList().add(new Person(1, "John Doe", 30, "Software Developer"));
                    personList.getList().add(new Person(2, "Jane Doe", 25, "Software Developer"));
                    personList.getList().add(new Person(3, "John Smith", 35, "Wifi Hacker"));

                    for(Person p : personList.getList()){
                        Person p1 = personList.findByName(p.getName());
                        System.out.println("Found: " + p1);

                        Person clonedPerson = personList.clone(p);
                        System.out.println("Cloned: " + clonedPerson);

                        personList.writePersonToFile(p);
                    }
                }
                catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }

   }
}
