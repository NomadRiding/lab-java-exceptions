package org.example;

import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0 && age < 130){
            this.age = age;
        }else {
            System.out.println("Enter a valid age");
        }
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Person person = (Person) obj;

        if (age != person.age) {
            return false;
        }

        if (!Objects.equals(name, person.name)) {
            return false;
        }
        return occupation != null ? occupation.equals(person.occupation) : person.occupation == null;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "', age=" + age + ", occupation='" + occupation + "'}";
    }
}
