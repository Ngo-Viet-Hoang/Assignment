package com.example.assignment.api;

import com.example.assignment.entity.District;
import com.example.assignment.entity.Street;
import com.example.assignment.service.StreetService;
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
@RequestMapping("api/v1/streets")
public class StreetApi {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> getList() {
        return ResponseEntity.ok(streetService.findAll());
    }



    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Integer id) {
        Optional<Street> optionalStreet = streetService.findById(id);
        if (!optionalStreet.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalStreet.get());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> create(@RequestBody Street street) {
        return ResponseEntity.ok(streetService.save(street));
    }


    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Street> update(@PathVariable Integer id, @RequestBody Street street) {
        Optional<Street> optionalStreet = streetService.findById(id);
        if (!optionalStreet.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Street existStreet = optionalStreet.get();
        // map object
        existStreet.setName(street.getName());
        return ResponseEntity.ok(streetService.save(existStreet));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (!streetService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
