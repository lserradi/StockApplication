<h1 align="center">StockApplication</h1>
This project aims to be an example of an app that uses clean architecture together with the use of the MVVM pattern in the presentation layer.
In this project we also control the asynchrony using RXJava as well as controlling the Hilt dependency injection.
The functionality of the application is to collect stock data provided by the API, list them and get their details.

The project connects to NinetyNine's API to retrieve data and manipulate it.


## Stack

|                   | Name                                | Version |
|-------------------|-------------------------------------|---------|
| **Language**      | Kotlin                              | 1.5.31  |
| **Build**         | Gradle                              | 7.0.3   |
| **SDK**           | Minimum SDK                         | 23      |
| **View model**    | View model                          | 2.4.1   |
| **Asynchrony**    | RxJava                              | 2.2.21  |
| **JSON**          | Moshi                               | 1.11.0  |
| **API REST**      | Retrofit2                           | 2.9.0   |
| **Firebase**      | Firebase                            | 2.9.0   |
| **Injection of Dependencies**| Hilt                     | 2.40.0  |
| **API**           | [NinetyNineAPI](https://challenge.ninetynine.com/favorites)                           | 1.0.0   |


## Core decisions

### 1. The architecture

Spring Boot is designed to work with a file organization or architecture based on [MVC](https://www.javatpoint.com/xamarin-model-view-viewmodel-pattern),
but for this challenge I've preferred to go further by applying my own interpretation of the [CLEAN architecture proposed by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html),
which tries to take the best ideas from MVC, Hexagonal and Onion architectures.

The most common image to represent the layers that define this architecture is usually:

<img src="https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg" width="600" />

But here is my own sketch of this project organization:

<img src="https://i.postimg.cc/6qPKywkZ/Untitled-2023-04-20-1357.png" />

The main benefits of using an architecture like this is the semantics it brings to the team, allowing to be clear where
everything is going to be found. In addition to simplifying the task of testing by allowing to isolate each layer.

In addition to the file organization proposed above, [SOLID principles](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design) have been taken into account and other design
patterns have been applied based on the need to.

