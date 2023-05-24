import java.util.*;

public class Manager {
    List<SanPham> dssp = new ArrayList<>();

    public void hienthi() {
        dssp = ReadFile.read();
        if (dssp.isEmpty()) {
            System.out.println("Danh sách sản phẩm chưa có sản phẩm nào.");
        } else {
            for (SanPham sanPham : dssp) {
                System.out.println(sanPham);
            }
        }
    }

    public void them() {
        Scanner sc = new Scanner(System.in);
        dssp =ReadFile.read();
        System.out.println("nhap ma san pham");
        int maSp = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhap ten san pham");
        String tenSp = sc.nextLine();


        System.out.println("Nhap gia");
        double gia = sc.nextDouble();
        sc.nextLine();

        System.out.println("nhap so luong");
        int soLuong = sc.nextInt();

        SanPham sp = new SanPham(maSp, tenSp, gia, soLuong);
        dssp.add(sp);
        WirteFile.WriteFile((ArrayList<SanPham>) dssp);
    }

    public void capnhat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cần sửa:");
        int maSp = sc.nextInt();
        sc.nextLine();

        boolean timThay = false;

        while (!timThay) {
            for (SanPham sanPham : dssp) {
                if (sanPham.getMaSp() == maSp) {
                    System.out.println("Nhập tên sản phẩm:");
                    String tenSp1 = sc.nextLine();

                    System.out.println("Nhập giá:");
                    double gia1 = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Nhập số lượng:");
                    int soLuong1 = sc.nextInt();
                    sc.nextLine();

                    sanPham.setTenSp(tenSp1);
                    sanPham.setGia(gia1);
                    sanPham.setSoLuong(soLuong1);

                    timThay = true;
                    WirteFile.WriteFile((ArrayList<SanPham>) dssp);
                    break;
                }
            }

            if (!timThay) {
                System.out.println("Không tìm thấy sản phẩm với mã " + maSp);
                System.out.println("Nhập lại mã sản phẩm hoặc nhấn Enter để thoát:");
                String input = sc.nextLine();

                if (input.isEmpty()) {
                    break;
                } else {
                    maSp = Integer.parseInt(input);
                }
            }
        }
    }


    public void xoa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm muốn xoá:");
        int maSp = sc.nextInt();
        sc.nextLine();

        boolean timThay = false;

        while (!timThay) {
            SanPham spXoa = null;

            for (SanPham sanPham : dssp) {
                if (sanPham.getMaSp() == maSp) {
                    spXoa = sanPham;
                    break;
                }
            }

            if (spXoa != null) {
                System.out.println("Bạn có chắc chắn muốn xoá sản phẩm này? (Nhập Y để xác nhận):");
                String xacNhan = sc.nextLine();

                if (xacNhan.equalsIgnoreCase("Y")) {
                    dssp.remove(spXoa);
                    System.out.println("Đã xoá sản phẩm thành công.");
                } else {
                    System.out.println("Hủy xoá sản phẩm.");
                }

                timThay = true;
            } else {
                System.out.println("Không tìm được sản phẩm với mã " + maSp);
                System.out.println("Nhập lại mã sản phẩm hoặc nhấn Enter để thoát:");
                String input = sc.nextLine();

                if (input.isEmpty()) {
                    return;
                } else {
                    maSp = Integer.parseInt(input);
                }
            }
        }
        WirteFile.WriteFile((ArrayList<SanPham>) dssp);
    }
    public  void  sapxep(){

            Scanner sc = new Scanner(System.in);
            System.out.println("1. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("2. Hiển thị danh sách sau khi sắp xếp");
            System.out.println("3. Quay về menu chính");
            System.out.println("Chọn một tùy chọn:");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    Collections.sort(dssp, new Comparator<SanPham>() {
                        @Override
                        public int compare(SanPham sp1, SanPham sp2) {
                            return Double.compare(sp1.getGia(), sp2.getGia());
                        }
                    });
                    System.out.println("Sắp xếp thành công theo giá tăng dần.");
                    break;
                case 2:
                    Collections.sort(dssp, new Comparator<SanPham>() {
                        @Override
                        public int compare(SanPham sp1, SanPham sp2) {
                            return Double.compare(sp1.getGia(), sp2.getGia());
                        }
                    });
                    System.out.println("Danh sách sản phẩm sau khi sắp xếp:");
                    for (SanPham sanPham : dssp) {
                        System.out.println(sanPham);
                    }
                    break;
                case 3:
                    System.out.println("Quay về menu chính.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Quay về menu chính.");
                    return;
            }
        }
    public void spDatNhat() {
        if (dssp.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
            return;
        }

        SanPham spDatNhat = dssp.get(0); // Giả sử sản phẩm đầu tiên là sản phẩm có giá cao nhất

        for (SanPham sanPham : dssp) {
            if (sanPham.getGia() > spDatNhat.getGia()) {
                spDatNhat = sanPham; // Cập nhật sản phẩm có giá cao nhất
            }
        }

        System.out.println("Sản phẩm có giá cao nhất:");
        System.out.println(spDatNhat);
    }

}

