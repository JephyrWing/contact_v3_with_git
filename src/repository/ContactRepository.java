package repository;

import state.ContactState;
import vo.Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactRepository {
    private final ContactState state;

    public ContactRepository(ContactState state) {
        this.state = state;
    }

    public void save(Long nextId, Contact contact) {
        System.out.println(("[ContactRepository.save()]"));
        state.getStore().put(nextId, contact);
        System.out.println("저장완료");
        state.Idincrement();
        System.out.println("Id 증가 완료");
    }

    public Map<Long, Contact> findAll() {
        System.out.println(("[ContactRepository.findAll()]"));
        if (state.getStore().size() == 0) {
            System.out.println("저장된 자료가 없어요.");
            return null;
        }
        return state.getStore();
    }

    public void delete(Long delId) {
        System.out.println("[ContactRepository.delete()]");
        state.getStore().remove(delId);
        System.out.println("삭제가 완료되었습니다.");
    }

    public boolean findById(Long delId) {
        System.out.println("[ContactRepository.findById()]");
        return state.getStore().containsKey(delId);
    }
    public Contact findById2(Long i) {
        System.out.println("[ContactRepository.findById2()]");
        return state.getStore().get(i);
    }

    public void update(Long updateId, Contact updatecontact) {
        System.out.println("[ContactRepository.update()]");
        state.getStore().put(updateId, updatecontact);
        System.out.println("수정 완료");
    }

    public Map<Long, Contact> search(String keyword) {
        Map<Long, Contact> result = new HashMap<>();
        for (Long key : state.getStore().keySet()) {
            if(state.getStore().get(key).getName().contains(keyword)) {
                result.put(key, state.getStore().get(key));
            }
        }
        return result;
    }
}
