import os

# Chemin du répertoire actuel
current_directory = os.path.dirname(__file__)
print(os.getcwd())

# Liste des fichiers dans le répertoire actuel
files = os.listdir(current_directory)

# Chemin du fichier de sortie
output_file_path = os.path.join(current_directory, 'output.txt')

# Vérifie si le fichier output.txt existe déjà
if not os.path.exists(output_file_path):
    # Ouvre le fichier output.txt en mode écriture s'il n'existe pas
    with open(output_file_path, 'w') as output_file:
        # Parcourt tous les fichiers dans le répertoire
        for file in files:
            # Vérifie si le chemin est un fichier et que ce n'est pas le programme lui-même
            if os.path.isfile(os.path.join(current_directory, file)) and file != os.path.basename(__file__):
                # Extrait le nom du fichier sans extension
                filename, extension = os.path.splitext(file)
                # Écrit le nom du fichier sans extension dans le fichier output.txt
                output_file.write(filename + '\n')

    print("Le fichier output.txt a été créé avec succès.")
else:
    print("Le fichier output.txt existe déjà.")

