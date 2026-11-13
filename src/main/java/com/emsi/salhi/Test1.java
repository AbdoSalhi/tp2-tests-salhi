package com.emsi.salhi;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {
    public static void main(String[] args) {
        String llmKey = System.getenv("GEMINI_KEY");
        if (llmKey == null) {
            System.out.println("La variable d'environnement GEMINI_KEY n'est pas définie.");
            return;
        }

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(llmKey)
                .modelName("gemini-3.5-flash")
                .temperature(0.7)
                .build();

        // Question simple
        System.out.println("== Question simple");
        System.out.println(model.chat("Bonjour, comment ça va ?"));

        // L'heure
        System.out.println("== Heure");
        System.out.println(model.chat("Quelle heure est-il ?"));

        // Deux questions successives
        System.out.println("== Question 1 : présentation");
        System.out.println(model.chat("Bonjour, je m'appelle <TON NOM>."));

        System.out.println("== Question 2 : mon nom");
        System.out.println(model.chat("Quel est mon nom ?"));
    }
}