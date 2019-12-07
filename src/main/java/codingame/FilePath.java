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
        List<String> lignes = Files.lines(inputFile)
                .map(ligne -> ligne.split("\\s +")).flatMap(Arrays::stream)
                .map(String::valueOf)
                .collect(Collectors.toList());
        return lignes;
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

}


