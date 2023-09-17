package com.example.assignment.api;

import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(params = "id")
    private String delete(String id){
        techLeadService.delete(id);
        return "Deleted!";
    }
}
