<!-- Un fichier php fonctionne comme du html, mais vous pouvez aussi faire un programme de php dans votre comme ça par exemple -->
<!-- Ce code ce met seulement si votre fichier php a du html -->
<?php echo "Bienvenue sur ma page php"; ?>
<!-- Le echo sert a afficher du texte ou des éléments html -->
<!-- Voici une alténative plus rapide du echo -->
<?= "Bienvenue sur ma page php"; ?>

<!-- Un petit exemple en html -->

<?php

    $pseudo = "JLSkyzer"; // Ceci est une variable
    $age = 16;
    $email = "killiandasneves4@gmail.com";

?>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Titre</title>
</head>
<body>

<p>Nom : <?= $pseudo; ?></p>
<p>Email : <?= $email; ?></p>
<p>Age : <?= $age; ?></p>
    
</body>
</html>

<!-- Fin du tuto -->
<!-- Si le css marche pas essayer:

<link rel="stylesheet" type="text/css" href="styles/styles.css?v=<?php echo time(); ?>"> -->

<!-- Imaginons que je met une nav bar sur un php externe voici comment on peut le rajouter a sont html -->

<?php include "manavbar.php"; ?>

<!-- Ep 1 terminé -->

<!-- Crée un formulaire (pour pas se faire chier hein) -->

<form method="post"> <!-- Post = d'une page a une autre / Get = par l'url --> 
    <input class="input" type="text" name="pseudo" id="pseudo" placeholder="Pseudo" required>
    <input class="input" type="text" name="age" id="age" placeholder="Age" required>
    <input class="input" type="text" name="email" id="email" placeholder="Email" required>
    <input class="input" type="submit" value="Submit" name="formsend" id="formsend">
</form>

<?php 
    if(isset($_POST['formsend'])){
        // echo $_POST['pseudo'];

        $pseudo = $_POST['pseudo'];
        $age = $_POST['age'];
        $email = $_POST['email'];
    }
?>
<!-- Ep 2 terminé -->


<!-- Crée une base de donné -->

<!-- 
    Etape 1: crée une base de donné
    Etape 2: Crée une table
    Etape 3: sauvegarder la table

    ========== Mettre une valeur manuellement ! ==========

    Etape 1: allez dans "SQL"
    Etape 2: choisissez votre requête ex (SELECT *, SELECT, INSERT, ...)
    Attention : Supprimer les colones (Auto-increment) dans votre requêtes
    Etape 3: executer

    Exemple de (INSERT):
        INSERT INTO `users`(`pseudo`, `email`, `password`) VALUES ('JLSkyzer','killiandasneves4@gmail.com','EQGFSQGZS0SQSG0SSS851510S')

    Exemple de (SELECT)
        SELECT 'email' FROM 'users' WHERE id = 3
        Cela va nous donner l'email du compte id 3
 -->

 <!-- ========== Mettre / GET une valeur depuis sont site ! ========== -->

 <!-- Faire une variable constant -->
 <!-- Systeme pour ce connecter a la database -->
<?php

    define('HOST','localhost');
    define('DB_NAME','siteweb');
    define('USER', 'root');
    define('PASS', '');

    try{
        $db = new PDO("mysql:host=" . HOST . ";dbname=" . DB_NAME, USER, PASS);
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        echo "Connect > OK !";
    }catch(PDOException $e){ //Erreur de connexion
        echo $e;
    }

?>

<!-- Pour avoir / envoyer des info a une table dans votre DB -->

<form action="" method="post">
        <input type="email" name="emailpost" id="emailpost" placeholder="Votre email" required>
        <input type="password" name="passwordpost" id="passwordpost" placeholder="Votre mot de passe" required>
        <input type="submit" id="submit" name="submit">
</form>

    <?php
        include 'database.php';
        global $db;

        // Prend les infos a partir de la table "user"
        $q = $db->query("SELECT * FROM user");
        while($user = $q->fetch()){
            echo "id : " . $user['id'] . "<br/>";
            echo "email : " . $user['email'] . "<br/><br/>";
        }

        if(isset($_POST['submit'])){
            $email = $_POST['emailpost'];
            $password = $_POST['passwordpost'];
        }
    ?>

<!-- Pour chaque page vous devez mettre: -->
<?php
include 'database.php';
global $db;
?>
<!-- Car c'est très important ! -->

<!-- Pour inséré un nouvel utilisateur -->

<?php
$q = $db->prepare("INSERT INTO user(email,password) VALUES(:email,:password)");
$q->execute([
    'email' => $_POST['emailpost'],
    'password' => $_POST['passwordpost']
]);
?>

