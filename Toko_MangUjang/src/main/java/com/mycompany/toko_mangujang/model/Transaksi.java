/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.toko_mangujang.model;

import java.util.Date;

/**
 *
 * @author IVAN
 */
public class Transaksi {
    private int id;
    private Date tanggal;
    private int akunId;
    private double totalHarga;

    public Transaksi(int id, Date tanggal, int akunId, double totalHarga) {
        this.id = id;
        this.tanggal = tanggal;
        this.akunId = akunId;
        this.totalHarga = totalHarga;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getTanggal() { return tanggal; }
    public void setTanggal(Date tanggal) { this.tanggal = tanggal; }

    public int getAkunId() { return akunId; }
    public void setAkunId(int akunId) { this.akunId = akunId; }

    public double getTotalHarga() { return totalHarga; }
    public void setTotalHarga(double totalHarga) { this.totalHarga = totalHarga; }
}
