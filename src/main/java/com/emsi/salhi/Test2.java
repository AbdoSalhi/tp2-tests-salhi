package com.emsi.salhi;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test2Couts {
    public static void main(String[] args) {
        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(System.getenv("GEMINI_KEY"))
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        ChatResponse response = model.chat(UserMessage.from("Bonjour, comment ça va ?"));

        int tokensEntree = response.tokenUsage().inputTokenCount();
        int tokensSortie = response.tokenUsage().outputTokenCount();

        System.out.println(response.aiMessage().text());
        System.out.println("Tokens en entrée : " + tokensEntree);
        System.out.println("Tokens en sortie : " + tokensSortie);

        // A COMPLETER avec les prix de la page de l'énoncé pour gemini-3.5-flash-lite
        // (en dollars par MILLION de tokens)
        double prixEntree = 0.0;
        double prixSortie = 0.0;

        double cout = tokensEntree / 1_000_000.0 * prixEntree
                + tokensSortie / 1_000_000.0 * prixSortie;
        System.out.println("Coût de la requête : " + cout + " $");
        if (cout > 0) {
            System.out.println("Requêtes similaires pour dépenser 1 $ : " + (1 / cout));
        }
    }
}