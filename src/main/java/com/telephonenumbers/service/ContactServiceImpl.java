package com.telephonenumbers.service;

import com.telephonenumbers.dao.ContactDAO;
import com.telephonenumbers.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by dcherepnja on 08.08.2015.
 */

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactDAO contactDAO;

    @Override
    public void add(Contact contact) {
        contactDAO.add(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactDAO.delete(contact);
    }

    @Override
    public void update(Contact contact) {
        contactDAO.update(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    public Contact findByAddress(String address) {
        return (Contact) contactDAO.findByAddress(address);
    }

    @Override
    public Contact getContactById(int id) {
        return contactDAO.getContactById(id);
    }

    @Override
    public void deleteById(int id) {
        Contact contact = contactDAO.getContactById(id);
        contactDAO.delete(contact);
    }
}
