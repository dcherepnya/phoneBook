package com.telephonenumbers.service;

import com.telephonenumbers.domain.Contact;

import java.util.List;

/**
 * Created by dcherepnja on 08.08.2015.
 */
public interface ContactService {

    public void add(Contact contact);

    public void delete(Contact contact);

    public void deleteById(int id);

    public void update(Contact contact);

    public List<Contact> getAllContacts();

    public Contact findByAddress(String address);

    public Contact getContactById(int id);
}
