package repository;

import state.ContactState;
import vo.Contact;

public class ContactRepository {
    private final ContactState state;

    public ContactRepository(ContactState state) {
        this.state = state;
    }

    public void save(Long nextId, Contact contact) {
        state.getStore().put(nextId, contact);
        System.out.println("저장완료");
        state.Idincrement();
        System.out.println("Id 증가 완료");
    }
}
