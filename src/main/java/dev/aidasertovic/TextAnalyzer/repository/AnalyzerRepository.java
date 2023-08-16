package dev.aidasertovic.TextAnalyzer.repository;

import dev.aidasertovic.TextAnalyzer.model.AnalysisOptionEnum;
import dev.aidasertovic.TextAnalyzer.model.AnalysisResponse;
import dev.aidasertovic.TextAnalyzer.model.AnalysisRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AnalyzerRepository {

    public AnalysisResponse analyze(AnalysisRequest input) {
        HashMap<Character, Integer> resultMap = new HashMap<>();

        if(input.inputText() == null || input.inputText().isBlank()) return new AnalysisResponse(resultMap);

        String text = input.inputText().toLowerCase().replaceAll("[^a-z]", "");

            if (input.option().equals(AnalysisOptionEnum.VOWELS)) {
                text = text.replaceAll("[^aeiou]", "");
            } else if (input.option().equals(AnalysisOptionEnum.CONSONANTS)) {
                text = text.replaceAll("[aeiou]", "");
            }


        for (char c:text.toCharArray()) {
            Integer num = 1;
            if(resultMap.containsKey(c)){
                num = resultMap.get(c);
                num++;
            }
            resultMap.put(c, num);

        }
        return new AnalysisResponse(resultMap);
    }
}
