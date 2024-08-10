import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HttpsDatabaseAccess {
    public static void main(String[] args) {
        String urlBaseDeDonnees = "jdbc:mysql://localhost:3306/ma_base_de_donnees";
        String nomUtilisateur = "utilisateur";
        String motDePasse = "mot_de_passe";
        String nomTable = "ma_table";
        String nomColonneCle = "player";
        String nomColonneValeur = "money";
        String nomJoueur = "test";
        int nouvelleValeur = 100; // Nouvelle valeur pour la colonne "money"

        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Connexion à la base de données
            connexion = DriverManager.getConnection(urlBaseDeDonnees, nomUtilisateur, motDePasse);

            // Vérifier si le joueur existe dans la table
            String rechercheSQL = "SELECT * FROM " + nomTable + " WHERE " + nomColonneCle + "=?";
            statement = connexion.prepareStatement(rechercheSQL);
            statement.setString(1, nomJoueur);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Le joueur existe, donc mettre à jour la valeur de la colonne "money"
                String miseAJourSQL = "UPDATE " + nomTable + " SET " + nomColonneValeur + "=? WHERE " + nomColonneCle + "=?";
                statement = connexion.prepareStatement(miseAJourSQL);
                statement.setInt(1, nouvelleValeur);
                statement.setString(2, nomJoueur);
                statement.executeUpdate();
                System.out.println("La valeur de la colonne 'money' pour le joueur '" + nomJoueur + "' a été mise à jour avec succès.");
            } else {
                System.out.println("Le joueur '" + nomJoueur + "' n'existe pas dans la table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des ressources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
