/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.model;

/**
 *
 * @author IVAN
 */
public class Barang {
    private int id;
    private String namaProduk;
    private int kategoriId;
    private double harga;
    private int stok;

    public Barang(int id, String namaProduk, int kategoriId, double harga, int stok) {
        this.id = id;
        this.namaProduk = namaProduk;
        this.kategoriId = kategoriId;
        this.harga = harga;
        this.stok = stok;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNamaProduk() { return namaProduk; }
    public void setNamaProduk(String namaProduk) { this.namaProduk = namaProduk; }

    public int getKategoriId() { return kategoriId; }
    public void setKategoriId(int kategoriId) { this.kategoriId = kategoriId; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
}
