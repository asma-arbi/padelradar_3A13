package service;

import model.Participation;
import utils.MyDatabse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipationService implements IService<Participation> {

    Connection con;

    public ParticipationService() {
        con = MyDatabse.getInstance().getCon();
    }

    @Override
    public void add(Participation participation) {
        String sql = "INSERT INTO `participation`(`idTournoi`, `idUtilisateur`, `niveau`, `nbTournoiJoue`) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, participation.getIdTournoi());
            pstmt.setInt(2, participation.getIdUtilisateur());
            pstmt.setString(3, participation.getNiveau());
            pstmt.setInt(4, participation.getNbTournoiJoue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding participation: " + e.getMessage());
        }
    }

    @Override
    public void update(Participation participation) {
        String sql = "UPDATE `participation` SET `niveau` = ?, `nbTournoiJoue` = ? WHERE `idParticipation` = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, participation.getNiveau());
            pstmt.setInt(2, participation.getNbTournoiJoue());
            pstmt.setInt(3, participation.getIdParticipation());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating participation: " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM `participation` WHERE `idParticipation` = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error deleting participation: " + e.getMessage());
        }
    }

    @Override
    public List<Participation> display() {
        List<Participation> participations = new ArrayList<>();
        String sql = "SELECT * FROM `participation`";

        try (PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Participation p = new Participation();
                p.setIdParticipation(rs.getInt("idParticipation"));
                p.setIdTournoi(rs.getInt("idTournoi"));
                p.setIdUtilisateur(rs.getInt("idUtilisateur"));
                p.setNiveau(rs.getString("niveau"));
                p.setNbTournoiJoue(rs.getInt("nbTournoiJoue"));

                participations.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching participations: " + e.getMessage());
        }

        return participations;
    }

    // Optionally, you can add specific methods for querying participations by user or tournament
    public List<Participation> getParticipationsByUser(int idUtilisateur) {
        List<Participation> participations = new ArrayList<>();
        String sql = "SELECT * FROM `participation` WHERE `idUtilisateur` = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idUtilisateur);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Participation p = new Participation();
                    p.setIdParticipation(rs.getInt("idParticipation"));
                    p.setIdTournoi(rs.getInt("idTournoi"));
                    p.setIdUtilisateur(rs.getInt("idUtilisateur"));
                    p.setNiveau(rs.getString("niveau"));
                    p.setNbTournoiJoue(rs.getInt("nbTournoiJoue"));
                    participations.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching participations by user: " + e.getMessage());
        }

        return participations;
    }

    public List<Participation> getParticipationsByTournament(int idTournoi) {
        List<Participation> participations = new ArrayList<>();
        String sql = "SELECT * FROM `participation` WHERE `idTournoi` = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idTournoi);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Participation p = new Participation();
                    p.setIdParticipation(rs.getInt("idParticipation"));
                    p.setIdTournoi(rs.getInt("idTournoi"));
                    p.setIdUtilisateur(rs.getInt("idUtilisateur"));
                    p.setNiveau(rs.getString("niveau"));
                    p.setNbTournoiJoue(rs.getInt("nbTournoiJoue"));
                    participations.add(p);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching participations by tournament: " + e.getMessage());
        }

        return participations;
    }
}
