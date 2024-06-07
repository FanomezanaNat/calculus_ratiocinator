package com.hei;

import com.hei.conjonction.Conjonction;
import lombok.AllArgsConstructor;

import java.util.Set;


@AllArgsConstructor
public class CompostionAffirmation {
    private Set<Affirmation> affirmations;
    private Conjonction conjonction;

    public String estVrai() {
        var type = conjonction.getType();

        switch (type) {
            case Et:
                return affirmations.stream()
                        .map(Affirmation::estVrai)
                        .allMatch("vrai"::equals) ? "vrai" : "faux";
            case Ou:
                return affirmations.stream()
                        .map(Affirmation::estVrai)
                        .anyMatch("vrai"::equals) ? "vrai" : "faux";
            case Donc:
                if (affirmations.size() != 2) {
                    throw new IllegalArgumentException("La conjonction 'Donc' nécessite exactement deux affirmations.");
                }
                var iterator = affirmations.iterator();
                Affirmation first = iterator.next();
                Affirmation second = iterator.next();
                if ((first.estVrai().equals("vrai") && second.estVrai().equals("faux"))) {
                    return "faux";
                }
                return "vrai";

            default:
                throw new IllegalStateException("Type de conjonction inconnu: " + type);
        }
    }

    public String estVraiPlusieurAffirmation(String valeur, String valeur1, Conjonction conjonction) {
        if ((valeur.equals("vrai"))) {
            return "faux";
        }
        return "vrai";
    }

}


