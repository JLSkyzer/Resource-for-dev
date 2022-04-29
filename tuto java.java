// Ceci est un fichier qui regroupe tout les cours sur le java

// ===== Les variables  =====

// voici comment est composer une variable
// 1 - Nom
// 2 - Type
// 3 - Valeur

// Il existe une type de variable qu'on peut stocker pour toujours, elle s'appelle (une constante)

// D�clarer une variable
// Les types :

// int = les chiffres
// Int peut stocker que des chiffres sans virgules pour stocker des chiffres a virgules, il faut utiliser le type (double)
// String = texte

// String text = "A wonderful string that consists of multiple characters"
// int numberOfVowels = 0
// double percentageOfVowels = 0.0

// Exemple:

int personnels = 1200;
double euro = 10.20;

// Pour commencer, nous allon crée le fichier java principal, dans un programme, c'est ce fichier la qui s'execute en premier
// Exemple pour crée le fichier principal

public class MyVariable { /* (public class) cela veut dire que ce fichier (qu'on appelle une class) est accéssible pour tous */
    public static void main(String[] args) { /* Main veut dire que c'est la class principal */

        /*Le code*/

        /*Exemple*/
        int ongoingAllowance = 200;
        int savings = 3000;
        int bonusAllowance = ongoingAllowance * savings;

        /* Afficher le résultat */
        System.out.println("You have an ongoing allowance of " + ongoingAllowance + "\nYour savings amount is " + savings + "\nYou have a bonus allowance of " + bonusAllowance);
    }
}

// Encore un autre exemple:

public class MyVariable {
    public static void main(String[] args) {
        int savings = 500;
        int ongoingAllowance = 2000;

        //Ajoutez 100 à votre épargne (Yeah!)
        savings = savings + 100;

        //Enlevez 50 à votre indemnité (Snif)
        ongoingAllowance = ongoingAllowance - 50;

        //Faites une mise à jour sur votre délai d'épargne
        int numberOfDaysToSave = (5000 - ongoingAllowance) / 500;

        //Mettez à jour à nouveau votre indemnité (encore)
        ongoingAllowance = ongoingAllowance + (30 - 10) * 7;

        // Les racourcis de varibles

        // Version d'affectation normale
        savings = savings + 100;

        // Version raccourcie d'affectation
        savings += 100;
    }
}
===== Découvrez des variables qui ne changent jamais =====

//Exemple:
final int numberOfWeekdays = 7;
final String myFavouriteFood = "Icecream";
// Au dessus ce trouve des variable qui ne changeront jamais (si on essaye de les changer, on aura une erreur)

// Les type de variables:

Les décimales
Pour les décimales, Java utilise deux types différents :

float
double

// Ces deux types ont le même but. La différence est que  double  est deux fois plus précis que  float, ce qui signifie qu'il propose plus de décimales d'un nombre après la virgule.
// Si vous avez besoin de stocker quelque chose de grand, comme un numéro à 12 chiffres  1876.79797657, vous devrez utiliser  double. En effet,  float  ne pourra stocker que la moitié de ce chiffre... 
// Le reste serait tronqué et perdu à tout jamais !
// Exemple:
float length = 1876.79;
double width = 1876.79797657;

// Par exemple :

double a = 1876.79797657765609870978709780987;
float b = 1876.79797657765609870978709780987;

// Eh bien, elles vont perdre toutes les deux un peu de précision, mais pas au même degré :

// a -> 1876.797976
// b -> 1876.79

int a = 10;
double b = 4;
int c = a/ (int) b; //-> c contient 2, car a /(int) b est une division entière
// Vous voyez comment nous avons fait pour que la variable  b  agisse comme un nombre entier ? Vous pouvez aussi faire en sorte qu’une variable entière  b fasse comme si sa valeur était  double  :

