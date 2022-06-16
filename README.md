<h1 align="center">StockApplication</h1>
<h2 align="center"> StockApplication cuenta con el desarrollo de un proyecto en Kotlin con Hilt, RXJava, Retrofit, ViewModel, basado en MVVM. </h2>
<p align="center">
<img src="/assets/image.jpg" width="1000" height="1000"/>


## Acerca de StockApplication
- Minimum SDK level 23
- [Kotlin](https://kotlinlang.org/) 
- Patrón & Arquitectura:
  - Clean Arquitecture (Presentation - Data - Domain)
  - MVVM (View - DataBinding - ViewModel - Model)
- [RxJava](https://github.com/ReactiveX/RxJava) para resolver la asincronía.
- [Hilt](https://dagger.dev/hilt/) para la inyección de dependencias.
- Lifecycle - Observa los ciclos de vida de Android y maneja los estados de la UI al cambiar el ciclo de vida.
- ViewModel - Almacena y administra los datos relacionados con la UIpara los ciclos de vida, permite que se conserven los datos.
 - DataBinding -Permite vincular los componentes de la UI de los diseños a las fuentes de datos de la app usando un formato declarativo.
- [Retrofit2](https://github.com/square/retrofit) - Peticiones API REST.
- [Moshi](https://github.com/square/moshi/) -  Librería JSON para Android, Java y Kotlin. Facilita el análisis de JSON en clases Java y Kotlin:


## Arquitectura
<h3>StockApplication sigue los principios de Clean Aquitecture y utiliza como patrón MVVM.
<p>
<p>
<p align="center">
<img src="https://devexperto.com/wp-content/uploads/2018/10/clean-architecture-own-layers.png"
width="30.1%/>

<p align="center">
<img src="https://betabeers.com/static/uploads/blog/20190208_image_2.png"
width="34.9%"/>

</p>


## API

StockApplication usa [NinetyNineAPI](https://challenge.ninetynine.com/favorites para construir una API RESTful.<br>

