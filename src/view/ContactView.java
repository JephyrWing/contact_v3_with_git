package view;

import service.ContactService;
import vo.Contact;

import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ContactView {
    private final ContactService service;
    private final Scanner sc;

    public ContactView(ContactService Service, Scanner sc) {
        this.service = Service;
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
        System.out.println("검색어 입력 : ");
        String keyword = sc.next();
        Map<Long, Contact> result = service.search(keyword);
        if(result.isEmpty()){
            System.out.println("검색 결과가 없어요.");
        } else {
            for (Long key : result.keySet()) {
                System.out.println(result.get(key));
            }
        }
    }
    private void readAll() {
        //System.out.println("Read All");
        // 서비스에게 전체 데이터를 요청한다.
        System.out.println("[ContactView.readAll()]");
        Map<Long,Contact> store = service.findAll();
        if (store != null) {
            for (Long i : store.keySet()) {
                System.out.println(store.get(i));
            }
        }
    }
    private void create(){
        System.out.println("[ContactView.create()]");
        // 처리 순서
        // 화면에서 이름과 전화번호를 입력받는다.
        // 입력받은 내용을 서비스에 전달한다.
        String name;
        int age;
        String phone;
        System.out.println("이름: ");
        name = sc.next();
        System.out.println("나이: ");
        age = sc.nextInt();
        System.out.println("전화번호: ");
        phone = sc.next();
        // 받은 값들을 service.contactservice.insert() 전달
        service.insert(name, age, phone);
    }
    private void update(){
        // 전체 리스트를 보여준다.
        //System.out.println("Update");
        // 1. 전체 리스트를 불러온다.
        System.out.println("[ContactView.update()]");
        System.out.println("수정할 아이디 입력: ");
        Long updateId = sc.nextLong();
        System.out.println("수정할 전화번호 입력: ");
        String updatePhone = sc.next();
        service.update(updateId, updatePhone);
    }
    private void delete(){
        // System.out.println("Delete");
        // 1. 전체 리스트를 불러온다.
        System.out.println("[ContactView.delete()]");
        System.out.println("삭제 아이디: ");
        Long delId = sc.nextLong();
        service.delete(delId);
    }

}
