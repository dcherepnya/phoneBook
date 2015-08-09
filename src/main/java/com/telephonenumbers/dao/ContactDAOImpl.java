package com.telephonenumbers.dao;

import com.telephonenumbers.domain.Contact;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dcherepnja on 08.08.2015.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public void delete(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
    }

    @Override
    public void update(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Contact findByAddress(String address) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Contact where address = :address");
        query.setParameter("address", address);

        return (Contact) query.uniqueResult();
    }

    @Override
    public Contact getContactById(int id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }
}
