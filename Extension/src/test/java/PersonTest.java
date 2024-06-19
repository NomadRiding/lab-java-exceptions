package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setAge() {
        Person p = new Person(1, "John Doe", 30, "Software Developer");
        assertThrows(IllegalArgumentException.class, () -> p.setAge(-1));

    }
}