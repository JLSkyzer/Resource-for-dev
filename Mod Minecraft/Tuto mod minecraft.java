// ============= Etape 1 (installation de l'espace de travaille) =================
// Installer Forge MDK 2847 maximum !
// Unziper le dans le dossier
// ouvrir le cmd sur le dossier
// ecrire "gradlew tasks"
// ecrire "gradlew setupDecompWorkspace" puis "gradlew  eclipse"

// supprimer le com.example....
// mettre votre package (fr.pseudo.truc)
// Crée le Main.java
// Crée un package "util" a la suis du package principal
// Crée une class Reference
//Écrire:

package fr.jlskyzer.erinaworld.util;

public class Reference {
	public static final String MODID = "ErinaWorld";
	public static final String NAME = "Erina World";
	public static final String VERSION = "1.0";
	public static final String CLIENT = "fr.jlskyzer.erinaworld.proxy.ClientProxy";
	public static final String COMMON = "fr.jlskyzer.erinaworld.proxy.CommonProxy";
}


// La suite dans les autres Fichier !

// aide: ctrl + shift + o = import
// ctrl + shift + / = comment