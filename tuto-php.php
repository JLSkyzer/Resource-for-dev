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
        $db = new PDO("mysql:host" . HOST . ";dbname=" . DB_NAME, USER, PASS);
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

Pour inséré un nouvel utilisateur

<?php
$q = $db->prepare("INSERT INTO user(email,password) VALUES(:email,:password)");
$q->execute([
    'email' => $_POST['emailpost'],
    'password' => $_POST['passwordpost']
]);
?>

<!-- Episode 8 terminé -->
