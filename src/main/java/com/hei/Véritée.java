package com.hei;

public final class Véritée extends Affirmation {
    public Véritée(String texte) {
        super(texte);
    }

    @Override
    public String estVrai() {
        return "vrai";
    }

}
