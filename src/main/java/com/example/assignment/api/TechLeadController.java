package com.example.assignment.api;

import com.example.assignment.dto.ProjectDto;
import com.example.assignment.dto.TechLeadDto;
import com.example.assignment.service.TechLeadService;
import com.example.assignment.service.util.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/techlead")
public class TechLeadController {
    @Autowired
    private TechLeadService techLeadService;

    @PostMapping
    private String save(@RequestBody TechLeadDto dto) {
        try {
            if (dto == null) {
                return "Empty Tech lead details. Please check again!";
            } else if (!dto.id().matches("T\\d{3,}")) {
                return "Invalid ID type!";
            } else if (!dto.name().matches("^[A-Za-z-' ]+$")) {
                return "Invalid name";
            } else if (!String.valueOf(dto.salary()).matches("^-?\\d+(\\.\\d+)?$")) {
                return "Invalid salary record!";
            }
        } catch (NumberFormatException e) {
            return e.getMessage();
        }catch (RuntimeException e){
            return e.getMessage();
        }
        techLeadService.save(dto);
        return "Details successfully saved!";
    }

    @DeleteMapping(params = "id")
    private String delete(String id) {
        if (id == null) {
            return "Empty ID . Please check again!";
        } else if (id.matches("T\\d{3,}")) {
            return "Invalid Tech lead Id!";
        }
        try {
            techLeadService.delete(id);
            return "Successfully deleted!";
        } catch (ProjectNotFoundException e) {
            return "Tech lead does not exists!";
        } catch (RuntimeException e) {
            return e.getMessage();
        }

    }

    @GetMapping(params = "id")
    private String view(String id) {
        if (id == null) {
            return "Empty Tech lead details! ";
        } else if (!id.matches("T\\d{3,}")) {
            return "Invalid Tech lead id!";
        }
        try {
            TechLeadDto dto = techLeadService.view(id);
            return dto.toString();
        } catch (ProjectNotFoundException e) {
            return "Tech Lead does not exists! ";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @PutMapping
    private String update(@RequestBody TechLeadDto dto) {
        try {
            if (dto == null) {
                return "Empty Tech lead details. Please check again!";
            } else if (!dto.id().matches("T\\d{3,}")) {
                return "Invalid ID type!";
            } else if (!dto.name().matches("^[A-Za-z-' ]+$")) {
                return "Invalid name!";
            } else if (!String.valueOf(dto.salary()).matches("^-?\\d+(\\.\\d+)?$")) {
                return "Invalid salary record!";
            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        techLeadService.update(dto);
        return "Successfully updated!";
    }
}
