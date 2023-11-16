/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;

/**
 *
 * @author admin
 */
public class SinhVienService {

    List<SinhVien> listSinhViens;

    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    String sql = null;

    // Phương thức lấy dữ liệu trong bảng ra list
    public List<SinhVien> getAllSinhViens() {

        listSinhViens = new ArrayList<>();

        sql = "SELECT  id\n"
                + "      ,maSinhVien\n"
                + "      ,hoTen\n"
                + "      ,diemTrungBinh\n"
                + "      ,nganhHoc\n"
                + "      ,gioiTinh\n"
                + "  FROM sinhVien";

        try {

            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            // Lấy kết quả đẩy vào 1 1 tập kết quả
//           public SinhVien(long id, String maSinhVien, String ten, double diemTrungBinh, String nganh, int gioiTinh) 
            while (resultSet.next()) {

                SinhVien sinhVien;
                sinhVien = new SinhVien(
                        resultSet.getLong("id"),
                        resultSet.getString("maSinhVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getDouble("diemTrungBinh"),
                        resultSet.getString("nganhHoc"),
                        resultSet.getInt("gioiTinh")
                );
                listSinhViens.add(sinhVien);

            }

        } catch (Exception e) {
            // Lỗi
            e.printStackTrace(); // in ra toàn bộ lỗi

            return null;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listSinhViens;

        }

    }

    public int delete(String maSV) {
        int kq = 0;

        sql = "delete from sinhVien where maSinhVien like  ? ";
        try {
            connection = DBConnect.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maSV);
            kq = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            kq = 0;
        } finally {

            try {
                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return kq;
        }
    }

    public int insertSinhVien(SinhVien sinhVien) {
        int kq = 0;
        try {
            connection = DBConnect.getConnection();
            sql = "insert into sinhVien(maSinhVien,hoTen,diemTrungBinh,nganhHoc,gioiTinh) "
                    + " values(?,?, ?,?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sinhVien.getMaSinhVien());
            preparedStatement.setString(2, sinhVien.getTen());
            preparedStatement.setDouble(3, sinhVien.getDiemTrungBinh());
            preparedStatement.setString(4, sinhVien.getNganh());
            preparedStatement.setInt(5, sinhVien.getGioiTinh());

            kq = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally { // đóng kết nối
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return kq;
        }

    }

//    Up date sinh viên
    public int updateSinhVien(String maSv, SinhVien sinhVien) {
        int kq = 0;
        sql = "update sinhVien  set hoTen =?, diemTrungBinh =?, nganhHoc =? , gioiTinh =? where maSinhVien = ?";
        try {
            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sinhVien.getTen());

        } catch (Exception e) {

        } finally {

        }
        return 0;
    }

    public List<SinhVien> findSinhVienByTen(String ten) {

        listSinhViens = new ArrayList<>();

        sql = "select id, maSinhVien, hoTen, diemTrungBinh, nganhHoc, gioiTinh from sinhVien where sinhVien.hoTen like ? ";

        try {

            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + ten + "%");
            resultSet = preparedStatement.executeQuery();
            // Lấy kết quả đẩy vào 1 1 tập kết quả
//           public SinhVien(long id, String maSinhVien, String ten, double diemTrungBinh, String nganh, int gioiTinh) 
            while (resultSet.next()) {

                SinhVien sinhVien;
                sinhVien = new SinhVien(
                        resultSet.getLong("id"),
                        resultSet.getString("maSinhVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getDouble("diemTrungBinh"),
                        resultSet.getString("nganhHoc"),
                        resultSet.getInt("gioiTinh")
                );
                listSinhViens.add(sinhVien);

            }

        } catch (Exception e) {
            // Lỗi
            e.printStackTrace(); // in ra toàn bộ lỗi

            return null;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listSinhViens;

        }

    }

//       Tìm kiếm theo tên
    public List<SinhVien> findSinhVienByGioiTinh(int gt) {

        listSinhViens = new ArrayList<>();

        if (gt > 1) {
            sql = "select id, maSinhVien, hoTen, diemTrungBinh, nganhHoc, gioiTinh from sinhVien where sinhVien.gioiTinh != 0 and sinhVien.gioiTinh != 1  order by sinhVien.diemTrungBinh desc ";
        } else {
            sql = "select id, maSinhVien, hoTen, diemTrungBinh, nganhHoc, gioiTinh from sinhVien where sinhVien.gioiTinh = ? order by sinhVien.diemTrungBinh desc ";

        }

        try {

            connection = DBConnect.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (gt < 2) {
                  preparedStatement.setInt(1, gt);
            }
          
            resultSet = preparedStatement.executeQuery();
            // Lấy kết quả đẩy vào 1 1 tập kết quả
//           public SinhVien(long id, String maSinhVien, String ten, double diemTrungBinh, String nganh, int gioiTinh) 
            while (resultSet.next()) {

                SinhVien sinhVien;
                sinhVien = new SinhVien(
                        resultSet.getLong("id"),
                        resultSet.getString("maSinhVien"),
                        resultSet.getString("hoTen"),
                        resultSet.getDouble("diemTrungBinh"),
                        resultSet.getString("nganhHoc"),
                        resultSet.getInt("gioiTinh")
                );
                listSinhViens.add(sinhVien);

            }

        } catch (Exception e) {
            // Lỗi
            e.printStackTrace(); // in ra toàn bộ lỗi

            return null;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return listSinhViens;

        }

    }

    public static void main(String[] args) throws SQLException {
        SinhVienService sinhVienService = new SinhVienService();
        List<SinhVien> kq = sinhVienService.findSinhVienByGioiTinh(5);
        System.out.println(kq.size());

        for (SinhVien sinhVien : kq) {
            System.out.println(sinhVien.toString());
        }

    }

}
