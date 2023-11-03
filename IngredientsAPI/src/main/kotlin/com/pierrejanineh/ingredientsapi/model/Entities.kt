package com.pierrejanineh.ingredientsapi.model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ReferenceOption

// Categories Table
object Categories : IntIdTable() {
    val name = varchar("name", 255).uniqueIndex()
}

// Ingredients Table
object Ingredients : IntIdTable() {
    val name = varchar("name", 255)
    val category = optReference("category_id", Categories, onDelete = ReferenceOption.SET_NULL)
    val description = text("description").nullable()
}

// Nutritional Information Table
object NutritionalInformation : IntIdTable() {
    val ingredient = reference("ingredient_id", Ingredients, onDelete = ReferenceOption.CASCADE).uniqueIndex()
    val calories = decimal("calories", 10, 2)
    val protein = decimal("protein", 10, 2)
    val carbohydrates = decimal("carbohydrates", 10, 2)
    val fats = decimal("fats", 10, 2)
    val fiber = decimal("fiber", 10, 2)
    val sugar = decimal("sugar", 10, 2)
    val servingSize = varchar("serving_size", 100)
}

// Recipes Table
object Recipes : IntIdTable() {
    val title = varchar("title", 255)
    val description = text("description")
    val preparationTime = integer("preparation_time")
    val cookingTime = integer("cooking_time")
    val servingSize = integer("serving_size")
}

// RecipeIngredients Table
object RecipeIngredients : IntIdTable() {
    val recipe = reference("recipe_id", Recipes, onDelete = ReferenceOption.CASCADE)
    val ingredient = reference("ingredient_id", Ingredients, onDelete = ReferenceOption.RESTRICT)
    val quantity = decimal("quantity", 10, 2)
    val measurement = varchar("measurement", 50)
}

// Users Table
object Users : IntIdTable() {
    val username = varchar("username", 255).uniqueIndex()
    val email = varchar("email", 255).uniqueIndex()
    val passwordHash = char("password_hash", 60) // Assuming bcrypt hash
    val preferences = text("preferences").nullable()
}

// UserFavorites Table
object UserFavorites : IntIdTable() {
    val user = reference("user_id", Users, onDelete = ReferenceOption.CASCADE)
    val ingredient = optReference("ingredient_id", Ingredients, onDelete = ReferenceOption.SET_NULL)
    val recipe = optReference("recipe_id", Recipes, onDelete = ReferenceOption.SET_NULL)
}
