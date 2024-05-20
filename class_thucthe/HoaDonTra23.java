/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package class_thucthe;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.Timer;


/**
 *
 * @author Admin
 */
public class HoaDonTra23 {
    private int maHoaDonTra;
    private KhachHang23 khachHang;
    private Date ngayTra;
    private Timer gioTra;
    private String ngayGioMuon;
    private String ngayGioTra;

    private NguoiDung23 nguoiLap;
    private List<TruyenMuon23>truyenTra = new ArrayList<>();
    private float tienThue;
    private float tienPhat;
    private float tongTien;

    public HoaDonTra23() {
    }

    public HoaDonTra23(int maHoaDonTra, KhachHang23 khachHang, Date ngayTra, Timer gioTra, String ngayGioMuon, String ngayGioTra, String tenKhachHang, NguoiDung23 nguoiLap, float tienThue, float tienPhat, float tongTien) {
        this.maHoaDonTra = maHoaDonTra;
        this.khachHang = khachHang;
        this.ngayTra = ngayTra;
        this.gioTra = gioTra;
        this.ngayGioMuon = ngayGioMuon;
        this.ngayGioTra = ngayGioTra;

        this.nguoiLap = nguoiLap;
        this.tienThue = tienThue;
        this.tienPhat = tienPhat;
        this.tongTien = tongTien;
    }

    public int getMaHoaDonTra() {
        return maHoaDonTra;
    }

    public void setMaHoaDonTra(int maHoaDonTra) {
        this.maHoaDonTra = maHoaDonTra;
    }

    public KhachHang23 getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang23 khachHang) {
        this.khachHang = khachHang;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Timer getGioTra() {
        return gioTra;
    }

    public void setGioTra(Timer gioTra) {
        this.gioTra = gioTra;
    }

    public String getNgayGioMuon() {
        return ngayGioMuon;
    }

    public void setNgayGioMuon(String ngayGioMuon) {
        this.ngayGioMuon = ngayGioMuon;
    }

    public String getNgayGioTra() {
        return ngayGioTra;
    }

    public void setNgayGioTra(String ngayGioTra) {
        this.ngayGioTra = ngayGioTra;
    }



    public NguoiDung23 getNguoiLap() {
        return nguoiLap;
    }

    public void setNguoiLap(NguoiDung23 nguoiLap) {
        this.nguoiLap = nguoiLap;
    }

    public List<TruyenMuon23> getTruyenTra() {
        return truyenTra;
    }

    public void setTruyenTra(List<TruyenMuon23> truyenTra) {
        this.truyenTra = truyenTra;
    }

    public float getTienThue() {
        return tienThue;
    }

    public void setTienThue(float tienThue) {
        this.tienThue = tienThue;
    }

    public float getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(float tienPhat) {
        this.tienPhat = tienPhat;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
}
