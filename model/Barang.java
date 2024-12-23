package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String namaBarang;

    @Column(nullable = false)
    private Integer stokBarang;

    @Column
    private String deskripsiBarang;

    @Column
    private String jenisBarang;

    @Column
    private Date tanggalKadaluarsa;

    @Column(nullable = false)
    private Float hargaBarang;

    public Barang() {}

    public Barang(String namaBarang, Integer stokBarang, String deskripsiBarang, String jenisBarang, Date tanggalKadaluarsa, Float hargaBarang) {
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
        this.deskripsiBarang = deskripsiBarang;
        this.jenisBarang = jenisBarang;
        this.tanggalKadaluarsa = tanggalKadaluarsa;
        this.hargaBarang = hargaBarang;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Integer getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(Integer stokBarang) {
        this.stokBarang = stokBarang;
    }

    public String getDeskripsiBarang() {
        return deskripsiBarang;
    }

    public void setDeskripsiBarang(String deskripsiBarang) {
        this.deskripsiBarang = deskripsiBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public Date getTanggalKadaluarsa() {
        return tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public Float getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Float hargaBarang) {
        this.hargaBarang = hargaBarang;
    }
}
