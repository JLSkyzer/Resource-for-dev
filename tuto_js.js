// Pour crée et declarer une variable

let nombreDeChats = 2;
let nombreDeChien = 4;

// Exemple addition et soustraction

let nombreAnimaux = nombreDeChats + nombreDeChien;
let nombreAnimaux = nombreDeChats - nombreDeChien;

// Autre exemple

let cookiesInJar = 10;
 
/* manger deux cookies */
cookiesInJar -= 2;  //il reste 8 cookies
 
/* cuisson d'un nouveau lot de cookies */ 
cookiesInJar += 12; // il y a maintenant 20 cookies dans la boîte

// un autre exemple

let numberOfLikes = 10;

numberOfLikes++;  // cela fait 11

numberOfLikes--; // et on revient à 10...qui n'a pas aimé mon article ?

// Il y a aussi

let costPerProduct = 20;
let numberOfProducts = 5;
 
let totalCost = costPerProduct * numberOfProducts;
 
let averageCostPerProduct = totalCost / numberOfProducts;

// et aussi

let numberOfCats = 2;

numberOfCats *= 6;  // numberOfCats vaut maintenant 2*6 = 12; 

numberOfCats /= 3;  // numberOfCats vaut maintenant 12/3 = 4;

// Pour appeller une variable sur la console

console.log(nombreAnimaux);

// Pour appeler une variable dans une page html

document.write(nombreAnimaux);

// Ou

document.write("nombre d'animaux: " + nombreAnimaux);

// On peut aussi faire

document.write("nombre de chien: "+ nombreDeChien + "<br />");

// Pour faire une variable qui restera toujours la meme

const hoursPerDay = 24;

// La variable number

let positive = 42;
let negative = -42;
let decimal = 42.424242;

// Pour avoir le type d'une variable

console.log(typeof positive);

// On peut mettre une variable avec un calcul prefais

let calcul = 1 + 2;

// Les variable Boolean

let userIsSignedIn = true;
let userIsAdmin = true;

// Les variable string

let firstName = 'Killian'
let lastName = 'Das Neves'

console.log(firstName + " " + lastName);

// =========== Les Objets ===============

// Exemple

let myBook = {
    title: 'The Story of Tau',
    author: 'Will Alexander',
    numberOfPages: 250,
    isAvailable: true
};

// Autre exemple

let myBook = {
    title: "L'Histoire de Tao",
    author: "Will Alexander",
    numberOfPages: 250,
    isAvailable: true
};

let bookTitle = myBook.title;  // "L'Histoire de Tao"
let bookPages = myBook.numberOfPages  // 250

// ======== Les classes ==========

// Exemple

class Book {
    constructor(newTitle, newAuthor, newPages){
        this.title = newTitle;
        this.author = newAuthor;
        this.pages = newPages;
    }
}

let myBook = new Book(
    "L'histoire de ta vie",
    "Killian Das Neves",
    250);

let myOtherBook = new Book(
    "Nique toi",
    "Killian Das Neves",
    1250);

    console.log(myBook);
    console.log(myOtherBook);

// ============== Les array list ==============

// Exemple 1

// Utilisez un tableau pour enregistrer une liste ordonnée d'éléments

// Remarque: Pour les objet, on utilisais les {} pour les array list, on utilise les []
// Les tableau sont trier par des index qui commence de 0. Le premier de la liste est l'index 0 et le 3eme est l'index 2

let guests = ['Sarah Kate',
  'Audrey Simon',
   'Will Alexander'];

// Pour avoir l'array list complete
   console.log(guests);

// Pour avoir une chose precise dans l'array list
    console.log(guests[0]);

// Exemple 2

let firstGuest = 'Killian Das Neves';
let secondGuest = 'Bill Gates';

let guests = [firstGuest, secondGuest];

console.log(guests);

// Utilisez des valeurs plutôt que des références

// Les valeur sont les Boolean, chaine de charactère et et des chiffre alors que les références, c'est Objets et tableaux

// Petite aide

let guest = "Will Alexander";

let guests = [guest];

guest.name = "Sarah Kare";

console.log(guests);

// La console va ecrire

Will Alexander

// Car il enregistre la valeur de guest en haut de guests

// =============

