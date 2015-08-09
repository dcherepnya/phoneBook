package com.telephonenumbers.web;

import com.telephonenumbers.domain.Contact;
import com.telephonenumbers.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.TreeSet;

@Controller
public class MainController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "showAll", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "showAll";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage() {
        return "main";
    }

    @RequestMapping(value = "addPage", method = RequestMethod.GET)
    public String addContactPage() {
        return "addPage";
    }

    @RequestMapping(value = "findPage", method = RequestMethod.GET)
    public String findPage() {
        return "findPage";
    }

    @RequestMapping(value = "findForm", method = RequestMethod.POST)
    public String findContactNumbers(@RequestParam(value = "address", required = false) String address, ModelMap map) {
        Contact contact = contactService.findByAddress(address);
        if (contact != null) {
            map.addAttribute("contact", contact);
            return "contactPage";
        } else {
            map.addAttribute("message", "contact not found");
            return "findPage";
        }
    }

    @RequestMapping(value = "addFrom", method = RequestMethod.POST)
    public String addContact(@RequestParam(value = "address", required = false) String address,
                             @RequestParam(value = "number", required = false) String number,
                             ModelMap map) {
        String vAddress = address.trim();
        String vNumber = number.trim();
        if (!vAddress.matches("^(?!\\s*$).+")) {
            map.addAttribute("message", "Fill address shouldn't be emprty");
            return "addPage";
        }
        if (!vNumber.matches("\\+[0-9]{3,14}$")) {
            map.addAttribute("message", "wrong phone format. Use only numbers and +. For example +380995679376");
            return "addPage";
        }
        Contact persistContact = contactService.findByAddress(vAddress);
        if (persistContact == null) {
            Contact nContact = new Contact();
            nContact.setAddress(vAddress);
            nContact.setNumbers(new TreeSet<String>(Arrays.asList(vNumber)));
            contactService.add(nContact);
            map.addAttribute("contact", nContact);
            map.addAttribute("message", "contact have been edded");
        } else {
            persistContact.getNumbers().add(vNumber);
            contactService.update(persistContact);
            map.addAttribute("contact", persistContact);
            map.addAttribute("message", "number have been edded");
        }

        return "contactPage";
    }

    @RequestMapping(value = "showNumbers/{contactId}")
    public String showNumbers(@PathVariable("contactId") int contactId, ModelMap map) {
        Contact contact = contactService.getContactById(contactId);
        map.addAttribute("contact", contact);
        return "contactPage";
    }

    @RequestMapping(value = "deleteContact/{contactId}")
    public String deleteContact(@PathVariable("contactId") int contactId, ModelMap map) {
        contactService.deleteById(contactId);
        map.addAttribute("message", "Contact have been deleted");
        map.addAttribute("contacts", contactService.getAllContacts());
        return "showAll";
    }

    @RequestMapping(value = "deleteNumber/{contactId}&{number}")
    public String numberDelete(@PathVariable("number") String number,
                               @PathVariable("contactId") int id, ModelMap map) {
        Contact contact = contactService.getContactById(id);
        contact.getNumbers().remove(number.trim());
        contactService.update(contact);
        map.addAttribute("message", "number have been deleted");
        map.addAttribute("contact", contact);
        return "contactPage";
    }
}