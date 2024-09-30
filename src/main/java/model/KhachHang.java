package model;

/**
 *
 * Họ tên sinh viên: Dương Tự Lực
 */
public class KhachHang {

    private String maso;
    private String hoten;
    private int sonhankhau;
    private double chisocu;
    private double chisomoi;

    //constructor
    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int sonhankhau, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.sonhankhau = sonhankhau;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }

    //setter và getter
    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getSonhankhau() {
        return sonhankhau;
    }

    public void setSonhankhau(int sonhankhau) {
        this.sonhankhau = sonhankhau;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

    //phương thức tính toán    
    public double getTieuThu() {
        return chisomoi - chisocu;
    }

    public double getDinhMuc() {
        return sonhankhau * 4;
    }

    public double tinhTienTra() {
        double tieuThu = getTieuThu();
        double tienNuoc = 0;
        double dinhMuc = getDinhMuc();

        if (tieuThu <= dinhMuc) {
            tienNuoc = tieuThu * 6700;
        } else if (tieuThu <= dinhMuc + 2 * sonhankhau) {
            tienNuoc = dinhMuc * 6700 + (tieuThu - dinhMuc) * 12900;
        } else {
            tienNuoc= dinhMuc * 6700 +2 * sonhankhau * 12900 +(tieuThu - dinhMuc
                    -2 * sonhankhau) *14400;
        }
        //tinh thue GTGT, TDVTN
        tienNuoc += tienNuoc * 0.05 + tienNuoc * 0.25 + tienNuoc * 0.25 * 0.08;
        return tienNuoc;
    }
}
