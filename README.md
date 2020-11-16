# Bienvenue sur l'application Mousvies !

Nous sommes trois étudiants en B3 informatique à Ynov Aix Campus. Dans le cadre de nos études, précisément dans le module Développement mobile, il nous est demandé de créer un projet android sous Kotlin reprennant les différents points étudiés en cours. Ce module est encadré par Mme Macha Da Costa.

Notre projet Mousvies est une application qui permet de consulter et découvrir les films les populaires, les films selon un genre, ou pouvoir rechercher un film.

Cette application utilise l'api de [The Movie Database](https://www.themoviedb.org/).

## Exigences du projet

* Activity et Fragment
* Utilisation d'une Api externe
* Retrofit 2, okHttp 
* Picasso (rendu des images de l'api) 
* Kotlin Coroutines
* RecyclerView pour l'affichage des éléments de l'api
* Search View : barre de recherche
* Bonne architecture du code respectant la POO
* Utilisation des Intent pour le passage de données d'une activité à une autre
* LinearLayout, RelativeLayout

## L'api

The Movie Database est une base de données populaire et modifiable par l’utilisateur pour les films et les émissions de télévision développé par une grosse communauté.

L'utilsation de l'api se fait dans le package `api.service` dans lequel on effectue des requêtes `GET` en utilisant les annotations de retrofit. Un modèle de données pour représentant chaque retour de données d'une requête spécifique a été créé.

## Choix du projet

Nous avons ce projet car il nous permet de voir un ensemble de notions dans le développement mobile.

* La communication réseau avec un serveur
* Utilisation d'une liste d'élements
* Utlisation de bibliothèque
* Travail en groupe avec l'utilisation de Git

Cela permet donc d'avoir plus de compétences dans le cadre de la gestion de projet, de comprendre les principes de programmations de Android, de comprendre la communication avec Internet et extraire des données, de concevoir des interfaces utilisateurs interactives et ergonomique.

## Ce qu'on a appris / Le plus fier

Durant ces quelques semaines de travail, nous avons chacun eu à rencontrer des problèmes à résoudre. Nous pouvons dire qu'on est content d'avoir pu :
* Gérer l'affichage des données de toutes les parties ou fragments de l'interface
* Gérer la navigation des menus et d'afficher la vue correspondante avec les données
* Réussir à faire le pont entre la vue et les données
* Réussir à ne pas trop galérer sur la compatibilité des codes de chacun sans qu'il ait trop de bugs
* Réussir à préparer des fonctions qui font appel à différentes requêtes qu'on pourraient utiliser plus tard
* Réussir à avoir une structure pouvant être utiliser dans différentes fonctions
* Gagner le soutien de toute l'équipe toujours disponible pour aider les uns des autres

## Là où on s'est loupé
Même dans les meilleurs projets, certains points ne sont pas bien aboutis. Dans notre cas, nous n'avons pas  :
* Gérer les Shared Preferences (nous souhaiterions pouvoir enregistrer les derniers recherches que l'utilisateur a effectué)
* Bien gérer idéalement l'appel des requêtes de l'api, on se retrouve avec plusieurs lignes de codes avec de la redondance

## 🚀 Alors on se lance !!!

Ces instructions vous permettront d'avoir une copie de votre projet dans votre machine en local afin d'établir des tests et pourquoi continuer le développement.

### Pré-requis


|            Android Studio    |Kotlin|Api Level 30|
|----------------|-------------------------------|-----------------------------|


### Installation
Suivre ces étapes si vous souhaitez avoir une copie locale du projet dans votre machine.

#### 1. Cloner le repository	
```
https://github.com/Lucrabe/Mouvies.git
```

#### 2. Importer le projet dans Android Studio
1.  Dans Android Studio, allez dans File -> New -> Import project
2.  Suivez les instructions et importer le projet que vous venez de cloner.
3.  Android Studio importe le projet et lancer le build.
4.  Pas besoin d'ajouter la clé de l'api, elle est directement intégrer.

## 📝 Crédits
####  Développeurs
* Tristan Mattéoli
* Mouhamadou Ndour
* Lucas Tichet
####  Encadrante
* Macha Da Costa
	* Toutes nos remerciements à notre encadrante de nous avoir soutenu et d'être présente dans la bonne réussite de notre projet. également, nous souhaitons lui remercier de nous avoir mis à profit de ses connaissances dans le développement mobile qui nous servirons très certainement.
