package com.telephonenumbers.dao;

import com.telephonenumbers.domain.Contact;

import java.util.List;

/**
 * Created by dcherepnja on 08.08.2015.
 */
public interface ContactDAO {

    public void add(Contact contact);

    public void delete(Contact contact);

    public void update(Contact contact);

    public List<Contact> getAllContacts();

    public Object findByAddress(String address);

    public Contact getContactById(int id);
}
