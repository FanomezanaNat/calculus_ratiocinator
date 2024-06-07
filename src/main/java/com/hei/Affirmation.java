package com.hei;




public abstract sealed class Affirmation permits Véritée, Mensonge, Inconnue {
    private String texte;

    public Affirmation(String texte) {
        this.texte = texte;

    }

    public abstract String estVrai();

}
