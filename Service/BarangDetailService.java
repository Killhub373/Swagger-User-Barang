package com.Service;

import com.exception.NotFoundException;
import com.model.Barang;
import com.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BarangDetailService {

    @Autowired
    BarangRepository barangRepository;

    @Transactional
    public Barang getBarangByNama(String namaBarang) {
        return barangRepository.findByNamaBarang(namaBarang)
                .orElseThrow(() -> new NotFoundException("Barang Not Found with name: " + namaBarang));
    }

    @Transactional
    public boolean existsByNamaBarang(String namaBarang) {
        return barangRepository.existsByNamaBarang(namaBarang);
    }
}
