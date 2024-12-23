package com.repository;

import com.model.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

    Optional<Barang> findByNamaBarang(String namaBarang);
    boolean existsByNamaBarang(String namaBarang);
}
