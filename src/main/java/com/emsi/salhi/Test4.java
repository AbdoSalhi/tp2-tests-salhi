package com.emsi.salhi;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

public class Test4 {

    static void comparer(EmbeddingModel model, String p1, String p2) {
        Embedding e1 = model.embed(p1).content();
        Embedding e2 = model.embed(p2).content();
        double similarite = CosineSimilarity.between(e1, e2);
        System.out.println(similarite + "  |  " + p1 + "  <->  " + p2);
    }

    public static void main(String[] args) {
        EmbeddingModel model = new BgeSmallEnV15EmbeddingModel();

        // Au moins 6 couples : similaires, opposés, sans rapport
        comparer(model, "Le chat dort sur le canapé.", "Un chat fait la sieste sur le sofa.");
        comparer(model, "Il fait très chaud aujourd'hui.", "Il fait très froid aujourd'hui.");
        comparer(model, "J'adore la pizza.", "La pizza est mon plat préféré.");
        comparer(model, "Je prends le train demain.", "La capitale de la France est Paris.");
        comparer(model, "Il pleut beaucoup à Rabat.", "Il y a beaucoup de pluie à Rabat.");
        comparer(model, "Cette voiture est rapide.", "Cette voiture est très lente.");
    }
}