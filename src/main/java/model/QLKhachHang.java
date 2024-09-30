package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/**
 *
 * Họ tên sinh viên: Dương Tự Lực
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

   
    public void DocKhachHang(String filename) {
        ArrayList<String> data = FileHelper.readFileText(filename);
        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setSonhankhau(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));
            dsKhachHang.add(kh);
        }              
    }

    public boolean GhiHoaDon(String filename) {
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            double tieuThu = kh.getTieuThu();
            double amount = kh.tinhTienTra();
            
            String info = kh.getMaso() + ";" + 
                          kh.getHoten() + ";" + 
                          tieuThu + ";" + 
                          amount;
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);       
    }

    public double getTieuThuCaoNhat() {
        return 0;
    }

    public double getTieuThuThapNhat() {
        if (dsKhachHang.isEmpty()) {
            return 0;
        }
        double min = dsKhachHang.get(0).getTieuThu();
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTieuThu() < min) {
                min = kh.getTieuThu();
            }
        }
        return min;
    }

    public double getTieuThuTrungBinh() {
        if (dsKhachHang.isEmpty()) {
            return 0;
        }
        
        double total = 0;
        for (KhachHang kh : dsKhachHang) {
            total += kh.getTieuThu();
        }
        return total / dsKhachHang.size();
    }

    public void sapXepTheoMucTieuThu() {
        //sinh viên viết code 
         Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);
    }
}
