package com.telephonenumbers.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by dcherepnja on 08.08.2015.
 */
@Entity
@Table
public class Contact {

    @Id
    @GeneratedValue
    private int id;

    private String address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "numbers", joinColumns = @JoinColumn(name = "contact_id"))
    private Set<String> numbers;

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address='" + address + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}
