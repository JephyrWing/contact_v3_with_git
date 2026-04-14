package repository;

import state.ContactState;
import vo.Contact;

import java.util.Map;

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

    public Map<Long, Contact> findAll() {
        if (state.getStore() == null) {
            System.out.println("저장된 자료가 없어요.");
            return null;
        }
        return state.getStore();
    }
}
