package dev.aidasertovic.TextAnalyzer.model;

import java.util.HashMap;

public record AnalysisResponse(
        HashMap<Character, Integer> result
) {
}
