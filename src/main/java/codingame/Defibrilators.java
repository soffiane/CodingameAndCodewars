/**
 * La ville de Montpellier a équipé ses rues de défibrillateurs pour permettre de sauver
 * des victimes d'arrêts cardiaques. Les données correspondant à la position de
 * tous les défibrillateurs sont accessibles en ligne.
 * <p>
 * Sur la base des données fournies dans les tests, vous décidez d'écrire un programme
 * qui permettra aux usagers de trouver le défibrillateur le plus proche de là où ils se trouvent,
 * grâce à leur téléphone portable.
 * Règles
 * En entrée de votre programme sont fournies les données dont vous avez besoin, au format texte.
 * Ces données sont notamment composées de lignes dont chacune représente un défibrillateur.
 * Chaque défibrillateur est représenté par les champs suivants :
 * <p>
 * Numéro identifiant le défibrillateur
 * Nom
 * Adresse
 * Numéro de téléphone à joindre
 * Longitude (en degrés)
 * Latitude (en degrés)
 * Ces champs sont séparés par un point-virgule (;)
 * <p>
 * Attention : les nombres décimaux utilisent la virgule (,) comme séparateur pour la partie décimale.
 * Pensez à transformer la virgule (,) en point (.) si nécessaire
 * pour utiliser les données dans votre programme.
 * <p>
 * DISTANCE
 * ​La distance d entre deux points A et B sera calculée en utilisant la formule suivante :
 * <p>
 * <p>
 * ​
 * Note : Dans cette formule, les latitudes et longitu​des sont exprimées en radians.
 * 6371 correspond au rayon de la terre en km.
 * <p>
 * Le programme affichera le nom du défibrillateur se trouvant au plus près de la position de l'utilisateur.
 * Cette position est fournie en entrée au programme.
 * <p>
 * Entrées du jeu
 * Entrée
 * Ligne 1 : la longitude (en degrés) de l'utilisateur
 * <p>
 * Ligne 2 : la latitude (en degrés) de l'utilisateur
 * <p>
 * Ligne 3 le nombre N de défibrillateurs équipant les rues de Montpellier
 * <p>
 * N lignes suivantes : une description de chaque défibrillateur
 * <p>
 * Sortie
 * Le nom du défibrillateur le plus proche de la position de l'utilisateur.
 * Contraintes
 * 0 < N < 10000
 * Exemple
 * Entrée
 * 3,879483
 * 43,608177
 * 3
 * 1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217
 * 2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;;3,89652239197876;43,5987299452849
 * 3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;;3,87388031141133;43,6395872778854
 * Sortie
 * Maison de la Prevention Sante
 */
package codingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Defibrilators {

    public static void process(String fileName) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileName));
        String LON = in.next().replace(",", ".");
        String LAT = in.next().replace(",", ".");
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        List<Defibrilateur> defibs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Defibrilateur defibrilateur = new Defibrilateur();
            String[] informations = in.nextLine().split(";");
            defibrilateur.setNumeroIdentifiant(informations[0]);
            defibrilateur.setNom(informations[1]);
            defibrilateur.setAdresse(informations[2]);
            defibrilateur.setTelephone(informations[3]);
            defibrilateur.setLongitude(Double.valueOf(informations[4].replace(",", ".")));
            defibrilateur.setLatitude(Double.valueOf(informations[5].replace(",", ".")));
            defibs.add(defibrilateur);
        }

        System.out.println(defibs.stream().min(Comparator.comparing(defibrilateur -> defibrilateur.getDistanceWithUser(LON, LAT))).get().getNom());
    }

    public static void main(String... args) throws FileNotFoundException {
        process("src/main/ressources/codingameFile/Defibrilators/exemple.txt");
    }
}

class Defibrilateur {
    private String numeroIdentifiant;
    private String nom;
    private String adresse;
    private String telephone;
    private double longitude;
    private double latitude;

    public String getNumeroIdentifiant() {
        return numeroIdentifiant;
    }

    public void setNumeroIdentifiant(String numeroIdentifiant) {
        this.numeroIdentifiant = numeroIdentifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLongitudeInRadians() {
        return Math.toRadians(longitude);
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLatitudeInRadians() {
        return Math.toRadians(latitude);
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getDistanceWithUser(String lon, String lat) {
        double userLongitude = Math.toRadians(Double.valueOf(lon));
        double userLatitude = Math.toRadians(Double.valueOf(lat));

        double x = (this.getLongitudeInRadians() - userLongitude) * Math.cos((this.getLatitudeInRadians() + userLatitude) / 2);
        double y = this.getLatitudeInRadians() - userLatitude;
        return Math.sqrt((x * x) + (y * y)) * 6371;
    }

    /** solution sans la logique objet
     * public static void main(String args[])
     *     {
     *         Scanner in = new Scanner(System.in);
     *         double userLon = Double.parseDouble(in.next().replace(',','.'));
     *         double userLat = Double.parseDouble(in.next().replace(',','.'));
     *         int defibrillatorsCount = in.nextInt(); in.nextLine();
     *
     *         double earthRadius = 6371.0;
     *         String closestDef = "none";
     *         double closestDistance = Double.MAX_VALUE;
     *
     *         for (int i = 0; i < defibrillatorsCount; i++)
     *         {
     *             String[] def = in.nextLine().split("\\;");
     *             double defLon = Double.parseDouble(def[4].replace(',','.'));
     *             double defLat = Double.parseDouble(def[5].replace(',','.'));
     *             double x = (userLon-defLon)*Math.cos((userLat+defLat)*0.5);
     *             double y = userLat-defLat;
     *             double d = Math.sqrt(x*x+y*y) * earthRadius;
     *             if (d < closestDistance) {closestDistance = d;closestDef = def[1];}
     *         }
     *         System.out.println(closestDef);
     *     }
     */
}