int a = 10;
int b = 4;
double c = a/(double) b; //-> c contient 2.5, car la valeur de b est transformée en double
// Convertir une variable en  double  vous permet d'effectuer une division en virgule flottante, même si vous utilisez des variables avec un type entier  int.

========== Découvrez les chaînes de caractères (strings) ==========

// Voici comment déclarer une variable string en java

String city = "New York";
String movie = "Best ever";
String pet;
String emptyString = ""

// Exemple avec des chiffres
String favoriteCity = "Buenos Aires";
int numberOfTrips = 5;

String story = "I've traveled to " +favoriteCity+ " " +numberOfTrips+ " times!"; // -> "I've traveled to Buenos Aires 5 times!"

// En résumé
// Dans ce chapitre, vous avez appris les particularités de quelques types de données simples :

// nombre entiers (mot-clé  int) ;
// nombres décimaux (mots clés  float  et  double) ;
// chaînes de caractères (mot clé  String).

// Dans le chapitre suivant, nous aborderons la fonction main ; c'est le point d'entrée de votre programme.



========== Écrivez une fonction principal propre (Main) ==========

// Fonction principal
// - Est le programme
// - Déclenchée en premier

/*Lorsqu'une fonction est située à l'intérieur d'une classe, elle s'appelle une méthode. 
Puisque tout le code est situé à l'intérieur de classes, 
vous pouvez utiliser les deux termes (fonctions et méthodes) de manière interchangeable. 😎*/

// Voici le code java qui permet de faire la fonction principal :


package hello;
/* Ceci est une implémentation du message traditionnel "Hello world!"*/
public class HelloWorld {

/** Le programme commence ici */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

}

// Décryptons ce code : (https://openclassrooms.com/fr/courses/6173501-debutez-la-programmation-avec-java/6445721-ecrivez-une-fonction-principale-propre)

=======

/** la première instruction,  package hello;, est une déclaration de package. 
// Ne tenez pas compte de cette ligne pour le moment, sachez seulement qu'elle permet d'utiliser Hello ;

// la déclaration  public class HelloWorld  définit le nom de la classe comme étant  HelloWorld. En Java, 
// l'ensemble du code doit se trouver à l'intérieur d'une classe.

// les classes servant de modèle pour les objets( ici HelloWorld). Nous y reviendrons dans la partie suivante. 
// Ces classes définissent l'état de l'objet avec les champs, et le comportement de l'objet avec les méthodes,

// une instruction avec une classe utilitaire nommée 
// System. Ce genre de classe n'a pas besoin d'être instanciée pour être utilisée ;

// à l'intérieur d’une classe, vous trouverez la déclaration de fonction  public static void main(String[] args). 
// C'est le morceau de code que l'interpréteur Java recherche lorsque vous démarrez un programme ; */


// Une fois le code écris :

// Lorsque tout le code est à l'intérieur du fichier, vous devez convertir ce code Java en code exécutable par une machine que l'ordinateur peut comprendre.


========== Executer un fichier .java ==========

// Voir le dossier dans one drive
// C:\Users\killi\OneDrive\TutoDev\Tuto Java\root\


// Le langage dans lequel le code Java doit être transformé est appelé Bytecode. 
// Pour transformer le code Java en Bytecode, il est nécessaire d'utiliser le compilateur javac.

// Et c'est à ce moment-là que les dossiers commencent à être utiles ! En utilisant Terminal, 
// naviguez jusqu'au dossier racine  root  de votre programme et exécutez la commande suivante :

// $ javac hello∖HelloWorld.java
// La commande javac est en fait elle-même un programme. Si vous êtes sous Windows, elle sera nommée javac.exe.

==========

// Cette commande crée un fichier HelloWorld.class dans le dossier Hello. 
// Ce fichier est un fichier binaire (vous ne pouvez pas l'ouvrir dans un éditeur de texte). 
// Vous pouvez maintenant exécuter le programme avec la commande java (ou java.exe sous Windows) :

$ Java hello.HelloWorld
// Résultat
Hello World!
==============================

