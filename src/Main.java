import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        int chon;


        while (true) {
            System.out.println("1:hien thi");
            System.out.println("2:them");
            System.out.println("3:cap nhat");
            System.out.println("4:xoa");
            System.out.println("5:sap xep");
            System.out.println("6:san pham dat nhat");
            System.out.println("0:thoat");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    manager.hienthi();
                    break;
                case 2:
                    manager.them();
                    break;
                case 3:
                    manager.capnhat();
                    break;
                case 4:
                    manager.xoa();
                    break;
                case 5:
                    manager.sapxep();
                    break;
                case 6:
                   manager.spDatNhat();
                    break;
                case 7:
                    System.exit(0);


            }
        }

    }
}
