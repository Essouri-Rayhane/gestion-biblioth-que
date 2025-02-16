
import java.time.LocalDate;
import java.util.Scanner;

public class TestCMD {

    public static void main(String[] args) {
        Bibliothecaire mybib = new Bibliothecaire();
        MenuPrincipale(mybib);
    }

    // Menu principal
    public static void MenuPrincipale(Bibliothecaire mybib) {
        boolean quitter = false;
        boolean retour = false;
        while (!quitter) {
            while (!retour) {

                clearScreen();
                System.out.println("\t\t ----------- Menu Principal -----------");
                System.out.println("1. Adhérents");
                System.out.println("2. Ouvrages");
                System.out.println("3. Emprunt ");
                System.out.println("4. Retour d'un ouvrage ");
                System.out.println("5. Quitter");
                System.out.print("Choisissez une option : ");

                int choix = lireEntier();
                System.out.println();

                switch (choix) {
                    case 1:
                        SousMenuAdherent(mybib);
                        break;
                    case 2:
                        SousMenuOuvrage(mybib);
                        break;
                    case 3:
                        SousMenuEmprunt(mybib);
                        break;
                    case 4:

                       
                        break;

                    case 5:
                        quitter = true;
                        System.out.println("Fermeture du programme...");
                        break;
                    default:
                        System.out.println("Option invalide, réessayez.");
                        AppuyezPourContinuer();
                }
            }
        }
    }