let guest = {
    name: "Will Alexander"
};

let guests = [guest];

guest.name = "Sarah Kate";

console.log(guests);

// La console va ecrire

Sarah Kate

// Car guests envois la référence de guests et non ca valeur

// Travaillez sur les tableaux

// Exemple 1

const guests = [
    "Will Alexander",
    "Sarah Kate",
    "Audrey Simon"
];

console.log(guests.lenght);

// La console va écrire

3

// Car le tableau a 3 lignes

// Exemple 2

const guests = [
    "Will Alexander",
    "Sarah Kate",
    "Audrey Simon"
];

guests.push("Tao Perkington") //Pour ajouter quelqu'un dans l'array list

console.log(guests);

// La console va écrire

["Will Alexander", "Sarah Kate", "Audrey Simon", "Tao Perkington"]

// C'est utile: variables.puch("Valeur") = pour ajouter quelqu'un, 
// variables.unshift("Valeur") = pour ajouter quelq'un au debut de l'array list
// variables.pop() = Retirer la dernère personne de l'array list

// ============== MC STATUT =================

// A mettre dans un fichier .html

<script src="https://mcapi.us/scripts/minecraft.js"></script>
				<script src="http://code.jquery.com/jquery-2.2.0.min.js"></script>
				<div class="server-status">
				Statut: <span class="server-online"></span><br />
				Nombre de joueur: <span class="server-nbrPlayer"></span>/<span class="server-nbrPlayerMax"></span>
				</div>
				<script>
				$.get(
					"https://mcapi.us/server/status",
					{ip: "2b2t.org", port : 26515},
					function(data) {
						document.querySelector('.server-online').innerHTML = data.online ? 'Allumé' : 'Eteint';
						document.querySelector('.server-nbrPlayer').innerHTML = data.players.now;
						document.querySelector('.server-nbrPlayerMax').innerHTML = data.players.max;
					}
				);
		</script>

// =============== Les condition if / else ============

// Exemple 1

let userIsLoggedIn = true;

if (userIsLoggedIn){ // Si on met juste la variable, sa veut dire qu'on verifie si elle est true
    console.log("Utilisateur bien connecter !")
} else {
    console.log("Alerte: Utilisateur non connecter")
}

// Voici d'autre type de condition

{/* <    inférieur à ;

<=   inférieur ou égal à ;

==   égal à ;

>=    supérieur ou égal à ;

>    supérieur à ;

!=    différent de. */}

const numberOfSeats = 30;
let numberOfGuests = 25;

if (numberOfGuests < numberOfSeats) {
    // autoriser plus d'invités
} else {
    // ne pas autoriser de nouveaux invités
}

// Les logiques

// &&  — ET logique — pour vérifier si deux conditions sont toutes les deux vraies ;

// ||   — OU logique — pour vérifier si au moins une condition est vraie ;

// !   — NON logique — pour vérifier si une condition n'est pas vraie. 



// Appréhendez une notion importante : le scope des variables

let userIsLoggedIn

if (userIsLoggedIn) {
    let welcomeMessage = "Bienvenue !"
} else {
    let welcomeMessage = "Non connecté !"
}

console.log(welcomeMessage);

// Le code si dessus vous donnera une erreur, si on crée une variables dans une condition, elle sera disponnible que dans la condition
// Il faut donc la declarer au debut

// Le bon code

let userIsLoggedIn
let welcomeMessage;

if (userIsLoggedIn) {
    welcomeMessage = "Bienvenue !"
} else {
    welcomeMessage = "Non connecté !"
}

console.log(welcomeMessage);

// Utilisez les instructions switch

// Exemple

let firstUser = {
    name: "Will Alexander",
    age: 33,
    accountLevel: "normal"
};

let secondUser = {
    name: "Sarah Kate",
    age: 21,
    accountLevel: "premium"
};

let thirdUser = {
    name: "Audrey Simon",
    age: 27,
    accountLevel: "mega-premium"
};

switch (firstUser.accountLevel) {
    case 'normal':
        console.log('You have a normal account!');
        break;
    case 'premium':
        console.log('You have a premium account!');
        break;
    case 'mega-premium':
        console.log('You have a mega premium account!');
        break;
    default:
        console.log('Unknown account type!');
}

