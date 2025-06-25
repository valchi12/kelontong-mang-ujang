/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.logic.admin;

import com.mycompany.toko_mangujang.model.Barang;
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
public class ManageBarang {
    
    
   private final Connection conn;
   public ManageBarang(Connection conn) {
       this.conn = conn;
   }
   
   public void tambahBarang(String namaProduk, int kategoriId, double harga, int stok) throws SQLException {
       String sql = "INSERT INTO produk (nama_produk, kategori_id, harga, stok) VALUES (?,?,?,?)";
       try (PreparedStatement stmt = conn.prepareStatement(sql)){
           stmt.setString(1, namaProduk);
           stmt.setInt(2, kategoriId);
           stmt.setDouble(3, harga);
           stmt.setInt(4, stok);
           stmt.executeUpdate();
       }
   }


    public List<Barang> getAllProduk() throws SQLException {
        List<Barang> produkList = new ArrayList<>();
        String sql = "SELECT * FROM produk";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produkList.add(new Barang(
                        rs.getInt("produk_id"),
                        rs.getString("nama_produk"),
                        rs.getInt("kategori_id"),
                        rs.getDouble("harga"),
                        rs.getInt("stok")));
            }
        }
        return produkList;
    }
    public void updateProduk(int id, String namaProduk, int kategoriId, double harga, int stok) throws SQLException {
        String sql = "UPDATE produk SET nama_produk = ?, kategori_id = ?, harga = ?, stok = ? WHERE produk_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, namaProduk);
            stmt.setInt(2, kategoriId);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }
  
    public void hapusProduk(int id) throws SQLException {
        String sql = "DELETE FROM produk WHERE produk_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

}

