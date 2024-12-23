package com.Service;

import com.model.Barang;
import java.util.Date;


public class BarangDetail {
    private Barang barang;

    public BarangDetail(Barang barang) {
        this.barang = barang;
    }

    public Long getId() {
        return barang.getId();
    }

    public String getNamaBarang() {
        return barang.getNamaBarang();
    }

    public Integer getStokBarang() {
        return barang.getStokBarang();
    }

    public String getDeskripsiBarang() {
        return barang.getDeskripsiBarang();
    }

    public String getJenisBarang() {
        return barang.getJenisBarang();
    }

    public Date getTanggalKadaluarsa() {
        return barang.getTanggalKadaluarsa();
    }

    public Float getHargaBarang() {
        return barang.getHargaBarang();
    }

    public static BarangDetail buildBarang(Barang barang) {
        return new BarangDetail(barang);
    }
}
