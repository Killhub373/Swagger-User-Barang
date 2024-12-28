package com.Service;

import com.exception.BadRequestException;
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
        return barangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
    }

    public List<Barang> getAll() {
        List<Barang> barangs = barangRepository.findAll();
        if (barangs.isEmpty()) {
            throw new NotFoundException("No items found");
        }
        return barangs;
    }

    public Barang edit(Long id, Barang barangDetails) {
        Barang update = barangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));
        update.setNamaBarang(barangDetails.getNamaBarang());
        update.setStokBarang(barangDetails.getStokBarang());
        update.setDeskripsiBarang(barangDetails.getDeskripsiBarang());
        update.setJenisBarang(barangDetails.getJenisBarang());
        update.setTanggalKadaluarsa(barangDetails.getTanggalKadaluarsa());
        update.setHargaBarang(barangDetails.getHargaBarang());
        return barangRepository.save(update);
    }

    public Map<String, Boolean> delete(Long id) {
        System.out.println("Deleting product with id: " + id); // Logging
        try {
            barangRepository.deleteById(id);
            Map<String, Boolean> res = new HashMap<>();
            res.put("Deleted", Boolean.TRUE);
            System.out.println("Product with id: " + id + " deleted successfully.");
            return res;
        } catch (Exception e) {
            System.err.println("Error deleting product: " + e.getMessage()); // Log error
            Map<String, Boolean> res = new HashMap<>();
            res.put("Deleted", Boolean.FALSE);
            throw new BadRequestException("Error deleting product: " + e.getMessage());
        }
    }

    public Barang buyProduct(Long id, int quantity) {
        Barang barang = barangRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id Not Found"));

        Integer stokBarang = barang.getStokBarang();
        if (stokBarang < quantity) {
            throw new BadRequestException("Stock is not enough");
        }

        barang.setStokBarang(stokBarang - quantity);
        return barangRepository.save(barang);
    }
}
