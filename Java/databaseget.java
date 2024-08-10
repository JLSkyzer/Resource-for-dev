new Object(){
			// Méthode pour récupérer une valeur à partir de la base de données
			private String recupererValeur(String url, String username, String password, String table, String column, String conditionValue) {
				String urlBaseDeDonnees = url;
				String nomUtilisateur = username;
				String motDePasse = password;
				String nomTable = table;
				String nomColonneValeur = column;
				String condition = conditionValue;

				if (!urlBaseDeDonnees.contains("http") && !urlBaseDeDonnees.contains("https")){
					urlBaseDeDonnees = "jdbc:mysql://" + url;
				}

				String valeur = null;
				Connection connexion = null;
				Statement statement = null;
				ResultSet resultSet = null;

				try {
					// Connexion à la base de données
					connexion = DriverManager.getConnection(urlBaseDeDonnees, nomUtilisateur, motDePasse);

					// Création de la requête SQL
					String requeteSQL = "SELECT " + nomColonneValeur + " FROM " + nomTable;
					if (!condition.isEmpty()) {
						requeteSQL += " WHERE " + condition;
					}

					// Création du statement
					statement = connexion.createStatement();

					// Exécution de la requête
					resultSet = statement.executeQuery(requeteSQL);

					// Récupération de la valeur
					if (resultSet.next()) {
						valeur = resultSet.getString(nomColonneValeur);
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

				return valeur;
			}
		}.recupererValeur("URL", "USERNAME", "PASSWORD", "TABLE", "COLUMN", "CONDITION")