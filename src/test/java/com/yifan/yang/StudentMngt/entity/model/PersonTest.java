package com.yifan.yang.StudentMngt.entity.model;

import com.yifan.yang.StudentMngt.entity.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    @DisplayName("Person fields are set correctly")
    void personFieldsAreSetCorrectly() {
        Date date = new Date();
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setGender("Male");
        person.setDateOfBirth(date);
        person.setEmail("john.doe@example.com");
        person.setTelephone("1234567890");
        person.setAddress("123 Street, City, Country");

        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals("Male", person.getGender());
        assertEquals(date, person.getDateOfBirth());
        assertEquals("john.doe@example.com", person.getEmail());
        assertEquals("1234567890", person.getTelephone());
        assertEquals("123 Street, City, Country", person.getAddress());
    }

    @Test
    @DisplayName("Person is created with correct fields")
    void personIsCreatedWithCorrectFields() {
        Date date = new Date();
        Person newPerson = new Person("Jane", "Doe", "Female", date, "jane.doe@example.com", "0987654321", "321 Street, City, Country");

        assertNotNull(newPerson);
        assertEquals("Jane", newPerson.getFirstName());
        assertEquals("Doe", newPerson.getLastName());
        assertEquals("Female", newPerson.getGender());
        assertEquals(date, newPerson.getDateOfBirth());
        assertEquals("jane.doe@example.com", newPerson.getEmail());
        assertEquals("0987654321", newPerson.getTelephone());
        assertEquals("321 Street, City, Country", newPerson.getAddress());
    }
}