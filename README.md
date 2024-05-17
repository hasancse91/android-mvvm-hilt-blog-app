# Android Blog Reading App [MVVM & Hilt]

Welcome to the Android MVVM+Hilt Blog Reading App repository! This project is a hands-on example of building a Blog Reading App using the Model-View-ViewModel (MVVM) architectural pattern and Dagger-Hilt dependency Injection. Dive into this practical project to enhance your Android development skills and get a taste of what you'll learn in the [Android Dependency Injection with Hilt Course (Bengali)](https://learning.megaminds.technology/courses/android-dependency-injection-with-hilt/details). You can watch the course [introduction and outline from here](https://youtu.be/xVvaJLqKTQs).


https://github.com/hasancse91/android-mvvm-blog-app/assets/3769029/e5817744-cf8d-4310-8efc-8bf01df55c27


## Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Getting Started](#getting-started)
- [MVVM Architecture](#mvvm-architecture-the-final-goal)
- [Hilt Implementation](#hilt-implementation)

## Project Overview

The Android MVP Blog Reading App showcases how to structure and build an Android app using MVVM architecture with Dependency Injection Hilt. As you explore this repository, you'll gain practical insights into clean code, separation of concerns, and best practices in Android app development.

## Features

This app showcases various features related to reading blogs, including:

- [x] Viewing a list of blog posts
- [x] Displaying blog post details
- [x] Fetching blog posts from a remote server
- [x] [Manually provide depdency without library](https://github.com/hasancse91/android-mvvm-hilt-blog-app/tree/manual-di-mvvm)
- [x] Dependency Injection Hilt implementation (master branch)

## Getting Started

To get started with the project, follow these steps:

1. Clone the repository to your local machine:
   ```shell
   git clone https://github.com/hasancse91/android-mvvm-hilt-blog-app.git
   ```

2. Open the project in Android Studio.

3. Build and run the app on an emulator or physical device.

# MVVM Architecture

The key components of the MVVM architecture include:

- Model: Represents the data and business logic of the app.
- View: Displays the UI and handles user input.
- ViewModel: Acts as an intermediary between the Model and View, handling business logic and updating the observable field. Which observable field is being observed by View.

The MVVM architecture brings several benefits, including improved code maintainability, separation of concerns, and testability. Specially it overcomed the limitations of MVP architecture like: ViewModel reusability issue, lifecycle handle issue etc.

# Hilt Implementation
- Refactoring the MVVM project
- Adding dependencies for Hilt
- Annotate Application class using `@HiltAndroidApp`
- Create `@Module`
- Bind repository
- Make Activity class as `@AndroidEntryPoint`
- Prepare `ViewModel` for injection field

---

Thank you for exploring the Android Blog Reading App project! If you have any questions or suggestions, please feel free to reach out.

**Happy coding!**
