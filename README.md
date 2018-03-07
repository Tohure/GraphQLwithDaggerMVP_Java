## Apollo + MVP + Dagger2

En este pequeño ejemplo, estoy consumiendo un servicio GraphQL de GitHub, de su API pública.

Siguiendo un estándar MVP, he separado las capas de la aplicación para tener algo más legible.

Recordemos que el cliente de Apollo para Android trabaja en un hilo distinto al main, 
por lo que al terminar la consulta, su documentación recomienda usar un Handler o 
el método runOnUiThread para que la data retornada pueda tratarse en el hilo principal.

En éste ejemplo verás implementado Apollo usando un handler, 
pero también está la opción de runOnUiThread comentada 
por si desean trabajarlo de la otra forma.

La inyección de dependencias están siendo manejadas con Dagger2.

Todo el proyecto esta bajo Java, desde las capas del MVP, 
los módulos para la Inyeccin de dependencias y las vistas usadas.