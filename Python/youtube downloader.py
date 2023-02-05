!pip install pytube
!pip install mutagen
!pip install Pillow

import os
import requests
from pytube import YouTube
from mutagen.easyid3 import EasyID3
from PIL import Image

# Demander l'URL de la vidéo ou de la playlist YouTube
url = input("Entrez l'URL de la vidéo ou de la playlist YouTube: ")

# Télécharger la vidéo ou la playlist
video = YouTube(url)

# Conversion de la vidéo en MP3 de qualité 320 kbps
audio = video.streams.filter(only_audio=True, subtype='mp3').first().download(filename=video.title)

# Mettre le nom de la chaîne YouTube en artiste
artist = video.channel_title

# Mettre le nom de la playlist en album
album = video.playlist.title

# Télécharger la miniature de la vidéo
thumbnail_url = video.thumbnail_url
thumbnail_filename = video.title + ".jpg"
response = requests.get(thumbnail_url)
with open(thumbnail_filename, "wb") as f:
    f.write(response.content)

# Redimensionner l'image pour l'utiliser en tant que logo pour le fichier MP3
logo = Image.open(thumbnail_filename)
logo.thumbnail((300, 300))
logo.save(thumbnail_filename, "JPEG")

# Mettre à jour les informations de tag MP3
audio_file = EasyID3(audio)
audio_file['artist'] = artist
audio_file['album'] = album
audio_file.save()

# Ajouter le logo à la piste MP3
audio_file = ID3(audio)
audio_file.add(APIC(
    encoding=3,
    mime='image/jpeg',
    type=3,
    desc='Cover',
    data=open(thumbnail_filename, 'rb').read()
))
audio_file.save()

# Afficher un message pour indiquer que le téléchargement et la conversion sont terminés
print("Téléchargement et conversion terminés")
