package com.bhozida.backend.controller;

import com.bhozida.backend.model.Opportunity;
import com.bhozida.backend.service.OpportunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class OpportunityController {

    private final String UPLOAD_DIR = "/code/uploads/";
    private OpportunityService opportunityService;

    public OpportunityController(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    @RequestMapping(path = "/opportunity/createOpportunity", method = RequestMethod.POST)
    public String addUpdateOpportunity(Opportunity opportunity, Model model) {
        opportunityService.addUpdate(opportunity);

        List<Opportunity> opportunities = opportunityService.findAll();
        model.addAttribute("opportunities", opportunities);
        return "opportunity/list";
    }

    @RequestMapping(path = {"/opportunity/edit", "/opportunity/edit/{id}"})
    public String editOpportunityById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Opportunity opportunity = opportunityService.findById(id.get());
            model.addAttribute("opportunity", opportunity);
        } else {
            model.addAttribute("opportunity", new Opportunity());
        }
        return "opportunity/add-edit";
    }

    @RequestMapping("/opportunity/view/{id}")
    public String showOpportunity(@PathVariable Long id, Model model) {
        Opportunity currentOpportunity = opportunityService.findById(id);
        model.addAttribute("opportunity", currentOpportunity);
        List<Opportunity> similarTypes = opportunityService.getSimilarType(id);
        similarTypes.remove(currentOpportunity);
        Collections.shuffle(similarTypes);
        model.addAttribute("similarTypes", similarTypes);
        return "opportunity/detail";
    }

    @RequestMapping({"/opportunity", "/opportunity/view", "/opportunity/list"})
    public String showOpportunities(Model model) {
        List<Opportunity> opportunities = opportunityService.findAll();
        model.addAttribute("opportunities", opportunities);
        return "opportunity/list";
    }

    @RequestMapping(path = "/opportunity/delete/{id}")
    public String deleteOpportunityById(Model model, @PathVariable("id") Long id) {
        opportunityService.deleteById(id);

        List<Opportunity> opportunities = opportunityService.findAll();
        model.addAttribute("opportunities", opportunities);
        return "opportunity/list";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "opportunity/list";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // save the file on the local file system
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "opportunity/list";
    }

}
