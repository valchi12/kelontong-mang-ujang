/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.logic.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author IVAN
 */
public class BeliBarang {
    private final Connection conn;

    public BeliBarang(Connection conn) {
        this.conn = conn;
    }

    public void buatTransaksi(int akunId, Map<Integer, Integer> produkDanJumlah) throws SQLException {
        // 1. Hitung total
        double total = 0;
        for (Map.Entry<Integer, Integer> entry : produkDanJumlah.entrySet()) {
            int produkId = entry.getKey();
            int jumlah = entry.getValue();
            double harga = getHargaProduk(produkId);
            total += harga * jumlah;
        }

        // 2. Simpan ke tabel transaksi
        String sqlTransaksi = "INSERT INTO transaksi (tanggal, akun_id, total_harga) VALUES (CURDATE(), ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sqlTransaksi, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, akunId);
            stmt.setDouble(2, total);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int transaksiId = rs.getInt(1);

                for (Map.Entry<Integer, Integer> entry : produkDanJumlah.entrySet()) {
                    int produkId = entry.getKey();
                    int jumlah = entry.getValue();
                    double harga = getHargaProduk(produkId);
                    simpanDetail(transaksiId, produkId, jumlah, harga);
                }
            }
        }
    }

    private void simpanDetail(int transaksiId, int produkId, int jumlah, double harga) throws SQLException {
        String sql = "INSERT INTO transaksi_detail (transaksi_id, produk_id, jumlah, harga_satuan, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, transaksiId);
            stmt.setInt(2, produkId);
            stmt.setInt(3, jumlah);
            stmt.setDouble(4, harga);
            stmt.setDouble(5, harga * jumlah);
            stmt.executeUpdate();
        }
    }

    private double getHargaProduk(int produkId) throws SQLException {
        String sql = "SELECT harga FROM produk WHERE produk_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produkId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("harga");
            }
        }
        return 0;
    }
}

