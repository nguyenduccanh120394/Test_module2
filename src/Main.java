import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManagement fileManagement = new FileManagement();
        QuanLyDanhBa ql = new QuanLyDanhBa();
        Validate validate = new Validate();
        while (true){
            menu();
            int choice = -1;
            while (choice==-1){
                System.out.println("Enter choose");
                try {
                    choice= scanner.nextInt();
                    if (choice<=0||choice>7){
                        System.out.println("Enter 1 to 7");
                    }
                }catch (InputMismatchException exception){
                    System.out.println("Enter wrong data type");
                }finally {
                    scanner.nextLine();
                }
            }
            switch (choice){
                case 1:
                    System.out.println("Display List");
                    ql.disPlay();
                    break;
                case 2:
                    System.out.println("Add to List");
                    String phone;
                    do {
                        System.out.println("Enter phone 10-11:");
                        phone=scanner.nextLine();
                    }while (!validate.validate(phone, validate.PHONE));
                    System.out.println("Enter Group");
                    System.out.println("1. Family      2.Company     3.Friend");
                    String group = scanner.nextLine();
                    System.out.println("Enter name");
                    String name = scanner.nextLine();
                    System.out.println("Enter gender");
                    System.out.println("1.Male     2.Female");
                    String gender = scanner.nextLine();
                    System.out.println("Enter address");
                    String address = scanner.nextLine();
                    System.out.println("Enter Date of Birth ");
                    String date = scanner.nextLine();
                    String email;
                    do {
                        System.out.println("Enter email by Form xxx@xx.xxx");
                        email=scanner.nextLine();
                    }while (!validate.validate(email, validate.EMAIL));
                    DanhBa danhBas = new DanhBa(phone,group,name,gender,address,date,email);
                    ql.add(danhBas);
                    System.out.println("Add done!");
                    break;
                case 3:
                    System.out.println("Edit");
                    do {
                        System.out.println("Enter phone number u want edit");
                        phone = scanner.nextLine();
                        if (!ql.checkOnList(phone)){
                            System.out.println("Not Found");
                        }else if (phone.equals("")){
                            break;
                        }
                    }while (!ql.checkOnList(phone));
                    System.out.println("Enter Group");
                    System.out.println("1. Family      2.Company     3.Friend");
                    group = scanner.nextLine();
                    System.out.println("Enter name");
                    name = scanner.nextLine();
                    System.out.println("Enter gender");
                    System.out.println("1.Male     2.Female");
                    gender = scanner.nextLine();
                    System.out.println("Enter address");
                    address = scanner.nextLine();
                    System.out.println("Enter Date of Birth ");
                    date = scanner.nextLine();
                    do {
                        System.out.println("Enter email by Form xxx@xx.xxx");
                        email=scanner.nextLine();
                    }while (!validate.validate(email, validate.EMAIL));
                    DanhBa danhBa1 =new DanhBa(phone,group,name,gender,address,date,email);
                    ql.edit(danhBa1,phone);
                    System.out.println("Edit done");
                    break;
                case 4:
                    System.out.println("Delete");
                    do {
                        System.out.println("Enter phone number u want edit");
                        phone = scanner.nextLine();
                        if (!ql.checkOnList(phone)){
                            System.out.println("Not Found");
                        }else if (phone.equals("")){
                            break;
                        }
                    }while (!ql.checkOnList(phone));
                    System.out.println("Bạn có thật sự muốn xóa");
                    System.out.println("1.Ok         2.Cancel");
                    int option1=scanner.nextInt();
                    switch (option1){
                        case 1:
                            ql.delete(phone);
                            System.out.println("Delete Done!");
                            break;
                        case 2:
                            System.out.println("Hủy thành công");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Enter search by");
                    System.out.println("1. phone   2.name");
                    int option =scanner.nextInt();
                    switch (option){
                        case 1:
                            System.out.println("Enter phone u want search");
                            phone=scanner.nextLine();
                            List<DanhBa>list=ql.searchByPhone(phone);
                            for (int i = 0; i < list.size(); i++) {
                                System.out.println(list.get(i));
                            }
                            break;
                        case 2:
                            System.out.println("Enter name u want search");
                            name = scanner.nextLine();
                            List<DanhBa>list1= ql.searchByName(name);
                            for (int i = 0; i < list1.size(); i++) {
                                System.out.println(list1.get(i));
                            }
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Save");
                    fileManagement.writeToFile("data.csv", ql.getList());

                    break;
                case 7:
                    System.out.println("Read");
                    fileManagement.readFile("data.csv",ql.getList());
                    break;
            }
        }

    }
    public static void menu(){
        System.out.println("____MENU____");
        System.out.println("1.Display");
        System.out.println("2.Add");
        System.out.println("3.Edit");
        System.out.println("4.Delete");
        System.out.println("5.Search");
        System.out.println("6.Save to CSV File");
        System.out.println("7.Read from CSV File");
    }
}
