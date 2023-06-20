package com.ikm.citizen.controller;

import com.ikm.citizen.dto.CitizenDto;
import com.ikm.citizen.service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
    @Autowired
    CitizenService service;

    @PostMapping("/save")
    public ResponseEntity<String> save(CitizenDto citizenDto) throws ParseException {
        String result = service.save(citizenDto);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CitizenDto>> get(){
        List<CitizenDto> dtos = service.get();
        return ResponseEntity.ok().body(dtos);
    }
}
