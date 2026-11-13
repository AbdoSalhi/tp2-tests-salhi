package com.emsi.salhi;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;

import java.util.Map;

public class Test3Traducteur {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash")
                .temperature(0.7)
                .build();

        // Template avec 1 paramètre
        PromptTemplate template1 = PromptTemplate.from("Traduis le texte suivant en anglais : {{texte}}");
        Prompt prompt1 = template1.apply(Map.of("texte", "Bonjour, comment allez-vous ?"));
        System.out.println(model.chat(prompt1.text()));

        // Template avec 2 paramètres : langue de traduction et texte à traduire
        PromptTemplate template2 = PromptTemplate.from("Traduis le texte suivant en {{langue}} : {{texte}}");
        Prompt prompt2 = template2.apply(Map.of("langue", "espagnol", "texte", "Bonjour, comment allez-vous ?"));
        System.out.println(model.chat(prompt2.text()));
    }
}