// =========== Utilisez la bonne boucle pour répéter les tâches (for, while) ===========

// Boucle

// °For = Répéter  un certain nombre de fois

// °While = Répéter tant qu'une condition est remplie

// ===== Pour les boucles for =====

// Exemple

let numberOfPassengers = 10;

// 1er arg = le nombre de fois que la boucle a ete repeter, generalement on l'appel i
// 2eme arg = La condition
// 3eme arg = litteration de l'index
for (let i = 0; i < numberOfPassengers; i++) {
    console.log("Passager embarqué !")
}

console.log("Tout les passagers sont a bord !")

// ===== La boucle for…in =====

const passengers = [
    "Will Alexander",
    "Sarah Kate'",
    "Audrey Simon",
    "Tao Perkington"
]

for (let i in passengers) {
    console.log("Embarquement du passager " + passengers[i]);
}

// ===== La boucle for…of =====

const passengers = [
    "Will Alexander",
    "Sarah Kate",
    "Audrey Simon",
    "Tao Perkington"
]

for (let passenger of passengers) {
    console.log("Embarquement du passager " + passenger);
}

// Autre exemple

const passengers = [
    {
        name: "Will Alexander",
        ticketNumber: 209542
    },
    {
        name: "Sarah Kate",
        ticketNumber: 169336
    },
    {
        name: "Audrey Simon",
        ticketNumber: 779042
    },
    {
        name: "Tao Perkington",
        ticketNumber: 703911
    }
]

for (let passenger of passengers) {
    console.log('Embarquement du passager ' + passenger.name + ' avec le ticket numéro ' + passenger.ticketNumber);
}

// Utilisez la boucle  while  pour continuer jusqu'à ce qu'on dise d'arrêter

// Exemple 1

let seatsLeft = 10;
let passengersStillToBoard = 8;

let passengersBoarded = 0;

while (seatsLeft > 0 && passengersStillToBoard > 0) {
    passengersBoarded++; // un passager embarque
    passengersStillToBoard--; // donc il y a un passager de moins à embarquer
    seatsLeft--; // et un siège de moins
}

console.log(passengersBoarded); // imprime 8, car il y a 8 passagers pour 10 sièges

// Gérez des erreurs et des exceptions dans programme

// Types d'erreur

// Syntaxe = Faute de frappe
// Logique = Logiciel mal implémentée
// Exécution = éléments externe (Pour enticipé des mauvaise connection internet par exemple avec une technique appler "Exception handling")

// Gérez les erreurs d'exécution

// Une façon de traiter les erreurs potentielles consiste à utiliser une instruction  if / else  pour vérifier la validité des données : 

if (dataExists && dataIsValid) {
    // utiliser les données ici
} else {
    // gérer l'erreur ici
}

// Vous pouvez aussi utiliser des blocs  try / catch  pour essayer (try) un code pouvant potentiellement renvoyer une erreur, et détecter (catch) les erreurs éventuelles survenues :

try {
    // code susceptible à l'erreur ici
} catch (error) {
    // réaction aux erreurs ici
}

// Travaillez sur les fonctions

const add = (fisrtNumber, SecondNumber) => {
    return fisrtNumber + SecondNumber;
}

const result = add(4, 3);

console.log(result);

// Définissez des méthodes d'instance et des champs
// Tirez parti des classes avec des méthodes d'instance

// Exemple 1

class BankAccount {
    constructor(owner, balance) {
        this.owner = owner;
        this.balance = balance;
    }
}

const newAccount = new BankAccount(
    "Will Alexander",
    500
);

console.log(newAccount);

// Pour afficher que la balance

class BankAccount {
    constructor(owner, balance){
        this.owner = owner;
        this.balance = balance;
    }
    showBalance() {
        console.log("Solde: " + this.balance) + " EUR"
    }
}

const newAccount = new BankAccount(
    "Will Alexander",
    500
);

newAccount.showBalance();

// Exemple plus pousser

class BankAccount {
    constructor(owner, balance){
        this.owner = owner;
        this.balance = balance;
    }
    showBalance() {
        console.log("Solde: " + this.balance) + " EUR"
    }
    deposit(amount) {
        console.log("Deposer : " + amount + " EUR")
        this.balance += amount;
        this.showBalance
    }
    withdraw(amount) {
        if (amount > this.balance) {
            console.log("Retrait non autorisé !");
        } else {
            console.log("Retrait : " + amount + " EUR");
            this.balance -= amount;
            this.showBalance();
        }
    }
}

