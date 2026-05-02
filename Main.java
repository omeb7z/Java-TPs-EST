import java.util.Scanner;
class Etudiant {
 private int ord;
 private String nom;
 private String prenom;
 private String date;
 private int cne;
 private double[] notes;
 // Constructeur initialisant le numéro d'ordre
Etudiant(int ord) {
 this.ord = ord;
 this.notes = new double[4];
 }
 // Méthode clavier()
String clavier() {
 Scanner sc = new Scanner(System.in);
 return sc.nextLine();
 }
 // Méthode lecture()
 void lecture() {
 Scanner sc = new Scanner(System.in);
 System.out.print("Nom : ");
 this.nom = sc.nextLine();
 System.out.print("Prénom : ");
 this.prenom = sc.nextLine();
 System.out.print("Date de naissance : ");
 this.date = sc.nextLine();
 System.out.print("CNE : ");
 this.cne = sc.nextInt();
 for (int i = 0; i < 4; i++) {
 System.out.print("Note module " + (i+1) + " : ");
 this.notes[i] = sc.nextDouble();
 }
 }
 // Calcul de la moyenne
 private double moyenne() {
 double somme = 0;
 for (double n : notes) somme += n;
 return somme / 4;
 }
 // Méthode affichage()
void affichage() {
 System.out.println("--- Etudiant N° " + ord + " ---");
 System.out.println("Nom : " + nom);
 System.out.println("Prénom : " + prenom);
 System.out.println("Date : " + date);
 System.out.println("CNE : " + cne);
 System.out.printf("Moyenne : %.2f%n", moyenne());
 }
 // Méthode Valide()
boolean Valide() {
 if (moyenne() < 10) return false;
 for (double n : notes)
 if (n < 7) return false;
 return true;
 }
double getMoyenne() { return moyenne(); }
}
class Etablissement {
 private int max;
 private Etudiant[] Tab;
 private int count;
 public Etablissement(int max) {
 this.max = max;
 this.Tab = new Etudiant[max];
 this.count = 0;
 }
int capacite() { return max; }
void ajoutetud(Etudiant e) {
 if (count < max) Tab[count++] = e;
 else System.out.println("Etablissement plein !");
 }
int size() { return count; }
 public void afficher() {
 for (int i = 0; i < count; i++)
 Tab[i].affichage();
 }
Etudiant[] etud_valide() {
 int nb = 0;
 for (int i = 0; i < count; i++)
 if (Tab[i].Valide()) nb++;
 Etudiant[] valides = new Etudiant[nb];
 int j = 0;
 for (int i = 0; i < count; i++)
 if (Tab[i].Valide()) valides[j++] = Tab[i];
 return valides;
 }
 void tri_affiche() {
 Etudiant[] valides = etud_valide();
 // Tri par moyenne décroissante (tri bulles)
 for (int i = 0; i < valides.length - 1; i++)
 for (int j = 0; j < valides.length - 1 - i; j++)
 if (valides[j].getMoyenne() < valides[j+1].getMoyenne()) {
 Etudiant tmp = valides[j];
 valides[j] = valides[j+1];
valides[j+1] = tmp;
 }
 System.out.println("=== Classement par ordre de mérite ===");
 for (Etudiant e : valides) {
 e.affichage();
 double moy = e.getMoyenne();
 String mention;
 if (moy < 12) mention = "Passable";
 else if (moy < 14) mention = "Assez bien";
 else if (moy < 16) mention = "Bien";
 else mention = "Très bien";
 System.out.println("Mention : " + mention);
 }
 }
}



public class Main {
 public static void main(String[] args) {
 // Test classe Etudiant
 Etudiant e1 = new Etudiant(1);
 e1.lecture();
 e1.affichage();
 System.out.println("Validé : " + e1.Valide());
 // Test classe Et
 Etablissement etab = new Etablissement(30);
 etab.ajoutetud(e1);
 Etudiant e2 = new Etudiant(2);
 e2.lecture();
 etab.ajoutetud(e2);
 System.out.println("Capacité : " + etab.capacite());
 System.out.println("Inscrits : " + etab.size());
 etab.afficher();
 etab.tri_affiche();
 }
}
