package com.example.tp2inf1008;

import java.util.ArrayList;
import java.util.List;

public class JeuEchec {

    private int nbTotalTuplesPrometteurs;

    private int taille,nombreSolutions;
    private int[] colonnes,diagonales1,diagonales2;
    private int[][] plateau;

    private boolean toutesSolutions;

    private List<int[][]> solutions;

    // Constructeur de la classe
    public JeuEchec(int taille, boolean toutesSolutions) {
        this.taille = taille;
        this.nbTotalTuplesPrometteurs = 0;
        this.toutesSolutions = toutesSolutions;
        this.plateau = new int[taille][taille];

        this.colonnes = new int[taille];
        this.diagonales1 = new int[2*taille - 1];
        this.diagonales2 = new int[2*taille - 1];

        this.nombreSolutions = 0;
        this.solutions = new ArrayList<>();
    }

    // Méthode pour résoudre le jeu d'échecs
    public void resoudre() {
        resoudreRecursivement(0);
    }

    // Méthode récursive pour résoudre le jeu d'échecs
    private void resoudreRecursivement(int ligne) {
        if (ligne == taille) {
            int[][] solution = new int[taille][taille];
            for (int i = 0; i < taille; i++) {
                for (int j = 0; j < taille; j++) {

                    solution[i][j] = plateau[i][j];
                }
            }
            solutions.add(solution);
            nombreSolutions++;
            return;
        }
        for (int col = 0; col < taille; col++) {
            if (estSecuritaire(ligne, col)) {
                // Si la position est sécuritaire, on place la reine sur le plateau et on continue avec la ligne suivante
                placerReine(ligne, col);
                resoudreRecursivement(ligne+1);
                retirerReine(ligne, col);
            }
        }
    }

    // Méthode pour vérifier si la position est sécuritaire
    private boolean estSecuritaire(int ligne, int col) {
        nbTotalTuplesPrometteurs++;
        return colonnes[col] == 0
                && diagonales1[ligne+col] == 0
                && diagonales2[ligne-col+taille-1] == 0;
    }
    // Méthode pour placer une reine sur le plateau
    private void placerReine(int ligne, int col) {
        plateau[ligne][col] = 1;
        colonnes[col] = 1;
        diagonales1[ligne+col] = 1;
        diagonales2[ligne-col+taille-1] = 1;
    }

    // Méthode pour retirer une reine du plateau
    private void retirerReine(int ligne, int col) {
        plateau[ligne][col] = 0;
        colonnes[col] = 0;
        diagonales1[ligne+col] = 0;
        diagonales2[ligne-col+taille-1] = 0;
    }

    public int getNombreSolutions() {
        return nombreSolutions;
    }

    public List<int[][]> getSolutions() {
        return solutions;
    }

    public int[][] getPremiereSolution() {
        if (solutions.size() > 0) {
            return solutions.get(0);
        } else {
            return null;
        }
    }

    public int getNbTotalTuplesPrometteurs() {
        return nbTotalTuplesPrometteurs;
    }


}
