package org.example/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {

    @Test
    public void testSetAgeThrowsErrorForInvalidAge() {
        Person person = new Person(1, "John Doe", 25, "Engineer");
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> person.setAge(-5),
                "Expected setAge(-5) to throw, but it didn't"
        );
        assertTrue(thrown.getMessage().contains("Enter a valid age"));
    }


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class PersonsListTest {

        @Test
        public void testSetAgeThrowsErrorForInvalidAge() {
            Person person = new Person(1, "John Doe", 25, "Engineer");
            IllegalArgumentException thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> person.setAge(-5),
                    "Expected setAge(-5) to throw, but it didn't"
            );
            assertTrue(thrown.getMessage().contains("Enter a valid age"));
        }

        @Test
        public void testFindByNameReturnsCorrectPerson() {
            PersonsList personsList = new PersonsList();
            Person person1 = new Person(1, "Alice Smith", 30, "Doctor");
            Person person2 = new Person(2, "Bob Johnson", 25, "Engineer");
            personsList.addPerson(person1);
            personsList.addPerson(person2);

            Person foundPerson = personsList.findByName("Alice Smith");
            assertNotNull(foundPerson);
            assertEquals("Alice Smith", foundPerson.getName());
            assertEquals(30, foundPerson.getAge());
            assertEquals("Doctor", foundPerson.getOccupation());
        }

        @Test
        public void testFindByNameThrowsExceptionForInvalidFormat() {
            PersonsList personsList = new PersonsList();
            IllegalArgumentException thrown = assertThrows(
                    IllegalArgumentException.class,
                    () -> personsList.findByName("alicEsmith"),
                    "Expected findByName(\"alicEsmith\") to throw, but it didn't"
            );
            assertTrue(thrown.getMessage().contains("Name must be in the format 'FirstName LastName'"));
        }

        @Test
        public void testCloneCreatesNewPersonWithNewId() {
            Person person = new Person(1, "Alice Smith", 30, "Doctor");
            PersonsList personsList = new PersonsList();

            Person clonedPerson = personsList.clone(person, 2);

            // Validate that the cloned person has the same properties except the id
            assertEquals("Alice Smith", clonedPerson.getName());
            assertEquals(30, clonedPerson.getAge());
            assertEquals("Doctor", clonedPerson.getOccupation());
            assertEquals(2, clonedPerson.getId());

            // Ensure the original person is unchanged
            assertNotEquals(person.getId(), clonedPerson.getId());
        }
    }

}
