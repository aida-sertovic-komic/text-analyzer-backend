package dev.aidasertovic.TextAnalyzer.model;

import jakarta.validation.constraints.NotBlank;

public record AnalysisRequest(
        AnalysisOptionEnum option,
        @NotBlank(message = "Input text must not be empty nor null!")
        String inputText
) {
}
