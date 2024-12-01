# Mercado de Activos Digitales en Java

Sistema para gestionar activos digitales como arte y música, con funciones de listado, compra y validación.

## Prerrequisitos

- JDK 21+
- IDE (Eclipse o VS Code)

## Inicio Rápido

1. Clonar repositorio:
```bash
git clone https://github.com/tunombre/activos-digitales.git
```

2. Abrir en tu IDE preferido
3. Compilar y ejecutar

## Estructura del Proyecto

```
.
├── src/           # Archivos fuente
├── bin/           # Archivos compilados
└── README.md      # Documentación
```

## Características

- Gestión de activos digitales (arte, música)
- Cálculo de valor según propiedades
- Seguimiento de transacciones
- Validación de activos
- Listado y búsqueda por valor

## Ejemplo de Uso

```java
public class Main {
    public static void main(String[] args) {
        ServicioValidacion validador = new ServicioValidacion();
        MercadoDigital<ArteDigital> mercadoArte = new MercadoDigital<>(validador);
        MercadoDigital<MusicaDigital> mercadoMusica = new MercadoDigital<>(validador);
        
        try {
            ArteDigital arte = new ArteDigital("ART1", "Paisaje Retro", 1080, "pixel", 100.0);
            mercadoArte.listarActivo(arte);
            
            MusicaDigital musica = new MusicaDigital("MUS1", 240, "electrónica", true, 50.0);
            mercadoMusica.listarActivo(musica);
            
            Usuario comprador = new Usuario("user1", "Juan Pérez", 500.0);
            mercadoArte.adquirirActivo("ART1", comprador)
                .ifPresent(activo -> System.out.println("Activo adquirido: " + activo.obtenerMetadatos()));
                
        } catch (ValidacionExcepcion | FondosInsuficientesExcepcion e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

Salida esperada:
```
Activo adquirido: Título: Paisaje Retro, Resolución: 1080px, Estilo: pixel
```

## Gestión de Dependencias

Utiliza la vista `JAVA PROJECTS` de VS Code o el gestor de paquetes de tu IDE.

## Contribución

1. Haz un fork del repositorio
2. Crea rama de funcionalidad (`git checkout -b nombre-funcionalidad`)
3. Commit cambios (`git commit -am 'Agrega funcionalidad'`)
4. Push a la rama (`git push origin nombre-funcionalidad`)
5. Crea Pull Request

## Licencia

Licencia MIT - Ver archivo LICENSE para detalles