// Bravo ! ✌️ Dans le reste de ce chapitre, nous allons nous concentrer sur la façon d'organiser 
// votre code afin que votre fonction  main  reste aussi petite que possible.



========== Organisez votre code de manière à ce qu''il soit le plus compact possible ==========

// Le but de votre fonction  main  est de démarrer votre programme. 
// En fait, c'est votre programme. Si vous deviez écrire toute la logique de votre programme à l'intérieur du main, 
// cela pourrait donner une trop grande quantité de code à un seul endroit. 
// Ce serait difficilement compréhensible pour nous, les humains, et compliquerait le maintien de votre programme. 
// C'est la raison pour laquelle vous devez organiser votre code en classes.

========== Utilisez des classes en tant que modèles ==========

// Un exemple d'une telle classe est la classe  String  que vous utilisez pour stocker et manipuler les chaînes de caractères dans votre programme. 
// Cette classe est disponible dans le package  java.lang, qui est disponible depuis n'importe quelle partie de votre code.

// Comment se fait-il que  String  soit une classe et non un type primitif tel que  int  ou  double  ?

// String  est une classe non seulement parce que son nom commence par une lettre majuscule, mais aussi parce qu'il définit un état et un comportement :

// Son état est la chaîne de caractères que vous stockez. La valeur réelle est définie pour chaque objet lorsque vous l'instanciez.

// Son comportement est l'ensemble des méthodes que la classe  String  définit et qui vous permettent d'opérer sur la chaîne que vous stockez.
// Voyons cela en action :

package stringDemo;

public class StringDemo {

    public static void main(String[] args) {
        // Déclarez et créez une chaîne de caractères
        String shockingSentence="The Java String type actually is a class, not a simple type!";
        // Faites-le savoir
        System.out.println(shockingSentence.toUpperCase());
        // Inversez-le
        System.out.println(shockingSentence.replace("simple","primitive"));
    }
    
}

// Compilons et exécutons ce programme :

=       // $ javac stringDemo.StringDemo.java
=       // $ java stringDemo.StringDemo
=       // THE JAVA STRING TYPE ACTUALLY IS A CLASS, NOT A SIMPLE TYPE! 
=       // The Java String type actually is a class, not a primitive type!

// Comme vous pouvez le constater, la classe  String  vous donne accès à des comportements prédéfinis. 
// Vous pouvez simplement les utiliser pour manipuler String comme bon vous semble.

// site pratique: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html




========== Nettoyez votre fonction main ============

/*Penchons-nous maintenant sur votre fonction main  et prenons-en le contrôle. 
Nous allons la rendre aussi propre et nette que possible. 
Voici une implémentation « propre et nette » de notre programme HelloWorld :*/

package cleanHello;

public class CleanWorld {

    /** Le programme commence ici */
    public static void main(String[] args) { //String[] définis que on définir une chaine de charactère
        sayHelloTo("world");
    }

    /** affiche le message "hello" au destinataire fourni
    *
    * @param recipient
    */
    private static void sayHelloTo(String recipient) { // String car on prend un résultat (on ne la définis pas).
        // Ceci est une class qui prend le paramètre sayHelloTo qui a été difinis sur la classe principal.
        // On la prend et on lui 'String recipient' recipient est le paramètre qui nous sert a prendre le résultat du string "sayHelloTo"

        System.out.println("Hello " + recipient);
    }

}

/*
Comme vous pouvez le voir, la classe  CleanWorld  définit deux méthodes :

1.  main  est le point de départ du programme. Son seul job, 
c'est de transmettre le travail à la méthode sayHello avec l'argument dont elle a besoin. 
Dans notre cas, c'est le destinataire prédéfini de notre hello: the world!

2.  La méthode  sayHello  imprime la chaîne « Hello » 
et ajoute la valeur fournie à la variable destinataire  recipient  lorsqu'elle est appelée par la méthode main.

En termes de fonctionnalités, rien n'a changé. Cependant, 
vous pouvez maintenant ajouter plus de logique au message 
que vous allez afficher en changeant la méthode  sayHello  et en personnalisant le nom du destinataire.
*/

