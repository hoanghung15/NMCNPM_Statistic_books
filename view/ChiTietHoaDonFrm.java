/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package view;
import class_thucthe.HoaDonTra23;
import dao.ThongKeTruyenMuonNhieuDAO23;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ChiTietHoaDonFrm extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    public ChiTietHoaDonFrm(){
    
    }

    public ChiTietHoaDonFrm(int maDauTruyen, String ngayBatDau, String ngayKetThuc) {
        setTitle("Thông Tin Hóa Đơn Trả Truyện");
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên Khách hàng");
        model.addColumn("Ngày, giờ mượn");
        model.addColumn("Ngày, giờ trả");
        model.addColumn("Tổng số tiền");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addDataToTable(maDauTruyen, ngayBatDau, ngayKetThuc);
    }

    private void addDataToTable(int maDauTruyen, String ngayBatDau, String ngayKetThuc) {
        ThongKeTruyenMuonNhieuDAO23 dao = new ThongKeTruyenMuonNhieuDAO23();
        ArrayList<HoaDonTra23> hoaDonList = dao.getDSHoaDon(maDauTruyen, java.sql.Date.valueOf(ngayBatDau), java.sql.Date.valueOf(ngayKetThuc));
        if(hoaDonList.size()==0){
            JOptionPane.showMessageDialog(this, "Khong co hoa don nao tra cho truyen nay!");
        }
        else{
            for (HoaDonTra23 hoaDon : hoaDonList) {
            model.addRow(new Object[]{
                    hoaDon.getMaHoaDonTra(),
                    hoaDon.getKhachHang().getHoTen(),
                    hoaDon.getNgayGioMuon(),
                    hoaDon.getNgayGioTra(),
                    hoaDon.getTongTien()
            });
        }
        }
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChiTietHoaDonFrm frame = new ChiTietHoaDonFrm();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        });
    }
}