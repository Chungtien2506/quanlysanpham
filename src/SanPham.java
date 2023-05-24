public class SanPham {
    private  int maSp;
    private  String tenSp;
    private double gia;
    private int soLuong;

    public SanPham() {
    }

    public SanPham(int maSp, String tenSp, double gia, int soLuong) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSp=" + maSp +
                ", tenSp='" + tenSp + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                '}';
    }
}
