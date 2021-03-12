La forma en que asumi como se hacia el ejercicio fue la siguiente:

El calculador recibe un plato desde la direccion: "/plato" un JSON con los siguientes datos:
- un plato (nombre + ingredientes).
- ingredientes del plato (cada uno con nombre + calorias).

Esto se guarda en un DTO

Luego, el programa debe levantar de la base de datos (en este caso el food.json) los ingredientes usados en el plato para obtener sus calorias. Esto se guarda en otro DTO

Finalmente devuelve un DTO nuevo, que tiene el nombre del plato, las calorias totales, todos los ingredientes, donde cada uno tiene su nombre y sus calorias (diferente al otro dto que tenia nombre y peso) y finalmente el ingrediente con mas calorias


EDIT: agregue la parte opcional donde se pide un listado de platos bajo el metodo POST en el path "/platos". Tambien agregue archivos de prueba en /resources/ llamados requestA y requestB