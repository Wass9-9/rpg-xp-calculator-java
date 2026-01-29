public class PlanetToolbox { // Classe PlanetToolbox
  public static boolean isSymmetric(int[][] travelTime) { 
    for (int i = 0; i < travelTime.length; i ++) { // On parcourt les lignes
      for (int j=0; j < travelTime[i].length; j ++) { // On parcourt les colonnes
        if (travelTime[i][j] != travelTime[j][i]) { // On vérifie l'égalité
          return false; // Pas symétrique
        }
      }
    }
    return true; // C'est symétrique
  }

  public static int nearestNeighbor(int[][] travelTime, int planetIndex) { 
    int bestCost = Integer.MAX_VALUE; // Grand nombre au départ
    int bestPlanet = -1; // Aucune planète trouvée

    for (int j =0; j < travelTime[planetIndex].length; j ++) { // Parcours de toutes les planètes
      int time = travelTime[planetIndex][j]; // Temps pour aller à la planète j
      if (j != planetIndex && time > 0 && time < bestCost) {
        bestCost = time; // Nouveau meilleur temps
        bestPlanet = j; // Nouvelle meilleure planète
      }
    }
    return bestPlanet; // Retourne l'indice de la planète la plus proche
  }
 
  // On teste avec main
  
  public static void main(String[] args) {
    int[][] travelTime = {
      {0, 3, 10, 7},
      {3, 0, 5, -1},
      {10, 5, 0, 2},
      {7, -1, 2, 0}
    };

    boolean sym = isSymmetric(travelTime);
    System.out.println("La matrice est-elle symétrique ? " + sym);
    if (!sym) {
      System.out.println("ERROR : n'est pas symétrique ! ");
    }

    System.out.println("Depuis planète 0 => plus proche : " + nearestNeighbor(travelTime, 0) + " (devrait être 1) ");
    System.out.println("Depuis planète 1 => plus proche : "  + nearestNeighbor(travelTime, 1) + " (devrait être 0) ");
    System.out.println("Depuis planète 2 => plus proche : "  + nearestNeighbor(travelTime, 2) + " (devrait être 3) ");
    System.out.println("Depuis planète 3 => plus proche : "  + nearestNeighbor(travelTime, 3) + " (devrait être 2) ");
  }
}




















  
    
    