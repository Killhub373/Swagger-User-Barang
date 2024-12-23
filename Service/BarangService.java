package com.Service;

import com.exception.NotFoundException;
import com.model.Barang;
import com.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BarangService {

    @Autowired
    private BarangRepository barangRepository;

    public Barang add(Barang barang) {
        return barangRepository.save(barang);
    }

    public Barang getById(Long id) {
        return barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
    }

    public List<Barang> getAll() {
        return barangRepository.findAll();
    }

    public Barang edit(Long id, Barang barangDetails) {
        Barang update = barangRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNamaBarang(barangDetails.getNamaBarang());
        update.setStokBarang(barangDetails.getStokBarang());
        update.setDeskripsiBarang(barangDetails.getDeskripsiBarang());
        update.setJenisBarang(barangDetails.getJenisBarang());
        update.setTanggalKadaluarsa(barangDetails.getTanggalKadaluarsa());
        update.setHargaBarang(barangDetails.getHargaBarang());
        return barangRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id) {
        try {
            barangRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("Deleted", Boolean.TRUE);
            return res;
        } catch (Exception e) {
            return null;
        }
    }
}
