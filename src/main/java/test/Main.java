package test;

import model.Tournoi;
import model.Participation;
import service.TournoiService;
import service.ParticipationService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
       /* // Add a new tournoi
        Tournoi t = new Tournoi("Tournoi A", "Description du tournoi", 10, new java.util.Date(), "Trophée A");
        TournoiService tournoiService = new TournoiService();

        // Adding a tournament
        tournoiService.add(t);
        System.out.println("Tournoi ajouté");

        // Display all tournois
        System.out.println("\nListe de tous les tournois:");
        List<Tournoi> tournois = tournoiService.display();
        for (Tournoi t1 : tournois) {
            System.out.println(t1.getIdTournoi() + " - " + t1.getTitre() + " - " + t1.getDescription());
        }

        // Deleting a tournoi
        tournoiService.delete(4);
        System.out.println("\nTournoi avec l'ID 4 supprimé.");

        // Display all tournois after deletion
        System.out.println("\nListe de tous les tournois après suppression:");
        List<Tournoi> tournois2 = tournoiService.display();
        for (Tournoi t2 : tournois2) {
            System.out.println(t2.getIdTournoi() + " - " + t2.getTitre() + " - " + t2.getDescription() + " - " + t2.getNbr());
        }*/

        // Add a new participation
        Participation p = new Participation(1, 1, "Débutant", 5);  // Example IDs for the tournament and user
        ParticipationService participationService = new ParticipationService();

        // Adding a participation
        participationService.add(p);
        System.out.println("\nParticipation ajoutée");

        // Display all participations
        System.out.println("\nListe de toutes les participations:");
        List<Participation> participations = participationService.display();
        for (Participation p1 : participations) {
            System.out.println(p1.getIdParticipation() + " - " + p1.getIdTournoi() + " - " + p1.getIdUtilisateur() + " - " + p1.getNiveau());
        }

        // Deleting a participation
        participationService.delete(2);
        System.out.println("\nParticipation avec l'ID 2 supprimée.");

        // Display all participations after deletion
        System.out.println("\nListe de toutes les participations après suppression:");
        List<Participation> participations2 = participationService.display();
        for (Participation p2 : participations2) {
            System.out.println(p2.getIdParticipation() + " - " + p2.getIdTournoi() + " - " + p2.getIdUtilisateur() + " - " + p2.getNiveau());
        }

        // Update a participation
        Participation participationToUpdate = new Participation(4, 1, "debutant", 10);  // Example ID
        participationToUpdate.setIdParticipation(4);
        participationService.update(participationToUpdate);
        System.out.println("\nParticipation mise à jour avec succès.");
    }
}
