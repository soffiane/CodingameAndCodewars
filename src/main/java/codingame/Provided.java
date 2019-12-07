package codingame;

public class Provided {
    public static enum CategorieSocioProfessionnelle {
        Agriculteur,
        Artisan,
        Cadre,
        Employe,
        Ouvrier,
        Retraite
    };

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
