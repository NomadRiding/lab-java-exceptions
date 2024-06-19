package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public boolean removePerson(Person person) {
        return persons.remove(person);
    }

    public List<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person findByName(String name) {
        validateNameFormat(name);
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private void validateNameFormat(String name) {
        String namePattern = "[A-Z][a-zA-Z]* [A-Z][a-zA-Z]*";
        if (!Pattern.matches(namePattern, name)) {
            throw new IllegalArgumentException("Name must be in the format 'FirstName LastName'");
        }
    }

    public Person clone(Person person, int newId) {
        return new Person(newId, person.getName(), person.getAge(), person.getOccupation());
    }

    public void writePersonToFile(Person person, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(person.toString());
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.err.println("Error closing file writer: " + e.getMessage());
                }
            }
        }
    }
}