const newAccount = new BankAccount(
    "Will Alexander",
    500
);

newAccount.withdraw(50);

// Testez qu'une fonction fait ce qu'elle dit

// LE JS POUR LE WEB

// ================

// Les elements du DOM

// Le document

// document.getElementById()

// Par exemple imaginez sur mon fichier html j'ai cela:

// (Type: HTML)
<p id="my-anchor">My content</p>

// Voici le code pour appeler le paragraphe grace a son ID

// Type (JavaScript)
const myAnchor = document.getElementById('my-anchor');

// =============================
// document.getElementsByClassName()

// Par exemple, si l'on part du code HTML suivant:

// (Type: HTML)

<div>
    <div class="content">Contenu 1</div>
    <div class="content">Contenu 2</div>
    <div class="content">Contenu 3</div>
</div>

// A mettre en js:

// (Type: JavaScript)

const contents = document.getElementsByClassName('content');
const firstContent = contents[0];

// =============================
// document.getElementsByTagName()

// Si l'on part du code HTML suivant:

// (Type: HTML)

<div>
    <article>Contenu 1</article>
    <article>Contenu 2</article>
    <article>Contenu 3</article>
</div>

// A mettre dans le fichier JS

// (Type: JavaScript)
const articles = document.getElementsByTagName('article');
const thirdArticle = articles[2];

// =================================
// document.querySelector()

// Ainsi, avec le code HTML suivant:

<div id="myId">
    <p>
        <span><a href="#">Lien 1</a></span>
        <a href="#">Lien 2</a>
        <span><a href="#">Lien 3</a></span>
    </p>
    <p class="article">
        <span><a href="#">Lien 4</a></span>
        <span><a href="#">Lien 5</a></span>
        <a href="#">Lien 6</a>
    </p>
    <p>
        <a href="#">Lien 7</a>
        <span><a href="#">Lien 8</a></span>
        <span><a href="#">Lien 9</a></span>
    </p>
</div>

// La recherche JavaScript suivante:

const elt = document.querySelector("#myId p.article > a");

// ====================
// Les recherches depuis un élément

// Par exemple, avec le code HTML suivant :

<div id="parent">
    <div id="previous">Précédent</div>
    <div id="main">
        <p>Paragraphe 1</p>
        <p>Paragraphe 2</p>
    </div>
    <div id="next">Suivant</div>
</div>

// et si l'on considère que nous avons le code JavaScript suivant :

const elt = document.getElementById('main');

// ======================
// Modifiez le DOM

// Modifiez le contenu d'un élément

// Par exemple, avec le code JavaScript suivant :
let elt = document.getElementById('main');
elt.innerHTML = "<ul><li>Elément 1</li><li>Elément 2</li></ul>";

// l'élément qui a l'id 'main' aura un nouveau contenu ; le HTML deviendra donc

<div id="main">
    <ul>
        <li>Elément 1</li>
        <li>Elément 2</li>
    </ul>
</div>

// ======================
//Modifiez des classes
// Il est aussi possible d'accéder directement à la liste des classes d'un élément avec la propriété  classList .

// add(<string>, [<string>, ...] )  (doc) : ajoute la ou les classes spécifiées ;

// remove(<string>, [<string>, ...] )  (doc) : supprime la ou les classes spécifiées ;

// contains(<string> )  (doc) : vérifie si la classe spécifiée est contenue par cet élément ;

// replace(<old>, <new> )  (doc) : remplace l'ancienne classe par la nouvelle classe.

// Voici quelque exemple: 

elt.classList.add("nouvelleClasse");    // Ajoute la classe nouvelleClasse à l'élément
elt.classList.remove("nouvelleClasse"); // Supprime la classe nouvelleClasse que l'on venait d'ajouter
elt.classList.contains("nouvelleClasse");   // Retournera false car on vient de la supprimer
elt.classList.replace("oldClass", "newClass"): // Remplacera oldClass par newClass si oldClass était présente sur l'élément

