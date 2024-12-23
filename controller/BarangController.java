package com.controller;

import com.Service.BarangService;
import com.exception.CommonResponse;
import com.exception.ResponseHelper;
import com.model.Barang;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/barang")
@CrossOrigin(origins = "*")
public class BarangController {

    @Autowired
    private BarangService barangService;

    @ApiOperation(value = "Add")
    @PostMapping("/add")
    public CommonResponse<Barang> createBarang(@RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.add(barang));
    }

    @ApiOperation(value = "Get")
    @GetMapping("/get/{id}")
    public CommonResponse<Barang> getBarangById(@PathVariable("id") Long id) {
        return ResponseHelper.ok(barangService.getById(id));
    }

    @ApiOperation(value = "GetAll")
    @GetMapping("/getAll")
    public CommonResponse<List<Barang>> getAllBarang() {
        return ResponseHelper.ok(barangService.getAll());
    }



    @ApiOperation(value = "Put")
    @PutMapping("/{id}")
    public CommonResponse<Barang> updateBarang(@PathVariable("id") Long id, @RequestBody Barang barang) {
        return ResponseHelper.ok(barangService.edit(id, barang));
    }

    @ApiOperation(value = "Delete")
    @DeleteMapping("/{id}")
    public CommonResponse<?> deleteBarang(@PathVariable("id") Long id) {
        return ResponseHelper.ok(barangService.delete(id));
    }


}