<!-- Les mots de passe ! -->
<!-- Au lieu d'avoir un mot de passe clair, on va faire un mot de passe crypté -->
<!-- Au lieu de faire $_POST on va faire un truc qui va raccourcir ! -->
<!-- ça veut dire au lieu de faire $_POST['passwordpost'] on fait juste $passwordpost -->
<!-- Voici comment crypté -->
<?php
$options = [
    'cost' => 12,
];
'password' => password_hash($passwordpost, PASSWORD_BCRYPT, $options)
?>

Check si l'email existe
<?php
$emailcheck = $db->prepare("SELECT * FROM user WHERE email = :emailRecherche");
$emailcheck->bindParam(':emailRecherche', $emailpost);
$emailcheck->execute();

if ($emailcheck->rowCount() > 0) {
    echo "Le string existe dans la colonne 'email'.";
} else {
    echo "Le string n'existe pas dans la colonne 'email'.";
}
?>

Prendre des info à partir du mail

<?php
if ($emailcheck->rowCount() > 0) {
    // Récupérer les données de l'utilisateur
    $utilisateur = $emailcheck->fetch(PDO::FETCH_ASSOC);

    // Maintenant, vous pouvez accéder aux données de l'utilisateur, par exemple :
    $idUtilisateur = $utilisateur['id'];
    $motDePasse = $utilisateur['password'];

    // Vous pouvez utiliser ces données comme bon vous semble.
    echo "ID de l'utilisateur : " . $idUtilisateur . "<br>";
    echo "Mot de passe de l'utilisateur : " . $motDePasse;
} else {
    echo "Aucun utilisateur trouvé avec cette adresse email.";
}
?>

<!-- Système d'inscription complet ! -->
<!-- Le système de session -->
Le système de session permet de stocker des info qu'on pourras prendre pendant la navigation de l'utilisateur, la sessions disparrait quand l'onglet se ferme.
Voici comment démarrer la sessions, requis pour chaque page.
<?php session_start(); ?>
<!DOCTYPE html>

Comment ajouter une valeur a la session:
<?php $_SESSION['pseudo'] = "JLSkyzer"; ?>

Voici comment bien destroy la sessions si besoin : 
<?php
session_unset();
session_destroy();
?>

<!-- Système de connexion -->

Voici le système de connexion / inscription fini !

<?php
    include './database.php';
    global $db;
    extract($_POST);

    $q = $db->query("SELECT * FROM user");
    while($user = $q->fetch()){
        echo "id : " . $user['id'] . "<br/>";
        echo "email : " . $user['email'] . "<br/><br/>";
    }

    $send = $db->prepare("INSERT INTO user(email,password) VALUES(:email,:password)");

    $emailcheck = $db->prepare("SELECT * FROM user WHERE email = :emailRecherche");
    $emailcheck->bindParam(':emailRecherche', $emailpost);
    $emailcheck->execute();

    if(isset($_POST['submit'])){
        $options = [
            'cost' => 12,
        ];
        $hashpass = password_hash($passwordpost, PASSWORD_BCRYPT, $options);
        if ($emailcheck->rowCount() > 0) {
            // Récupérer les données de l'utilisateur
            $utilisateur = $emailcheck->fetch(PDO::FETCH_ASSOC);
        
            // Maintenant, vous pouvez accéder aux données de l'utilisateur, par exemple :
            $idUtilisateur = $utilisateur['id'];
            $motDePasse = $utilisateur['password'];

            $hashcheckpass = $motDePasse;
            if(password_verify($passwordpost, $hashcheckpass)){
                $_SESSION["email"] = $emailpost;
                $_SESSION["connected"] = true;
                header("Location: account.php");
                exit;
            }else{
                echo "mot de passe incorrect ! <br>";
            }
        } else {
            $send->execute([
                'email' => $emailpost,
                'password' => $hashpass
            ]);
        }
    }
?>

<!-- Les cookies -->
Voici la base
<?php
// Ajouter un cookie
setcookie('nom', 'valeur');
setcookie('nom', "valeur", time() + (10 * 365 * 24 * 3600)); // s'expire dans 10 ans
// Supprimer un cookie
setcookie('nom', '', time());
// Prendre un cookie
echo "id : " . $_COOKIE['nom'];
?>


<!-- Modifier un cookie avec un script js -->
<script>
    themeToggle.addEventListener("change", () => {
        if (themeToggle.checked) {
            // Thème sombre
            darktheme();
            updateThemeCookie("sombre");
        } else {
            // Thème clair
            whitetheme();
            updateThemeCookie("clair");
        }
    });

    function updateThemeCookie(theme) {
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "update_cookie.php", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.send("theme=" + theme);
    }
</script>

<!-- Le php -->
<?php
if (isset($_POST['theme'])) {
    $theme = $_POST['theme'];
    setcookie('theme', $theme, time() + (10 * 365 * 24 * 3600));
}
?>