// ====================
// Changez les styles d'un élément

// Voici quelque exemples:

elt.style.color = "#fff";      // Change la couleur du texte de l'élément à blanche
elt.style.backgroundColor = "#000"; // Change la couleur de fond de l'élément en noir
elt.style.fontWeight = "bold"; // Met le texte de l'élément en gras

// =================
// Modifiez les attributs

// Voici quelques exemples avec  elt  faisant référence à un élément de type  input  :

elt.setAttribute("type", "password");   // Change le type de l'input en un type password
elt.setAttribute("name", "my-password");    // Change le nom de l'input en my-password
elt.getAttribute("name");               // Retourne my-password

// ========================
// Créez de nouveaux éléments

// document.createElement(<tag>)  (doc) prend en paramètre le nom de la balise de notre élément et nous renvoie l'élément nouvellement créé.

const newElt = document.createElement("div");

// ========================
// Ajoutez des enfants

// parentNode.appendChild(<element>)   (doc) prend en paramètre l'élément à ajouter en tant qu'enfant. L'élément depuis lequel on appelle cette fonction devient donc le parent de notre élément.

// Voici un exemple:

const newElt = document.createElement("div");
let elt = document.getElementById("main");

elt.appendChild(newElt);

// =====================
// Supprimez et remplacez des éléments

// Voici quelques exemples :

const newElt = document.createElement("div");
let elt = document.getElementById("main");
elt.appendChild(newElt);

elt.removeChild(newElt);    // Supprime l'élément newElt de l'élément elt
elt.replaceChild(document.createElement("article"), newElt);    // Remplace l'élément newElt par un nouvel élément de type article

// ======================================
// Écoutez des événements

// Réagissez lors d'un clic sur un élément

// L'événement onclick (element.addEventListener('click', onClick);)

// Exemple:

const elt = document.getElementById('mon-lien');    // On récupère l'élément sur lequel on veut détecter le clic
elt.addEventListener('click', function() {          // On écoute l'événement click
    elt.innerHTML = "C'est cliqué !";               // On change le contenu de notre élément pour afficher "C'est cliqué !"
});


// preventDefault()

// Sert a annuler l'événement par défaut

const elt = document.getElementById('mon-lien');    // On récupère l'élément sur lequel on veut détecter le clic
elt.addEventListener('click', function(event) {     // On écoute l'événement click, notre callback prend un paramètre que nous avons appelé event ici
    event.preventDefault();                         // On utilise la fonction preventDefault de notre objet event pour empêcher le comportement par défaut de cet élément lors du clic de la souris
});

// stopPropagation()

// De la même manière que  preventDefault() ,  stopPropagation()  est une fonction de l'objet que votre fonction reçoit en paramètre. Son rôle est par contre très différent, car il nous permet d'empêcher la propagation de l'événement vers son parent. En effet, lorsqu'un événement est déclenché, il est d'abord reçu par l'élément cible, mais il est ensuite remonté vers les éléments parents qui sont aussi dans la cible.

// Avec  stopPropagation() , vous pouvez ainsi empêcher que d'autres éléments reçoivent l'événement.

// Admettons par exemple que nous ayons un élément pour lequel nous voulons afficher un message lorsque l'on clique dessus. Mais à l'intérieur de cet élément, nous avons aussi un autre élément qui doit nous afficher un autre message lorsque l'on clique dessus.

// Par défaut, si nous cliquons dans l'élément intérieur, le message va s'afficher, puis notre élément parent va lui aussi recevoir l'événement du clic et encore changer le message. Pour éviter cela, nous devons stopper la propagation de l'événement.

// Ainsi, dans l'élément intérieur, nous ferons ceci :

elementInterieur.addEventListener('click', function(event) {
    event.stopPropagation();
    elementAvecMessage.innerHTML = "Message de l'élément intérieur";
});

// =======================
// Récupérez des données utilisateur avec les événements

// Détectez le mouvement de la souris

// Afin de détecter le mouvement de la souris, il nous faut écouter l'événement  mousemove  (doc).  Cet événement nous fournit un objet de type  MouseEvent . C'est-à-dire que dès que la souris bouge, notre fonction callback sera appelée avec un paramètre de type  MouseEvent , qui contient les données sur le mouvement de la souris.

