# Cahier des Charges - Projet Reservations

## 1. Objectif du Projet
Développement d'une application web de gestion d'artistes et d'agences avec Spring Boot.

## 2. Technologies Utilisées
- **Backend**: Spring Boot 3.5.6, Java 21
- **Base de données**: MySQL 9.4
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript (AJAX)
- **ORM**: Hibernate/JPA
- **Build**: Maven

## 3. Fonctionnalités Implémentées

### 3.1 Backend
- Création de deux entités: `Agency` et `Artist`
- Relation OneToMany entre Agency et Artist (une agence a plusieurs artistes)
- Relation ManyToOne entre Artist et Agency (un artiste appartient à une agence)
- Repositories JPA pour les opérations CRUD
- DataLoader pour l'injection de données de test

### 3.2 Gestion des Agences
- Liste complète des agences avec leurs artistes
- Route personnalisée: `/agencies/{id}/artists` pour afficher les artistes d'une agence

### 3.3 Gestion des Artistes
- Liste complète des artistes
- Formulaire d'ajout d'artiste avec liste déroulante pour sélectionner l'agence
- Fonctionnalité AJAX: survol du prénom affiche le nom de l'agence sans rafraîchir la page

## 4. Structure de la Base de Données

### Table `agencies`
- id (PRIMARY KEY, AUTO_INCREMENT)
- name (VARCHAR, NOT NULL)

### Table `artists`
- id (PRIMARY KEY, AUTO_INCREMENT)
- firstname (VARCHAR, NOT NULL)
- lastname (VARCHAR, NOT NULL)
- agency_id (FOREIGN KEY → agencies.id, NOT NULL)

## 5. Données de Test
- **Acting Association**: Bob Sull, Lydia Smith
- **New Agency**: Fred Durand

## 6. Routes Principales
- `GET /agencies` - Liste des agences
- `GET /agencies/{id}/artists` - Artistes d'une agence spécifique
- `GET /artists` - Liste des artistes
- `GET /artists/new` - Formulaire d'ajout
- `POST /artists` - Sauvegarde d'un artiste
- `GET /artists/{id}/agency` - Endpoint AJAX pour récupérer le nom de l'agence

## 7. Sécurité et Normes
- Validation des données avec annotations JPA
- Relations bidirectionnelles gérées avec Hibernate
- Code commenté et structuré selon les conventions Spring Boot

## 8. Développements Futurs Possibles
- Système d'authentification
- Modification et suppression d'artistes/agences
- Recherche et filtrage avancés
- API REST pour intégration mobile