========== Crée une méthode (plus simple) ==========
// Cette technique est plus simple que celle juste au dessus "Nettoyez votre fonction main"

public class HelloWorld { // la classe HelloWorld

static void printHello(){ // On crée une méthode printHello
     System.out.println("Hello World! yeah");
}

public static void main(String[] args) { //On appel le resultat de la méthode dans la fonction principal (main)
    printHello();
}
}

// Saisissez la portée de vos variables dans votre code

// Accéder à une variable
//  Via leur bloc de code
//  |-> Portée de la variable

//  Niveau d'accès

//Obtenir une variable depuis une autres class
// Dans le fichier 1.java
class Unicorn {
//    Properties
    int height = 170;
    String power = "Double.infinity"

//  Methods
    public static void sleep(){
        int minutesToSleep = 120;

        // attempt to access
        System.out.println(minutesToSleep); // Ok
        System.out.println(minutesToRun); // Error
        System.out.println(height); // Ok
        System.out.println(power); // Ok
    }
    public static void run(){
        int minutesToRun = 60;

        // Attempt to access
        System.out.println(minutesToSleep); // Error
        System.out.println(minutesToRun); // Ok
        System.out.println(height); // Ok
        System.out.println(power); // Ok
    }
}
// Dans le fichier 2.java

Unicorn unicorn = new Unicorn();

