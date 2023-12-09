package com.example.tp2inf1008;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] PremiereSolution;// Initialisation de la variable qui contiendra la première solution trouvée
        JeuEchec jeuEchec;// Initialisation de l'objet jeuEchec
        boolean allSolutions = false;// Initialisation de la variable qui indique si on doit chercher toutes les solutions ou non
        int taille,NombresSolutions;

        while (true) {
            System.out.println("***** Menu *****");
            System.out.println("1. Trouver une solution possible");
            System.out.println("2. Trouver toutes les solutions possibles");
            System.out.println("3. Sortie");
            System.out.print("Entrez votre choix : ");

            int choix = scanner.nextInt();
            if (choix == 1) {// Si l'utilisateur choisit de trouver une seule solution
                System.out.print("Entrez la taille du plateau : ");
                taille = scanner.nextInt();
                jeuEchec = new JeuEchec(taille, false);// On crée un nouvel objet jeuEchec avec la taille du plateau et la variable allSolutions initialisée à false
                jeuEchec.resoudre();// On résoud le jeu d'échec
                NombresSolutions = jeuEchec.getNombreSolutions(); // On récupère le nombre de solutions trouvées
                PremiereSolution = jeuEchec.getPremiereSolution();// On récupère la première solution trouvée
                if (NombresSolutions == 0) {
                    System.out.println("Aucune solution trouvée.");
                } else {
                    System.out.println("Une solution trouvée :");
                    affichageSolution(PremiereSolution);// On affiche la première solution trouvée
                    System.out.println("Nombre de tuples k-prometteurs produits : " + NombresSolutions);// On affiche le nombre de tuples k-prometteurs produits
                    System.out.println("Nombre total de tuples k-prometteurs explorés : " + (NombresSolutions * taille)); // On affiche le nombre total de tuples k-prometteurs explorés
                }
            } else if (choix == 2) {// Si l'utilisateur choisit de trouver toutes les solutions possibles
                System.out.print("Entrez la taille du plateau : ");
                taille = scanner.nextInt();
                jeuEchec = new JeuEchec(taille, true); // On crée un nouvel objet jeuEchec avec la taille du plateau et la variable allSolutions initialisée à true
                jeuEchec.resoudre();// On résoud le jeu d'échec
                NombresSolutions = jeuEchec.getNombreSolutions();// On récupère le nombre de solutions trouvées
                if (NombresSolutions == 0) {
                    System.out.println("Aucune solution trouvée.");
                } else {
                    System.out.println("Toutes les solutions trouvées :");
                    for (int[][] solution : jeuEchec.getSolutions()) {// On parcourt toutes les solutions trouvées
                        affichageSolution(solution); // On affiche chaque solution trouvée
                        System.out.println();
                    }
                    System.out.println("Nombre de tuples k-prometteurs produits : " + NombresSolutions);
                    System.out.println("Nombre total de tuples k-prometteurs explorés : " + (NombresSolutions * taille));
                }
            } else if (choix == 3) {
                break;
            } else {
                System.out.println("Incorrect,entrer un nombre entre 1 et 3.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void affichageSolution(int[][] solution) {

        for (int i = 0; i < solution.length; i++) {

            for (int j = 0; j < solution[i].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
