package dev.aidasertovic.TextAnalyzer.controller;

import dev.aidasertovic.TextAnalyzer.model.AnalysisRequest;
import dev.aidasertovic.TextAnalyzer.model.AnalysisResponse;
import dev.aidasertovic.TextAnalyzer.repository.AnalyzerRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class TextAnalyzerController {

    private final AnalyzerRepository repository;

    public TextAnalyzerController(AnalyzerRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public AnalysisResponse analyze(@Valid @RequestBody AnalysisRequest input) {
        return repository.analyze(input);
    }


}
