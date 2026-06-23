db = db.getSiblingDB('recipedb')

// Collections erstellen
db.createCollection('recipes')
db.createCollection('ratings')

// Rezepte
db.recipes.insertMany([
    {
        _id: "carbonara",
        name: "Spaghetti Carbonara",
        category: "Pasta",
        preparationTime: 25,
        ingredients: [
            { name: "Spaghetti", amount: 500, unit: "g" },
            { name: "Eier", amount: 4, unit: "Stk" },
            { name: "Parmesan", amount: 100, unit: "g" }
        ]
    },
    {
        _id: "pizza",
        name: "Margherita Pizza",
        category: "Pizza",
        preparationTime: 40,
        ingredients: [
            { name: "Pizzateig", amount: 1, unit: "Stk" },
            { name: "Tomatensauce", amount: 150, unit: "ml" },
            { name: "Mozzarella", amount: 200, unit: "g" }
        ]
    },
    {
        _id: "salad",
        name: "Caesar Salad",
        category: "Salat",
        preparationTime: 15,
        ingredients: [
            { name: "Salat", amount: 1, unit: "Kopf" },
            { name: "Croutons", amount: 100, unit: "g" },
            { name: "Parmesan", amount: 50, unit: "g" }
        ]
    },
    {
        _id: "burger",
        name: "Burger Classic",
        category: "Fast Food",
        preparationTime: 30,
        ingredients: [
            { name: "Burger Bun", amount: 2, unit: "Stk" },
            { name: "Rindfleisch", amount: 200, unit: "g" },
            { name: "Käse", amount: 2, unit: "Scheiben" }
        ]
    },
    {
        _id: "cake",
        name: "Schokoladenkuchen",
        category: "Dessert",
        preparationTime: 60,
        ingredients: [
            { name: "Mehl", amount: 250, unit: "g" },
            { name: "Kakao", amount: 50, unit: "g" },
            { name: "Eier", amount: 3, unit: "Stk" }
        ]
    }
])

// Bewertungen
db.ratings.insertMany([
    {
        recipeId: "carbonara",
        username: "Max",
        stars: 5,
        comment: "Sehr lecker"
    },
    {
        recipeId: "carbonara",
        username: "Anna",
        stars: 4,
        comment: "Einfach zuzubereiten"
    },
    {
        recipeId: "pizza",
        username: "Tom",
        stars: 5,
        comment: "Perfekte Pizza"
    },
    {
        recipeId: "pizza",
        username: "Sarah",
        stars: 4,
        comment: "Hat gut geschmeckt"
    },
    {
        recipeId: "salad",
        username: "Lukas",
        stars: 3,
        comment: "Etwas langweilig"
    },
    {
        recipeId: "burger",
        username: "David",
        stars: 5,
        comment: "Bester Burger"
    },
    {
        recipeId: "burger",
        username: "Mia",
        stars: 4,
        comment: "Sehr gut"
    },
    {
        recipeId: "cake",
        username: "Emma",
        stars: 5,
        comment: "Super Dessert"
    },
    {
        recipeId: "cake",
        username: "Noah",
        stars: 4,
        comment: "Nicht zu süss"
    },
    {
        recipeId: "cake",
        username: "Sophia",
        stars: 5,
        comment: "Werde ich wieder machen"
    }
])