// Voici, entre autres, ce que cet objet nous permet de récupérer :

// clientX  /  clientY  : position de la souris dans les coordonnées locales (contenu du DOM) ;

// offsetX  /  offsetY  : position de la souris par rapport à l'élément sur lequel on écoute l'événement ;

// pageX  /  pageY  : position de la souris par rapport au document entier ;

// screenX  /  screenY  : position de la souris par rapport à la fenêtre du navigateur ;

// movementX  /  movementY  : position de la souris par rapport à la position de la souris lors du dernier événement  mousemove

// Voici un exemple illustrant tout ça :

elt.addEventListener('mousemove', function(event) {
    const x = event.offsetX; // Coordonnée X de la souris dans l'élément
    const y = event.offsetY; // Coordonnée Y de la souris dans l'élément
});

// ======================================
// Envoyez une première requête

// Voyons maintenant comment on peut construire et envoyer une requête HTTP avec AJAX.

// Si vous vous souvenez du chapitre précédent, vous devez avoir deviné que nous allons créer une requête HTTP avec la méthode GET, afin de récupérer des données. C'est parti !

var request = new XMLHttpRequest();
request.open("GET", "http://url-service-web.com/api/users");
request.send();

// Ce code nous permet d'envoyer une requête HTTP de type GET au service web se trouvant à l'adresse  http://url-service-web.com/api/users .

// Voici ce que fait le code, ligne par ligne :

// Ligne 1 : on crée un nouvel objet de type  XMLHttpRequest  qui correspond à notre objet AJAX. C'est grâce à lui qu'on va créer et envoyer notre requête ;

// Ligne 2 : on demande à ouvrir une connexion vers un service web. C'est ici que l'on précise quelle méthode HTTP on souhaite, ainsi que l'URL du service web ;

// Ligne 3 : on envoie finalement la requête au service web.

// ================================
// Récupérez les données au format JSON

// Ainsi, l'objet JavaScript suivant :

const obj = {
    name: "Mon contenu",
    id: 1234,
    message: "Voici mon contenu",
    author: {
        name: "John"
    },
    comments: [
        {
            id: 45,
            message: "Commentaire 1"
        },
        {
            id: 46,
            message: "Commentaire 2"
        }
    ]
};

// sera retranscrit ainsi en JSON :

{
    "name": "Mon contenu",
    "id": 1234,
    "message": "Voici mon contenu",
    "author": {
        "name": "John"
    },
    "comments": [
        {
            "id": 45,
            "message": "Commentaire 1"
        },
        {
            id: 46,
            "message": "Commentaire 2"
        }
    ]
}

// ============================
// Récupérez le résultat de la requête

// Pour cela, nous allons devoir utiliser la propriété  onreadystatechange  en lui passant une fonction. Cette fonction sera appelée à chaque fois que l'état de la requête évolue.

// Voici les différents états possibles :

// UNSENT  (code 0) : l'objet est prêt mais la méthode  open()  n'a pas encore été appelée ;

// OPENED  (code 1) :  open()  a été appelé ;

// HEADERS_RECEIVED  (code 2) :  send()  a été appelé, les headers et  status  sont disponibles au sein de l'objet ;

// LOADING  (code 3) : réception en cours, les données reçues sont partielles ;

// DONE  (code 4) : requête terminée.

// =============
// Code HTML:

// Les codes de 100 à 199 sont des codes d'information, plutôt techniques et peu utilisés en pratique ;

// Les codes de 200 à 299 sont des codes de succès. Ils veulent dire que votre requête s'est bien déroulée et vous apporteront une information sur le type de résultat que vous recevez ;

// Les codes de 300 à 399 sont les codes de redirection. Ils indiquent généralement que le contenu que vous recherchez a bougé ou n'est pas accessible directement ;

// Les codes de 400 à 499 sont des codes d'erreur liés à l'utilisation du service web (ressource inexistante, authentification requise, pas les bonnes permissions, requête mal construite, etc). Ce sont des erreurs que l'on retrouve fréquemment dans la pratique et pour lesquelles il est bon d'avoir une stratégie de résolution ;

