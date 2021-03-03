package com.test.month.controller;

import com.test.month.data.ValueDTO;
import com.test.month.service.FinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/finder")
public class MonthController {
    private final FinderService service;

    @GetMapping
    public ResponseEntity<String> defaultMethod() {
        return ResponseEntity.ok("Server works");
    }

    @PostMapping("/find")
    public List<ValueDTO> find(@RequestBody(required = false) String input) {
        return service.findResult(input);
    }

    @PutMapping("/edit")
    public void edit(@RequestBody ValueDTO input) {
        service.updatePosition(input);
    }

    @PostMapping("/create")
    public ValueDTO createNewPosition(@RequestBody String input) {
        return service.createNewPosition(input);
    }

    @DeleteMapping
    public boolean deletePosition(@RequestBody ValueDTO dto) {
        return service.deletePosition(dto);
    }
}
