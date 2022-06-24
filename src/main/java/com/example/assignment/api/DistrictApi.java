package com.example.assignment.api;

import com.example.assignment.entity.District;
import com.example.assignment.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/districts")
public class DistrictApi {
    @Autowired
    DistrictService districtService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<District>> getList() {
        return ResponseEntity.ok(districtService.findAll());
    }



    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<District> optionalDistrict = districtService.findById(id);
        if (!optionalDistrict.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalDistrict.get());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<District> create(@RequestBody District district) {
        return ResponseEntity.ok(districtService.save(district));
    }


    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<District> update(@PathVariable Integer id, @RequestBody District district) {
        Optional<District> optionalDistrict = districtService.findById(id);
        if (!optionalDistrict.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        District existDistrict = optionalDistrict.get();
        // map object
        existDistrict.setName(district.getName());
        return ResponseEntity.ok(districtService.save(existDistrict));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!districtService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        districtService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
