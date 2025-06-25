/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.logic.admin;

import com.mycompany.toko_mangujang.model.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class ManageHistoriTransaksi {
      private final Connection conn;

    public ManageHistoriTransaksi(Connection conn) {
        this.conn = conn;
    }

    public List<Transaksi> getAllTransaksi() throws SQLException {
        List<Transaksi> list = new ArrayList<>();
        String sql = "SELECT * FROM transaksi";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Transaksi(
                        rs.getInt("transaksi_id"),
                        rs.getDate("tanggal"),
                        rs.getInt("akun_id"),
                        rs.getDouble("total_harga")));
            }
        }
        return list;
    }

    public Transaksi getTransaksiById(int id) throws SQLException {
        String sql = "SELECT * FROM transaksi WHERE transaksi_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Transaksi(
                        rs.getInt("transaksi_id"),
                        rs.getDate("tanggal"),
                        rs.getInt("akun_id"),
                        rs.getDouble("total_harga"));
            }
        }
        return null;
    }
}


