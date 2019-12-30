package codingame;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilePath {

    public List<Provided.Response> parseFile(Path inputFile) {
        List<Provided.Response> responses = new ArrayList<>();
        try {
            List<String> strings = readLinesFromFile(inputFile);
            for (String chaine : strings) {
                responses.add(parseLine(chaine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responses;
    }

    public List<String> readLinesFromFile(Path inputFile) throws IOException {
        return Files.lines(inputFile)
                .map(ligne -> ligne.split("\\s +")).flatMap(Arrays::stream)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public Provided.Response parseLine(String line) throws IllegalArgumentException {
        String[] valeurs = line.split(",");
        Provided.Response reponse = new Provided.Response();
        reponse.setId(Integer.valueOf(valeurs[0]));
        reponse.setNom(valeurs[1]);
        reponse.setPrenom(valeurs[2]);
        reponse.setAdresse(valeurs[3]);
        reponse.setCodePostal(valeurs[4]);
        reponse.setVille(valeurs[5]);
        reponse.setNbEnfants(Integer.valueOf(valeurs[6]));
        reponse.setCatSocioPro(Provided.CategorieSocioProfessionnelle.valueOf(valeurs[7]));
        reponse.setRevenu(Integer.valueOf(valeurs[8]));
        reponse.setProprietaire(Boolean.getBoolean(valeurs[9]));
        reponse.setMontantLoyer(Integer.valueOf(valeurs[10]));
        return reponse;
    }

    public static class Provided {
        public enum CategorieSocioProfessionnelle {
            Agriculteur,
            Artisan,
            Cadre,
            Employe,
            Ouvrier,
            Retraite
        }

        ;

        public static class Response {
            private int id;
            private String nom;
            private String prenom;
            private String adresse;
            private String codePostal;
            private String ville;
            private int nbEnfants;
            private CategorieSocioProfessionnelle catSocioPro;
            private Integer revenu;
            private boolean proprietaire;
            private Integer montantLoyer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNom() {
                return nom;
            }

            public void setNom(String nom) {
                this.nom = nom;
            }

            public String getPrenom() {
                return prenom;
            }

            public void setPrenom(String prenom) {
                this.prenom = prenom;
            }

            public String getAdresse() {
                return adresse;
            }

            public void setAdresse(String adresse) {
                this.adresse = adresse;
            }

            public String getCodePostal() {
                return codePostal;
            }

            public void setCodePostal(String codePostal) {
                this.codePostal = codePostal;
            }

            public String getVille() {
                return ville;
            }

            public void setVille(String ville) {
                this.ville = ville;
            }

            public int getNbEnfants() {
                return nbEnfants;
            }

            public void setNbEnfants(int nbEnfants) {
                this.nbEnfants = nbEnfants;
            }

            public CategorieSocioProfessionnelle getCatSocioPro() {
                return catSocioPro;
            }

            public void setCatSocioPro(CategorieSocioProfessionnelle catSocioPro) {
                this.catSocioPro = catSocioPro;
            }

            public Integer getRevenu() {
                return revenu;
            }

            public void setRevenu(Integer revenu) {
                this.revenu = revenu;
            }

            public boolean isProprietaire() {
                return proprietaire;
            }

            public void setProprietaire(boolean proprietaire) {
                this.proprietaire = proprietaire;
            }

            public Integer getMontantLoyer() {
                return montantLoyer;
            }

            public void setMontantLoyer(Integer montantLoyer) {
                this.montantLoyer = montantLoyer;
            }
        }
    }

}


