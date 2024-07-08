# Proyecto Final - Desarrollo Orientado a Objeto
Integrantes: Luis Ignacio Martinez Neira, Santiago Alexander Díaz Barra y Mario Andres Salgado Jaque.
## Enunciado
Tema 2: Sistema de reserva de asientos de autobús

El sistema de reserva de asientos de autobús permite al personal de una empresa de autobús elegir y reservar asientos de forma conveniente por su cliente. Los usuarios pueden  visualizar una representación gráfica de los asientos disponibles en el autobús y seleccionar los que deseen ocupar. El sistema muestra información detallada sobre cada asiento, como su ubicación, número y  categoría (por ejemplo, semi cama, Salón Cama).
Una vez que los usuarios seleccionan los asientos deseados, el sistema verifica la disponibilidad y permite confirmar la reserva mostrando el precio a pagar. En caso de que algún asiento ya esté reservado por otro pasajero, se informa al usuario para que pueda elegir otro asiento disponible. El personal confirma el pago (no gestionado por el sistema) lo que reserva los asientos.
El sistema debe gestionar varios tipos de autobuses (por ejemplo, con diferente número de plazas, o de 1 o 2 pisos...).
El sistema debe mostrar un menú que permita seleccionar el autobús en función de su horario y recorrido (se supone que estos datos están disponibles con los autobuses vacíos cuando se lanza el software)
## Diagrama UML
![Diagrama UML](Proyecto_UML.png)
## Diagrama de casos de uso
![Diagrama casos de uso](Diagrama%20caso%20de%20uso.png)
## Patrones utilizados
Se utilizaron los patrones singleton y Holder. Para el patron singleton, creamos clases unicas de Ventana y Panel fondo, ya que solo es necesario que se creen una unica vez y para el holder usamos nuestro panel fondo para poder conectar los demás paneles a traves de un puntero hacia él y asi poder pasar datos entre los paneles.
## Interfaz
![Primeracaptura](Primeracaptura.png)
![Segundacaptura](Segundacaptura.png)
![Terceracaptura](Terceracaptura.png)
![Cuartacaptura](Cuartacaptura.png)
![Quintacaptura](Quintacaptura.png)
## Decisiones
Durante nuestro proceso para realizar el proyecto podemos destacar las siguientes:

-Para mas simplicidad decidimos usar solo 2 tipos de buses que fueron el Saloncama y Semicama.

-Limitamos las posibles fechas seleccionables a solo 2 semanas, desde que se inicia el programa.

-Utilizamos un solo tipo de asiento porque cada bus tendra todos sus asientos iguales.

-Agregamos como funcionalidad adicional exportar los pasajes comprados como pdf, lo que implica el uso de una dependencia adicional.

-Definimos Enums para valores constantes que dependen del entorno en el entorno que se use el programa, como los recorridos, los modelos de buses y el itinerario.
## Conclusiones
Planteamos durante horas las posibles soluciones a los diversos obstaculos que se nos cruzaron a la hora de desarrollar el código, tales como, ¿Cómo podemos hacer que al momento de comprar un asiento, al volver a comprar se siga manteniendo el estado de compra del asiento?, ¿Como limitar la cantidad de fechas que se podran seleccionar?, ¿Cómo guardaremos de manera óptima los datos de los buses?, y ¿Como hacer que después de finalizar la compra se guarden en un archivo todos los datos de compra, que a la vez debe de guardarse automáticamente?, pero todo este esfuerzo que dedicamos a este proyecto sabes que dara frutos para mejorar aún más nuestras habilidades en la programacion una de las cosas más importantes como ingeniero civil informatico, ademas de darnos experiencia que sabemos que nos será de gran utiliad para nuestros cursos futuros en la carrera.