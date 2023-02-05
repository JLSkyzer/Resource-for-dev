// ============= Etape 1 (installation de l'espace de travaille) =================
// Installer Forge MDK 2847 maximum !
// Unziper le dans le dossier
// ouvrir le cmd sur le dossier
// ecrire "gradlew tasks"
// ecrire "gradlew setupDecompWorkspace" puis "gradlew  eclipse"

// Pour les version au dessus:
// Il faut obliger gradle a utiliser Java 8
/*
Dans le build.gradle:
	- supprimer les ligne 1-14
	- replacer par
	plugins {
	    id 'eclipse'
	    id 'maven-publish'
	    id 'net.minecraftforge.gradle' version '5.1.+'
	    id 'java'
	    id 'wtf.gofancy.fancygradle' version '1.1.+'
	}

	java {
	    toolchain {
	        languageVersion = JavaLanguageVersion.of(8)
	    }
	}
Dans le settings.gradle (le créer) :
	pluginManagement {
	    repositories {
	        maven {
	            name 'MinecraftForge'
	            url 'https://maven.minecraftforge.net/'
	        }
	        maven {
	            name 'FancyGradle'
	            url 'https://gitlab.com/api/v4/projects/26758973/packages/maven'
	        }
	    }
	}
et dans le gradle/wrapper/gradle-wrapper.properties, replacer la version de gradle par 7.5
*/

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