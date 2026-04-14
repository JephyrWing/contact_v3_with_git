import view.ContactView;

import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactView contactView = new ContactView(sc);
        contactView.run();
    }
}
