# Exercice - Application serveur renvoyant la liste des parkings les plus proches

## Contenu de l'application  

L'application développée présente un service de récupération d'une liste de parking en prenant en compte les coordonnées de l'utilisateur. La distance considéré comme "proche" à été choisi arbitrairemeent à 1Km. Ainsi tous les parking se situant à moins d'1Km de l'utilisateur seront affichés.

## Pile Technologique

Voici les différentes technologies utilisées :

- Springboot 2.7.4
- java 1.8
- Jackson
- Junit5

## Étapes de développement

La réalisation de cette application s'est déroulé selon le plan suivant :

- la visualisation des données et de l'application (comment s'organise l'application, quel appel rest faire, quelle données sont utiles, etc...)
- la réalisation de la classe parking avec les différentes champs retenus : le nom, les deux coordonnées, le nombre de place initial
- ensuite vient l'implémentation du controler qui contient l'appel rest
- la mise en place d'un service qui va faire les différent traitement : renvoie de la list, calcule de la distance, vérification des places disponibles
- la création d'un service d'affichage pour l'affichage de la liste

Les données utilisées sont celles de set de données disponible via cette url : https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilite-parkings-grand-poitiers-donnees-metiers&rows=1&facet=nom_du_parking&facet=zone_tarifaire&facet=statut2&facet=statut3  
ainsi que les données de stationnement des parkings sont disponible ici : https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom

Le temps passé pour réaliser cette application est de 10h30 environ.

## Lancer l'application

Afin de pouvoir lancer l'application, il faut :

- cloner le projet en utilisant l'url : https://github.com/Alphailosia/testInstantSystem.git
- ouvrir le projet via un logiciel comme intelIj
- lancer la classe ParkappApplication
- entrer l'url suivante http://localhost:8080/parkings?latitude=46.58595804860371&longitude=0.351295426580696

Vous pouvez modifier les valeurs latitude et longitude afin de voir la liste changer

## Amélioration possible

Il y a plusieurs façon d'améliorer l'application :

- avoir un dataset sur plusieur villes afin d'étendre le périmètre de l'application
- ajouter un test d'intégration
