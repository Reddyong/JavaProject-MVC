package org.example.view;

import org.example.controller.CustomerController;
import org.example.controller.MedicalRecordController;
import org.example.model.Customer;
import org.example.model.MedicalRecord;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private static MedicalRecordController medicalRecordController = new MedicalRecordController();
    private static CustomerController customerController = new CustomerController(medicalRecordController);
    private static Scanner scanner = new Scanner(System.in);

    public static String getPhoneNumber() {
        System.out.print("전화번호를 입력하세요 : ");

        return scanner.nextLine();
    }

    public static Customer getCustomerInfo() {
        System.out.println("신규 고객 정보를 입력하세요.");
        System.out.print("전화번호 : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("소유주 이름 : ");
        String name = scanner.nextLine();
        System.out.print("동물 이름 : ");
        String petName = scanner.nextLine();
        System.out.print("주소 : ");
        String address = scanner.nextLine();
        System.out.print("종류 : ");
        String petSpecies = scanner.nextLine();
        System.out.print("출생년도(yyyy) : ");
        String bornYear = scanner.nextLine();

        return new Customer(phoneNumber, name, petName, address, petSpecies, bornYear);
    }

    public static MedicalRecord getMedicalRecordInfo() {
        System.out.print("진료일을 입력하세요 : ");
        String date = scanner.nextLine();
        System.out.print("진료내용을 입력하세요 : ");
        String content = scanner.nextLine();

        return new MedicalRecord(null, date, content);
    }

    public static void printMedicalRecordInfo(Customer customer) {
        List<MedicalRecord> medicalRecords = customer.getMedicalRecords();
        System.out.println("[" + customer.getPetName() + "] 의 진료기록");
        for (MedicalRecord medicalRecord : medicalRecords) {
            System.out.println("-  진료일 : " + medicalRecord.getDate());
            System.out.println("   진료내용 : " + medicalRecord.getContent());
            System.out.println("   소유주 이름 : " + customer.getName());
            System.out.println("   동물 이름 : " + customer.getPetName());
            System.out.println("   주소 : " + customer.getAddress());
            System.out.println("   종류 : " + customer.getPetSpecies());
            System.out.println("   출생년도 : " + customer.getBornYear());
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printSelectAndProcedure() {
        while (true) {
            System.out.println("===애완동물진료관리시스템===");
            System.out.println("1. 신규 고객 정보 입력");
            System.out.println("2. 진료 기록 저장");
            System.out.println("3. 진료 기록 조회");
            System.out.println("4. 진료 기록 삭제");
            System.out.println("5. 종료");
            System.out.print("원하는 기능을 선택하세요 : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Customer customerInfo = getCustomerInfo();
                    String phoneNumber = customerInfo.getPhoneNumber();

                    if (customerController.isPhoneNumberExist(phoneNumber)) {
                        printMessage("이미 등록된 전화번호입니다.");
                        continue;
                    }

                    customerController.addCustomer(customerInfo);
                    printMessage("고객 정보가 추가 되었습니다.");
                    break;

                case 2:
                    phoneNumber = getPhoneNumber();

                    if (customerController.findCustomer(phoneNumber) == null) {
                        printMessage("등록된 회원이 없습니다.");
                        break;
                    }
                    Customer customer = customerController.findCustomer(phoneNumber);
                    MedicalRecord medicalRecordInfo = getMedicalRecordInfo();
                    medicalRecordInfo.setPhoneNumber(phoneNumber);
                    medicalRecordController.addMedicalRecord(medicalRecordInfo);
                    customer.setMedicalRecords(medicalRecordInfo);
                    printMessage("진료기록이 저장되었습니다.");
                    break;
                case 3:
                    phoneNumber = getPhoneNumber();
                    List<MedicalRecord> medicalRecords = medicalRecordController.findMedicalRecords(phoneNumber);

                    if (medicalRecords.isEmpty()) {
                        printMessage("해당 전화번호를 가진 진료 기록이 없습니다.");
                        break;
                    }
                    customer = customerController.findCustomer(phoneNumber);
                    printMedicalRecordInfo(customer);
                    break;
                case 4:
                    phoneNumber = getPhoneNumber();
                    if (customerController.findCustomer(phoneNumber) == null) {
                        printMessage("해당 전화번호를 가진 고객 정보가 없습니다.");
                        break;
                    }

                    medicalRecordController.removeMedicalRecord(phoneNumber);
                    printMessage("진료기록 정보가 삭제되었습니다.");
                    break;
                case 5:
                    printMessage("프로그램을 종료합니다.");
                    return;
                default:
                    printMessage("잘못된 선택입니다.");
                    break;
            }
        }
    }
}