    // Sous-menu : Gestion des adhérents
    public static void SousMenuAdherent(Bibliothecaire mybib) {
        boolean retour = false;
        while (!retour) {
            clearScreen();
            System.out.println("\t\t ----------- Adhérents -----------");
            System.out.println("1. Inscription");
            System.out.println("2. Recherche adhérent");
            System.out.println("3. Retour");
            System.out.print("Choisissez une option : ");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    String cin = lireChaine("Numéro de carte d'identité : ");
                    String nom = lireChaine("Nom : ");
                    String prenom = lireChaine("Prénom : ");
                    Adherent adherent = new Adherent(Integer.parseInt(cin), nom, prenom);
                    mybib.inscrireAdherent(adherent);
                    System.out.println("Adhérent inscrit avec succès !");
                    AppuyezPourContinuer();
                    break;
                case 2:
                    cin = lireChaine("Numéro de carte d'identité : ");
                    mybib.rechercheAdherentbyCin(Integer.parseInt(cin));
                    AppuyezPourContinuer();
                    break;
                case 3:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide, réessayez.");
                    AppuyezPourContinuer();
            }
        }
    }

    // Sous-menu : Gestion des ouvrages
    public static void SousMenuOuvrage(Bibliothecaire mybib) {
        boolean retour = false;
        while (!retour) {
            clearScreen();
            System.out.println("\t\t ----------- Ouvrages -----------");
            System.out.println("1. Ajouter un ouvrage");
            System.out.println("2. Rechercher un ouvrage");
            System.out.println("3. Retour");
            System.out.print("Choisissez une option : ");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    SousMenuAjouter(mybib);
                    break;
                case 2:
                    String isbn = lireChaine("ISBN à rechercher : ");
                    Ouvrages ouvrage = mybib.rechercheOuvByIsdn(isbn);
                    if (ouvrage != null) {
                        System.out.println("Ouvrage trouvé : " + ouvrage);
                    } else {
                        System.out.println("Ouvrage introuvable.");
                    }
                    AppuyezPourContinuer();
                    break;
                case 3:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide, réessayez.");
                    AppuyezPourContinuer();
            }
        }
    }

    public static void SousMenuEmprunt(Bibliothecaire mybib) {
        boolean retour = false;
        String isbn, cin;
        while (!retour) {
            clearScreen();
            System.out.println("\t\t-- Emprunts --");
            System.out.println("1. Détails des emprunts");
            System.out.println("2. Emprunter un livre");
            System.out.println("3. Prolonger un prêt");
            System.out.println("4. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            int choix = new Scanner(System.in).nextInt();
            switch (choix) {
                case 1:
                    mybib.allemprunt();
                    AppuyezPourContinuer();
                    break;
                case 2:
                    cin = lireChaine("Identité de l'emprunteur: ");
                    isbn = lireChaine("ISBN du livre: ");
                    mybib.enregistrerPret(isbn, choix);
                    AppuyezPourContinuer();
                    break;
                case 3:
                    cin = lireChaine("Identité de l'emprunteur: ");
                    mybib.prolongerPret(Integer.parseInt(cin));
                    AppuyezPourContinuer();
                    break;
                case 4:
                    retour = true;
                    break;
            }
        }
    }

    // Sous-menu : Ajout d'ouvrages
    public static void SousMenuAjouter(Bibliothecaire mybib) {
        boolean retour = false;

        while (!retour) {
            clearScreen();
            System.out.println("\t\t ----------- Ajout d'Ouvrages -----------");
            System.out.println("1. Livre");
            System.out.println("2. Bande dessinée");
            System.out.println("3. Dictionnaire");
            System.out.println("4. Magazine");
            System.out.println("5. Retour");
            System.out.print("Choisissez une option : ");

            int choix = lireEntier();

            switch (choix) {
                case 1:
                    Ouvrages livre = creerLivre();
                    mybib.ajoutouvrage(livre);
                    System.out.println("Livre ajouté avec succès !");
                    AppuyezPourContinuer();
                    break;
                case 2:
                    Ouvrages bd = creerBandeDessinee();
                    mybib.ajoutouvrage(bd);
                    System.out.println("Bande dessinée ajoutée avec succès !");
                    AppuyezPourContinuer();
                    break;
                case 3:
                    Ouvrages dictionnaire = creerDictionnaire();
                    mybib.ajoutouvrage(dictionnaire);
                    System.out.println("Dictionnaire ajouté avec succès !");
                    AppuyezPourContinuer();
                    break;
                case 4:
                    Ouvrages magazine = creerMagazine();
                    mybib.ajoutouvrage(magazine);
                    System.out.println("Magazine ajouté avec succès !");
                    AppuyezPourContinuer();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option invalide, réessayez.");
                    AppuyezPourContinuer();
            }
        }
    }

    // Création d'un livre
    private static Livre creerLivre() {
        String auteur = lireChaine("Auteur : ");
        String genre = lireChaine("Genre : ");
        String titre = lireChaine("Titre : ");
        String isbn = lireChaine("ISBN : ");
        double prix = lireDouble("Prix : ");
        boolean bestSeller = lireBoolean("Est-ce un best-seller (true/false) ? ");
        int nbExemplaires = lireEntier("Nombre d'exemplaires : ");
        return new Livre(auteur, genre, titre, isbn, prix, bestSeller, nbExemplaires);
    }

    // Création d'une bande dessinée
    private static Bd creerBandeDessinee() {
        String titre = lireChaine("Titre : ");
        String isbn = lireChaine("ISBN : ");
        double prix = lireDouble("Prix : ");
        boolean bestSeller = lireBoolean("Est-ce un best-seller (true/false) ? ");
        int nbExemplaires = lireEntier("Nombre d'exemplaires : ");
        String illustrateur = lireChaine("Illustrateur : ");
        return new Bd(titre, isbn, prix, bestSeller, nbExemplaires, illustrateur);
    }

    // Création d'un dictionnaire
    private static Dict creerDictionnaire() {
        String titre = lireChaine("Titre : ");
        String isbn = lireChaine("ISBN : ");
        double prix = lireDouble("Prix : ");
        boolean bestSeller = lireBoolean("Est-ce un best-seller (true/false) ? ");
        int nbExemplaires = lireEntier("Nombre d'exemplaires : ");
        String langage = lireChaine("Langage : ");
        int nbMots = lireEntier("Nombre de mots : ");
        return new Dict(langage, nbMots, titre, isbn, prix, bestSeller, nbExemplaires);
    }

    // Création d'un magazine
    private static Magazine creerMagazine() {
        String titre = lireChaine("Titre : ");
        String isbn = lireChaine("ISBN : ");
        double prix = lireDouble("Prix : ");
        boolean bestSeller = lireBoolean("Est-ce un best-seller (true/false) ? ");
        int nbExemplaires = lireEntier("Nombre d'exemplaires : ");
        LocalDate publication = LocalDate.parse(lireChaine("Date de publication (YYYY-MM-DD) : "));
        return new Magazine(publication, titre, isbn, prix, bestSeller, nbExemplaires);
    }

    // Méthodes utilitaires
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String lireChaine(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

    public static int lireEntier() {
        return lireEntier(null);
    }

    public static int lireEntier(String message) {
        if (message != null) {
            System.out.print(message);
        }
        return new Scanner(System.in).nextInt();
    }

    public static double lireDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        while (true) {
            try {
                // Lire l'entrée utilisateur et convertir en double
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Veuillez entrer un nombre valide : ");
            }
        }
    }

    public static boolean lireBoolean(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextBoolean();
    }

    public static void AppuyezPourContinuer() {
        System.out.println("\nAppuyez sur Entrée pour continuer...");
        new Scanner(System.in).nextLine();
    }
}
