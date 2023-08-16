package dev.aidasertovic.TextAnalyzer;

import dev.aidasertovic.TextAnalyzer.model.AnalysisOptionEnum;
import dev.aidasertovic.TextAnalyzer.model.AnalysisRequest;
import dev.aidasertovic.TextAnalyzer.model.AnalysisResponse;
import dev.aidasertovic.TextAnalyzer.repository.AnalyzerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TextAnalyzerApplicationTests {

    private final AnalyzerRepository repository = new AnalyzerRepository();

    @Test
    void itShouldReturnVowels() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, "It should return only vowels!");

        AnalysisResponse response  = repository.analyze(input);
        HashMap<Character, Integer> resultMap = new HashMap<>();
        resultMap.put('u',2);
        resultMap.put('e',2);
        resultMap.put('i',1);
        resultMap.put('o',3);

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnConsonants() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, "It should return only consonants!");

        AnalysisResponse response  = repository.analyze(input);
        HashMap<Character, Integer> resultMap = new HashMap<>();
        resultMap.put('t',3);
        resultMap.put('s',3);
        resultMap.put('h',1);
        resultMap.put('l',2);
        resultMap.put('d',1);
        resultMap.put('r',2);
        resultMap.put('n', 5);
        resultMap.put('y',1);
        resultMap.put('c',1);

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnVowelsAndConsonants() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.BOTH, "It should return vowels and consonants!");

        AnalysisResponse response  = repository.analyze(input);
        HashMap<Character, Integer> resultMap = new HashMap<>();
        resultMap.put('a',2);
        resultMap.put('e',2);
        resultMap.put('i',1);
        resultMap.put('t',3);
        resultMap.put('s',4);
        resultMap.put('h',1);
        resultMap.put('o',4);
        resultMap.put('u',2);
        resultMap.put('l',2);
        resultMap.put('d',2);
        resultMap.put('r',2);
        resultMap.put('n', 5);
        resultMap.put('v',1);
        resultMap.put('w',1);
        resultMap.put('c',1);

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyMapGivenNullInputTextAndVowelsOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, null);

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyMapGivenNullInputTextAndConsonantsOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, null);

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }
    @Test
    void itShouldReturnEmptyMapGivenNullInputTextAndBothOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.BOTH, null);

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyMapGivenEmptyInputTextAndVowelsOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, "");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }
    @Test
    void itShouldReturnEmptyMapGivenEmptyInputTextAndConsonantsOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, "");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }
    @Test
    void itShouldReturnEmptyMapGivenEmptyInputTextAndBothOption() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.BOTH, "");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenOnlyConsonantsAndOptionVowels() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, "RZTVHDFGWQ");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenOnlyVowelsAndOptionConsonants() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, "AEIOU");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenNonLettersAndOptionVowels() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, "12345678!/()=?!");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenNonLettersAndOptionConsonants() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, "12345678!/()=?!");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenNonLettersAndOptionBoth() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.BOTH, "12345678!/()=?!");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenOnlyWhiteSpacesAndOptionVowels() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.VOWELS, "   ");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenOnlyWhiteSpacesAndOptionConsonants() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.CONSONANTS, "   ");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }

    @Test
    void itShouldReturnEmptyResultGivenOnlyWhiteSpacesAndOptionBoth() {
        AnalysisRequest input = new AnalysisRequest(AnalysisOptionEnum.BOTH, "   ");

        AnalysisResponse response = repository.analyze(input);

        HashMap<Character, Integer> resultMap = new HashMap<>();

        assertEquals(response.result(), resultMap);
    }
}