// Les codes de 500 à 599 sont des codes d'erreur venant du service web (plantage du service, service ne répondant plus, manque de mémoire, etc.). En tant qu'utilisateur du service, vous ne pouvez pas y faire grand-chose, mais de la même manière que pour les erreurs 4xx, il est bon d'avoir une stratégie de résolution.

// ==================
// Exemple de code

// readyState  : qui contient l'état de la requête ;

// status  : qui contient le code de statut de la requête (souvenez-vous, 2xx quand ça s'est bien passé, 3xx pour les redirections, 4xx pour les erreurs...) ;

// responseText  : qui contient la réponse du service web au format texte. Ainsi, si le texte que l'on attend est au format JSON, il va falloir le transformer en objet JavaScript avec la fonction  JSON.parse(texteJSON) .

var request = new XMLHttpRequest();
request.onreadystatechange = function(event) {
    if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
        var response = JSON.parse(this.responseText);
        console.log(response.current_condition.condition);
    }
};
request.open("GET", "https://www.prevision-meteo.ch/services/json/paris");
request.send();

// Exemple de modification d'un text

var message = document.getElementById("para");
var btn = document.getElementById("weatherBtn");

btn.addEventListener('click', function(event){
	message.innerHTML = " Du Text Plus long....";
})

// Exemple pour savoir la méteo

// Voici le json qu'il recup:

{
    "current_condition": {
            "condition": "Beau temps",
            ...
    },
    ...
}

// Donc on cherche a avoir current_condition et condition
// Il va donc falloir ecrire dans le code (current_condition.condition)
// Voila le code

var message = document.getElementById("para");
var btn = document.getElementById("weatherBtn");
var askWeather = new XMLHttpRequest();

btn.addEventListener('click', function(event){
	askWeather.open("GET", "https://www.prevision-meteo.ch/services/json/paris");
	askWeather.send();
	
	askWeather.onreadystatechange = function() {
		if (this.readyState == XMLHttpRequest.DONE && this.status == 200) {
			var response = JSON.parse(this.responseText);
			message.innerHTML = response.current_condition.condition;
		}
	};
	
})

// Validez les données saisies par vos utilisateurs

// Validez les données suite à des événements

myInput.addEventListener('input', function(e) {
    var value = e.target.value;
    if (value.startsWith('Hello ')) {
        isValid = true;
    } else {
        isValid = false;
    }
});

// Ou avec  Html 5

// L'attribut  type  de la balise  input  ne prend pas seulement comme valeurs  text  et  password . Cela peut aussi être  email ,  tel ,  URL ,  date  et bien d'autres. 

// Lorsque vous ajoutez un élément  input  avec un attribut  type="email" , le navigateur empêchera la soumission du formulaire si ce n'est pas une adresse email correcte.

// Les  attributs de validation simples
// En fonction du  type  de l' input , vous pouvez utiliser différents attributs pour perfectionner votre validation :

// min  /  max  : fonctionne avec des champs de type nombre ou date. Cela permet de définir une valeur minimum et une valeur maximum autorisées ;

// required  : fonctionne avec à peu près tous les types de champs. Cela rend obligatoire le remplissage de ce champ ;

// step  : fonctionne avec les dates ou les nombres. Cela permet de définir une valeur d'incrément lorsque vous changez la valeur du champ via les flèches ;

// minlength  /  maxlength  : fonctionne avec les champs textuels (  text ,  url ,  tel ,  email ...). Cela permet de définir un nombre de caractères minimum et maximum autorisé.

// Nous avons vu qu'il était possible d'avoir une validation complexe grâce aux Regex en JavaScript. Eh bien c'est aussi possible directement en HTML5 avec l'attribut  pattern . Il suffit de définir une Regex dans cet attribut, et vous obligez la valeur du champ correspondant à la respecter.

// Par exemple, si on prend le code suivant :

<input type="text" pattern="[0-9]{,3}" />
// il empêchera un utilisateur d'entrer autre chose que des chiffres, et limitera leur nombre à 3 chiffres.

// ===================================











// Bonus !:

// Pour désactiver quelque chose:

var btn = document.getElementById("weatherBtn");

btn.addEventListener('click', function(event){
	btn.disabled = true;
	
})

// Quand on charhe une page

window.addEventListener("load", function(event) {
    navbtn.innerHTML = 'test';
    window.alert('test')
  });