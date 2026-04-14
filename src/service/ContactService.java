package service;

import repository.ContactRepository;
import state.ContactState;
import vo.Contact;

import java.util.Map;

public class ContactService {
    private final ContactState state;
    private final ContactRepository repository;

    public ContactService(ContactState state, ContactRepository repository) {
        this.state = state;
        this.repository = repository;
    }

    public void insert(String name, int age, String phone) {
        System.out.println(("[ContactService.insert()]"));
        Contact contact = new Contact(state.getNextId(), name, age, phone);
        System.out.println(contact);
        //repository.ContactRepository.save()호출해서 store에 저장
        repository.save(state.getNextId(), contact);
        for (Long i : state.getStore().keySet()) {
            System.out.println(state.getStore().get(i));
        }
    }

    public Map<Long, Contact> findAll() {
        System.out.println(("[ContactService.findAll()]"));
        return repository.findAll();
    }
}
