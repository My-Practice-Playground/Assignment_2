package com.example.assignment.api;

import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/techlead")
public class TechLeadController {
    @Autowired
    private TechLeadService techLeadService;
    @PostMapping
    private String save(@RequestBody TechLeadDto dto){
        techLeadService.save(dto);
        return "Saved!";
    }
}
