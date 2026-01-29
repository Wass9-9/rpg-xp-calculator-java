import java.util.ArrayList;
import java.util.HashMap;

public class RPGtoolbox {
  public static int xpToReachLevel(int n) { // Méthode pour calculer l'Xp total requise pour atteindre le niveau n
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return 100 * sum;
  }
  
  public static int currentLevel(int currentXP) { // Méthode qui doit déterminer le niveau actuel d'un personnage avec son Xp total
    int level = 0; // On commence au level 0
    while (xpToReachLevel(level + 1) <= currentXP) { // Tant que currentXP est >= aux Xp requis...
      level++; // Je monte d'un niveau.
    }
    return level; // Quand je n'ai plus assez d'Xp, je retourne à mon niveau.
  }

  public static int xpToReachNextLevel(int currentXP) { // Méthode
    int myCurrentLevel = currentLevel(currentXP); // Trouver le niveau actuel
    int xpForNextLevel = xpToReachLevel(myCurrentLevel + 1);// Mon niveau actuel + 1
    return xpForNextLevel - currentXP;
  }        
  public static int xpToReachLevelRecursive(int n) {
    if (n == 1) {
      return 100;
    } else {
        return (100 * n) + xpToReachLevelRecursive(n-1); 
      }
  }
  
  // Exercice 2

  public static void printXP(int[] xpArray) {
    for (int i = 0; i < xpArray.length; i ++) {
      System.out.println("Héros " + i + " : " + xpArray[i] + " xp ");
    }
  }

  public static int averageXP(int[] xpArray) {
    int sum = 0; // Initialisation de la somme
    for (int i = 0; i < xpArray.length; i ++) { // Boucle for
      sum += xpArray[i];
    }
    int moy = sum / xpArray.length; // Calcul de la moyenne
    return moy; // Valeur de la moyenne retournée
  }

  public static int indexOfMaxXP(int[] xpArray) {
    int maxIndex = 0; // Initialisation de l'index max
    int maxValue = xpArray[0]; // Initialisation de la valeur max
    
    for (int i = 0; i < xpArray.length; i ++) {
      if (xpArray[i] > maxValue) { // Boucle si strictement supérieur 
        maxValue = xpArray[i];
        maxIndex = i;
      }
    }
    return maxIndex; // Retourne l'indice
  }
 
  public static int countHeroesAtLeastLevel(int[] xpArray, int minLevel) { // Méthode comptant les héros avec un niveau minimum
    int cpt = 0; // Initialisation d'un compteur
    for (int i = 0; i < xpArray.length; i ++) { // Boucle pour tous les héros
      int level = currentLevel(xpArray[i]);  // Calcul niveau du héros i  
      if (level >= minLevel) {
        cpt++; // On ajoute  au compteur
      }
    }
    return cpt; // Retourne le total du compteur
  }

  // Exercice 4

  public static void addHero(ArrayList<String> team, String name) {
    if (team.contains(name)) {
      System.out.println("Warning : " + name + " is already in the team.");
    } else {
        team.add(name);
        System.out.println(name + " has been added to the team.");
    }
  }

  public static void removeHero(ArrayList<String> team, String name) {
    if (!team.contains(name)) { // Si name n'est pas dans la l'équipe
      System.out.println("Warning : impossible to remove " + name + ", this hero is not in the team.");
    } else {
        team.remove(name); // Retire de la liste
        System.out.println(name + " has been removed from the team.");
    }
  }

  public static void printTeam(ArrayList<String> team) {
    for (int i = 0; i <team.size(); i ++) {
      System.out.println(i + ". " + team.get(i));
    }
  }

  public static int teamSize(ArrayList<String> team) {
    return team.size(); // Retourne le nombre de héros
  }

  // Exercice 5
 
  public static void addEquipmentItem(HashMap<String, Integer> equipment, String name, int value, String typeLabel) {
    if (typeLabel.equals("attack")) { // On vérifie le type
      equipment.put(name, +value); // Stocke valeur positive
    } else if (typeLabel.equals("defense")) {
        equipment.put(name, -value); // Défense => valeur négative
    }
    else {
      System.out.println("Error : unknown type ' " + typeLabel + " ' "); // Type incorrect
      return;
    }
  }

  public static void removeEquipmentItem(HashMap<String, Integer> equipment, 
                                                              String name) {
    equipment.remove(name); // Supprime l'objet s'il existe
  }

  public static int getAttackBonus(HashMap<String, Integer> equipment) {
    int sum = 0; // On initialise la somme
    for (int value : equipment.values()) {
      if (value > 0) { // Si c'est un bonus d'attaque (+)
        sum += value; // On l'ajoute 
      }
    }
    return sum;
  }

  public static int getDefenseBonus(HashMap<String, Integer> equipment) {
    int sum = 0;
    for (int value : equipment.values()) {
      if (value < 0) { // Si c'est un bonus de défense (-)
        sum += value; // Valeur négative
      }
    }
    return sum;
  }

  

    
  

 public static void main(String[] args) {
   // Tests exercice 1

   System.out.println("XP pour atteindre le niveau 3 :" + xpToReachLevel(3));
  
   System.out.println("Niveau actuel pour 1500 XP :" + currentLevel(1500));
      
   System.out.println("XP manquant pour niveau suivant : " + xpToReachNextLevel(1500));
      
   System.out.println("Récursif - XP pour niveau 5 :" + xpToReachLevelRecursive(5));


  // Tests exercice 2

    int[] partyXP = {120, 350, 940, 50, 600}; // Les 5 héros et leurs XP
    printXP(partyXP);
    System.out.println("Affichage équipe : "); // Petit titre
    printXP(partyXP); // 5 lignes vont s'afficher
    System.out.println("\nXP moyenne : " + averageXP(partyXP)); // Affichage de la moyenne
    
    int theBest = indexOfMaxXP(partyXP);
    System.out.println("Meilleur héros (indice " + theBest + ") : " + partyXP[theBest] + " XP. "); // Affichage du meilleur héros

    System.out.println(countHeroesAtLeastLevel(partyXP, 3) + " héros ont niveau >= 3"); // On affiche combien de héros ont un niveau supérieur à 3

  // Test exercice 4

    ArrayList<String> team = new ArrayList<>(); // On crée une équipe pour le moment vide
    addHero(team, "Elliot"); // On ajoue des héros
    addHero(team, "Darlène");
    addHero(team, "Trenton");    
      
    System.out.println("\n Test addHero avec erreur :");
    addHero(team, "Elliot"); // Déjà dans l'équipe

    System.out.println("\n Test removeHero avec erreur :");
    removeHero(team, "Mr Robot"); // Ce héros n'existe pas

    System.out.println("\n Test removeHero :");
    removeHero(team, "Darlène");

    System.out.println("\n Test printTeam :");
    printTeam(team); 

    System.out.println("\n Test teamSize :");
    System.out.println("Taille de la team : " + teamSize(team));

    // Test exercice 5

    System.out.println("\n___ Elliot ___ ");
    HashMap<String, Integer> equipElliot = new HashMap<>(); // Création d'un équipement
  
    addEquipmentItem(equipElliot, "Clavier", 10, "attack");
    addEquipmentItem(equipElliot, "Hoodie", 5, "defense");
    addEquipmentItem(equipElliot, "Laptop", 15, "attack");
    addEquipmentItem(equipElliot, "Masque", 3, "defense");

    System.out.println("Attaque : " + getAttackBonus(equipElliot));
    System.out.println("Défense : " + getDefenseBonus(equipElliot));
  }



  
 

  
    

}