/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SinhVien {
    
    private long id;
    
    private String maSinhVien;
    
    private String ten;
    
    private double diemTrungBinh;
    
    private String nganh;
    
    private int gioiTinh;

    public SinhVien() {
    }
    
    
    

    public SinhVien(long id, String maSinhVien, String ten, double diemTrungBinh, String nganh, int gioiTinh) {
        this.id = id;
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.diemTrungBinh = diemTrungBinh;
        this.nganh = nganh;
        this.gioiTinh = gioiTinh;
    }
    
    

    public SinhVien(String maSinhVien, String ten, double diemTrungBinh, String nganh, int gioiTinh) {
        this.maSinhVien = maSinhVien;
        this.ten = ten;
        this.diemTrungBinh = diemTrungBinh;
        this.nganh = nganh;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDiemTrungBinh() {
        return diemTrungBinh;
    }

    public void setDiemTrungBinh(double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    
    public Object[] toDataRow() {
        
        return new Object[] {
            this.id ,
            this.getMaSinhVien(),
            this.getTen(),
            this.getDiemTrungBinh(),
            this.getNganh(),
            this.getGioiTinh() == 0 ? "Nữ": this.getGioiTinh() == 1 ? "Nam" : "Kxd"
        };
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", maSinhVien=" + maSinhVien + ", ten=" + ten + ", diemTrungBinh=" + diemTrungBinh + ", nganh=" + nganh + ", gioiTinh=" + gioiTinh + '}';
    }
    
    
}
