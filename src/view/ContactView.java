package view;

import vo.Contact;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ContactView {
    //private ContactService contactService = new ContactService();
    private final Scanner sc;

    public ContactView(Scanner sc) {
        this.sc = sc;
    }

    public void run(){
        while (true){
            System.out.println("1.추가  2.목록  3.수정  4.삭제  5.이름의 일부로 검색 -1:종료");
            int cmd = sc.nextInt();
            switch (cmd){
                case -1 :
                    return;
                case 1:
                    create();
                    break;
                case 2:
                    readAll();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    search();
                    break;
                default:
                    System.out.println("잘 못 입력 함.");
            }
        }
    }
    private void search(){
        System.out.println("[ContactView.search()]");
    }
    private void readAll() {
        //System.out.println("Read All");
        // 서비스에게 전체 데이터를 요청한다.
        System.out.println("[ContactView.readAll()]");
    }
    private void create(){
        // 처리 순서
        // 화면에서 이름과 전화번호를 입력받는다.
        // 입력받은 내용을 서비스에 전달한다.
        System.out.println("[ContactView.create()]");
    }
    private void update(){
        // 전체 리스트를 보여준다.
        //System.out.println("Update");
        // 1. 전체 리스트를 불러온다.
        System.out.println("[ContactView.update()]");
    }
    private void delete(){
        // System.out.println("Delete");
        // 1. 전체 리스트를 불러온다.
        System.out.println("[ContactView.delete()]");
    }

}