System.out.println("I know it's height: "+(unicorn.height);

// et peut changer son pouvoir !
unicorn.power = 0; // pas drôle!

//Appeler une class privée
        PrivateClass a = new PrivateClass(); // Erreur
        private PrivateClass b = new PrivateClass(); // Ok
        private PrivateClass c = new PrivateClass(); // Ok


// ========== Les Boucles ==========

// Types de boucle:
/*
* De dénombrement
*   FOR
*
* Conditionnelles
*   WHILE
* */

// Les boucles FOR
for (int i=0; i<5;i++) { // Arg1 = Valeur de début, Arg2 = Le nombre de répétition, Arg3 = ce que la boucle va faire
System.out.println("Clap your hands!");
}

for (initialization; termination; increment) {
// liste de déclarations
}

int[] myArray = new int[]{7,2,4}; // ce ci est un tableau de chiffres

for (int i=0; i<myArray.length; i++) {
System.out.println(myArray[i]);
}


// Les boucles WHILE

while (logicalExpression) {
// liste de déclarations
}

// Autres exemple

int numberOfTrees = 0;

while (numberOfTrees < 10) {
numberOfTrees += 1;
System.out.println("I planted " + numberOfTrees + " trees");
}

System.out.println("I have a forest!");

// Les DO WHILE

int pushUpGoal = 10;
do{
print ("Push up!");
pushUpGoal -= 1;
} while(pushUpGoal > 0);

/*
* De cette façon, au moins une pompe (un « push-up ») est effectuée avant même que la condition soit vérifiée.
* Modifions cela un petit peu pour montrer la différence par rapport à la boucle while d'origine :

Prenons un exemple :
* */

// Boucle "While"
        int pushUpGoal = 0;
        while(pushUpGoal > 0) {
        System.out.println ("Push up!");
        pushUpGoal -= 1;
        }

// Boucle "do/while"
        int pushUpGoal = 0;
        do{
        System.out.println ("Push up!");
        pushUpGoal -= 1;
        } while (pushUpGoal > 0);

/*
* Vous pouvez voir que l'utilisation de la boucle while d'origine n'effectuera pas de « push-ups ». La boucle do... while provoquera un push-up une seule fois.
* */


// Ignorez quelques instructions à l'intérieur d'une boucle

for ( int i=0; i <10; i++) {
// déclarations exécutées à chaque itération
if(i == 2 ||i == 5) {
continue; // set a annuler le resultat 2 ou 5
}
// déclarations non-exécutées quand i == 2 or 5
}

// Pour intérrompre une boucle

String[] basket = new String[]{"apple", "orange", "banana"};

    for (int i =0; i<basket.length;i++) {
        if (basket[i] == "orange") {
        System.out.println ("I have an " +basket[i]+ " !");
        break;
        }
    }



// ========== Définissez les objets et leurs attributs avec des classes ==========








// Orienté Objet !
// Exemple d'un fichier main.java et Manager.java

// En orienté objet, une class est un objet

// == Main.java ==

package fr.jlskyzer.tuto

public class main {
    // Le static sert juste a l'initialisation
    public static void main(String[] args) {
        // On crée une nouvelle instance nommer "manager" en copiant l'objet Manager
        // New = nouvelle instance par exemple je peut faire des actions avec l'objet Manager en l'appelant "manager" et non son nom de base "Manager"
        Manager manager = new Manager();
        manager.print("Test fonction"); // Ca va envoyer le text a la fonction qui se trouve dans la class Manager
    }
}


// == Manager.java ==

package fr.jlskyzer.tuto

public class Manager {

    public Manager() {
        System.out.println("Manager appelé !");

        // Va appeler l'initialisation
        this.init();
    }

    public void print(String text){
        System.out.println("[DEBUG - Manager] " + text);
    }

    // L'initialisation (utiliser pour les création d'interface graphique par exemple)
    private void init(){
        People people1 = new People(false, 25);
        People people2 = new People(true, 17);

        System.out.println("people1 : " + people1.getAge() + " || IsFemale ? " + people1.isFemale())
    }
    
}

// Pour enregistrer des gens (People.java)
package fr.jlskyzer.tuto

public class People {

    private boolean female;
    private int age;

    public People(boolean inputFemale, int inputAge) {
        this.female = inputFemale;
        this.age = inputAge;
    }

    // Les geter et seter (geter = definition, seter = aquisition)

    public void setIsFemale(boolean inputFemale){
        this.female = inputFemale;
    }
    public boolean isFemale(){
        return this.female;
    }

    public void setAge(int inputAge) {
        this.age = inputAge;
    }

    public int getAge() {
        return this.age;
    }

    // Pour savoir si la personne est mineur:

    public boolean isMinor() {
        boolean isMinor = this.age < 18;
        return isMinor;
    }
}


// Les liste

package fr.jlskyzer.tuto;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<String> list = new ArrayList<String>();

    public void launch(){
        System.out.println"Launched !";
        list.add("Arg1");
        list.add("Arg2");

        // list.clear = tout suppr
        // list.remove = supprimer un truc précis
        // list.contains = est ce que la liste contient etc.....

        // /kill Maxime
        if (list.contain("Maxime")) {
            System.out.println("Vous avez tuer Maxime")
        } else {
            System.out.println("Il n'est pas connecter")
        }
    }
}

// ======================== Deuxième méthode (pour des USER)

// User.java

package fr.jlskyzer;

public class User {

    private String name;

    public User(String, name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Manager.java

package fr.jlskyzer;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<User> list = new ArrayList<User>();

    public void launch(){
        System.out.println"Launched !";
        
        list.add(new User("Killian"));
        list.add(new User("Maxime"));

        System.out.println('List : ' + list);
        // Console: List: [fr.jlskyzer.User@5ebbe15, fr.jlskyzer.User@22bbe15] (Id aléatoire)

        // Une boucle POUR CHAQUE utilisateur
        for(User user : list) {
            System.out.println('List : ' + user.getName());
            /* Console:
            List : Killian
            List : Maxime */
        }

        // Autre type de vérif
        for(User user : list) {
            if (user.getName().equalsIgnoreCase("Maxime")) {
                // KILL
                return;
            }
        }
    }
}


