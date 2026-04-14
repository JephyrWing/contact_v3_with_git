import repository.ContactRepository;
import service.ContactService;
import state.ContactState;
import view.ContactView;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        ContactState state = new ContactState();
        ContactRepository repository = new ContactRepository(state);
        ContactService contactservice = new ContactService(state, repository);
        Scanner sc = new Scanner(System.in);
        ContactView contactView = new ContactView(contactservice, sc);
        contactView.run();
    }
}
