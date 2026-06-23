# M165 Abschlussprojekt – Rezept-Plattform

Eine Spring Boot REST API mit MongoDB für die Verwaltung von Rezepten und Bewertungen, inklusive einem HTML-Dashboard zur Visualisierung von Auswertungen.

---

## Technologie-Stack

| Komponente     | Technologie               |
|----------------|---------------------------|
| Backend        | Java 17 + Spring Boot     |
| Datenbank      | MongoDB                   |
| Build-Tool     | Gradle                    |
| Container      | Docker / Docker Compose   |
| DB-Admin       | Mongo Express             |
| Template-Engine| Thymeleaf                 |

---

## Projektstruktur

```
M165_Abschlussprojekt/
├── src/
│   └── main/
│       ├── java/com/example/demo/
│       │   ├── controller/
│       │   │   ├── RecipeController.java      # REST-Endpunkte für Rezepte
│       │   │   ├── RatingController.java      # REST-Endpunkte für Bewertungen
│       │   │   └── DashboardController.java   # Thymeleaf-Dashboard
│       │   ├── model/
│       │   │   ├── Recipe.java
│       │   │   ├── Ingredient.java
│       │   │   └── Rating.java
│       │   ├── repository/
│       │   │   ├── RecipeRepository.java
│       │   │   └── RatingRepository.java
│       │   ├── service/
│       │   │   ├── RecipeService.java
│       │   │   └── RatingService.java
│       │   └── RezeptPlattformApplikation.java
│       └── resources/
│           ├── application.properties
│           └── templates/
│               └── dashboard.html
├── docker-compose.yml
├── init.js                                    # MongoDB Initialisierungsdaten
├── gradlew
└── gradlew.bat
```

---

## Voraussetzungen

- **Java 17+**
- **Docker & Docker Compose**
- **Gradle** (oder der mitgelieferte Wrapper `./gradlew`)

---

## Setup & Start

### 1. Datenbank starten

```bash
docker compose up -d
```

Dies startet:
- **MongoDB** auf Port `27017` (mit automatischer Initialisierung via `init.js`)
- **Mongo Express** auf Port `8081` (Web-UI für die Datenbank)

### 2. Anwendung starten

```bash
./gradlew bootRun
```

Die Anwendung läuft anschliessend auf `http://localhost:8080`.

---

## API-Endpunkte

### Rezepte (`/api/recipes`)

| Methode  | Pfad                            | Beschreibung                        |
|----------|---------------------------------|-------------------------------------|
| `GET`    | `/api/recipes`                  | Alle Rezepte abrufen                |
| `GET`    | `/api/recipes/{id}`             | Einzelnes Rezept abrufen            |
| `POST`   | `/api/recipes`                  | Neues Rezept erstellen              |
| `PUT`    | `/api/recipes/{id}`             | Rezept aktualisieren                |
| `DELETE` | `/api/recipes/{id}`             | Rezept löschen                      |
| `GET`    | `/api/recipes/stats/categories` | Anzahl Rezepte pro Kategorie        |
| `GET`    | `/api/recipes/stats/preptime`   | Durchschnittliche Zubereitungszeit pro Kategorie |

### Bewertungen (`/api/ratings`)

| Methode | Pfad                            | Beschreibung                        |
|---------|---------------------------------|-------------------------------------|
| `GET`   | `/api/ratings`                  | Alle Bewertungen abrufen            |
| `POST`  | `/api/ratings`                  | Neue Bewertung erstellen            |
| `GET`   | `/api/ratings/stats/average`    | Durchschnittliche Sterne pro Rezept |
| `GET`   | `/api/ratings/stats/count`      | Anzahl Bewertungen pro Rezept       |
| `GET`   | `/api/ratings/stats/distribution` | Verteilung der Sterne-Bewertungen |

### Dashboard

| Pfad               | Beschreibung                                 |
|--------------------|----------------------------------------------|
| `/view/dashboard`  | HTML-Dashboard mit Rezepten und Auswertungen |

---

## Beispiel-Daten

Die Datenbank wird beim ersten Start automatisch mit Beispieldaten befüllt (`init.js`):

**Rezepte:** Spaghetti Carbonara, Margherita Pizza, Caesar Salad, Burger Classic, Schokoladenkuchen

**Bewertungen:** 10 Bewertungen von verschiedenen Nutzern (Sterne 3–5 mit Kommentaren)

---

## Datenbankzugang

| Zugang         | URL / Wert                       |
|----------------|----------------------------------|
| MongoDB        | `localhost:27017`                |
| Datenbank      | `recipedb`                       |
| Benutzername   | `root`                           |
| Passwort       | `1234`                           |
| Mongo Express  | `http://localhost:8081`          |

---

## Datenbankschema

### Collection: `recipes`

```json
{
  "_id": "carbonara",
  "name": "Spaghetti Carbonara",
  "category": "Pasta",
  "preparationTime": 25,
  "ingredients": [
    { "name": "Spaghetti", "amount": 500, "unit": "g" }
  ]
}
```

### Collection: `ratings`

```json
{
  "recipeId": "carbonara",
  "username": "Max",
  "stars": 5,
  "comment": "Sehr lecker"
}
```