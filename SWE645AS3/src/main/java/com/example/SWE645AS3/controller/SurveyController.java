package com.example.SWE645AS3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SWE645AS3.model.Survey;
import com.example.SWE645AS3.service.SurveyService;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    // Endpoint to create a new survey
    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
        Survey createdSurvey = surveyService.saveSurvey(survey);
        return ResponseEntity.ok(createdSurvey);
    }

    // Endpoint to retrieve all surveys
    @GetMapping("/list")
    public ResponseEntity<List<Survey>> getAllSurveys() {
        List<Survey> surveys = surveyService.getAllSurveys();
        return ResponseEntity.ok(surveys);
    }

    // Endpoint to retrieve a single survey by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable Long id) {
        return surveyService.getSurveyById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing survey
    @PutMapping("/update/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey survey) {
        if (!surveyService.getSurveyById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        survey.setId(id); // Ensure the ID is set to update the existing survey
        Survey updatedSurvey = surveyService.saveSurvey(survey);
        return ResponseEntity.ok(updatedSurvey);
    }

    // Endpoint to delete a survey
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Long id) {
        if (!surveyService.getSurveyById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        surveyService.deleteSurvey(id);
        return ResponseEntity.noContent().build();
    }
}
