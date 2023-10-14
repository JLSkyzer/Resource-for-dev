<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    
<div id="sidebar" class="sidebar">
            <img onclick="closeSidebar();" src="./Icons/menu.png" id="closeside" class="closeside" height="32px" width="
            32px">
            <br>
            <input type="text" id="search" placeholder="Rechercher...">
            <!-- Contenu de la barre latérale (groupes et pages) -->
            <?php
                $directoryPath = './groupes'; // Le chemin du répertoire des groupes

                if (is_dir($directoryPath)) {
                    $directories = array_filter(glob($directoryPath . '/*'), 'is_dir');

                    // Parcourir les fichiers .html au début
                    $groupFiles = glob($directoryPath . '/*.html');
                    foreach ($groupFiles as $file) {
                        // Obtenez le contenu du fichier HTML
                        $htmlContent = file_get_contents($file);
                        // Utilisez une expression régulière pour extraire le contenu de la balise <title>
                        preg_match('/<title>(.*?)<\/title>/', $htmlContent, $matches);
                        // Si la balise <title> a été trouvée, utilisez son contenu, sinon utilisez le nom du fichier
                        $title = !empty($matches[1]) ? $matches[1] : basename($file);
                        $fileName = basename($file);
                        echo "<p class='solofilename $fileName'>$title</p>";
                    }
                    
                    // Parcourir les dossiers des groupes
                    foreach ($directories as $groupDir) {
                        $groupName = basename($groupDir); // Obtenez le nom du groupe
                        
                        // Créez une div pour le groupe et ajoutez le nom
                        echo "<div class='group'>";
                        echo "<p class='groupname'>$groupName</p>";

                        // Parcourir les fichiers .html dans ce groupe
                        $groupFiles = glob($groupDir . '/*.html');
                        foreach ($groupFiles as $file) {
                            // Obtenez le contenu du fichier HTML
                            $htmlContent = file_get_contents($file);
                            // Utilisez une expression régulière pour extraire le contenu de la balise <title>
                            preg_match('/<title>(.*?)<\/title>/', $htmlContent, $matches);
                            // Si la balise <title> a été trouvée, utilisez son contenu, sinon utilisez le nom du fichier
                            $title = !empty($matches[1]) ? $matches[1] : basename($file);
                            $fileName = basename($file);
                            echo "<p class='filename $fileName' data-filepath='$groupDir/$fileName'>$title</p>";
                        }

                        echo "</div>"; // Fermez la div du groupe
                    }
                } else {
                    echo "Le répertoire des groupes n'existe pas.";
                }
            ?>
        </div>

        <script>
            document.addEventListener("DOMContentLoaded", function() {
                const searchInput = document.getElementById("search");
                const groupnames = document.querySelectorAll('.groupname');
                const filenames = document.querySelectorAll('.filename');
                const contentpages = document.querySelectorAll('.contentpage');

                searchInput.addEventListener("input", function() {
                    const query = searchInput.value.toLowerCase();

                    groupnames.forEach(groupname => {
                        const groupName = groupname.textContent.toLowerCase();
                        if (groupName.includes(query) || query.length < 2) {
                            groupname.style.display = "block";
                        } else {
                            groupname.style.display = "none";
                        }
                    });

                    filenames.forEach(filename => {
                        const title = filename.textContent.toLowerCase();
                        const filePath = filename.getAttribute("data-filepath");

                        // Fetch the HTML content of the associated file
                        fetch(filePath)
                            .then(response => response.text())
                            .then(htmlContent => {
                                const content = htmlContent.toLowerCase();
                                if (title.includes(query) || content.includes(query) || query.length < 2) {
                                    filename.style.display = "block";
                                } else {
                                    filename.style.display = "none";
                                }
                            })
                            .catch(error => {
                                console.error("Error fetching HTML content: " + error);
                            });
                    });
                });
            });
        </script>

</body>
</html>