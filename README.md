# 🛒 Advance Food Point - Online Grocery App

**Advance Food Point** is an intuitive and user-friendly Android application for online grocery shopping. Built using **Android Studio**, this app allows users to log in, browse fresh vegetables, and easily add them to their cart for purchase.

## 📸 Screenshots

**Login Page**
- Simple login with email & password
- Option to sign up and recover password
<div style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: center;">
<img src="/img/app.jpeg" alt="App" style="width: 40%; border: 2px solid white;"/>
</div>

**🛍️ Grocery Page**
- Add or remove quantity
- Dynamic price updates (optional)
- “Add to Cart” button for checkout
<div style="display: flex; flex-wrap: wrap; gap: 20px; justify-content: center;">
<img src="/img/layout.jpeg" alt="Cart" style="width: 18%; border: 2px solid white;"/>
</div>

## 🚀 Features

- 🔐 User Authentication (Login / Sign Up)
- 🧺 Add to Cart functionality
- 🥕 Browse fresh groceries with quantity controls
- 🖼️ Clean and modern UI design
- 📱 Fully responsive mobile layout

## 📂 Project Structure

- `MainActivity.java`: Entry point with login/signup navigation
- `GroceryListActivity.java`: Displays list of groceries with quantity selector
- `CartActivity.java`: Shows selected items and handles cart logic
- `User.java`: Handles user data structure
- `Product.java`: Represents grocery product data
- `Adapter.java`: Custom adapters for RecyclerView

## 🛠️ Tech Stack

- Java
- Android SDK
- XML Layouts
- Shared Preferences
- RecyclerView
