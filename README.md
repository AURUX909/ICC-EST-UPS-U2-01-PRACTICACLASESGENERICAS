# Proyecto de Activos Digitales en Java

Este proyecto simula un mercado de activos digitales en el que los usuarios pueden listar, comprar y validar activos digitales como arte y música.

## Descripción

Este sistema permitira crear activos digitales, calcular su valor dependiendo de sus características (como resolución, estilo para el arte o duración y licencia para la música), realizar transacciones, y llevar un registro de todas las operaciones realizadas.

### Características

- **Activos digitales**: Implementados para arte y música, con métodos específicos de cálculo de valor.
- **Validación**: Cada activo se valida antes de ser agregado al mercado.
- **Transacciones**: El usuario puede comprar activos si tiene fondos suficientes.
- **Gestión de mercado**: Se pueden listar activos y buscar por rango de valor.

## Getting Started

Para comenzar con este proyecto en tu entorno local, sigue estos pasos:

1. Clona el repositorio a tu máquina local:
   ```bash
   git clone https://github.com/tuusuario/proyecto-activos-digitales.git
Abre el proyecto en tu IDE preferido (como Eclipse o VS Code).

Asegúrate de tener el JDK 21 o superior instalado.

Compila y ejecuta el proyecto.

## Estructura de Carpetas

El proyecto contiene las siguientes carpetas y archivos:

src/: Contiene el código fuente del proyecto.

Aquí se encuentran las clases principales, como ActivoDigital, ArteDigital, Usuario, MercadoDigital, entre otras.
bin/: Contendrá los archivos compilados.

README.md: Este es mi archivo.

## Ejemplo de Uso

El siguiente ejemplo muestra cómo usar el sistema para crear activos digitales, validarlos y realizar una compra.

Código Principal (Main.java)

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

## Salida Esperada:
Activo adquirido: Título: Paisaje Retro, Resolución: 1080px, Estilo: pixel

## Manejo de Dependencias
Este proyecto no depende de bibliotecas externas, pero si deseas agregar alguna, puedes gestionarlas a través de un archivo de configuración como pom.xml si usas Maven o build.gradle si usas Gradle.

## Prerequisitos
Asegúrate de tener instalado lo siguiente:

-JDK 21 o superior.
-Un IDE compatible con Java (como Eclipse o VS Code).
## Contribuciones: 
Si deseas contribuir, por favor sigue estos pasos:

-Realiza un fork del proyecto.
-Crea una nueva rama (git checkout -b feature-nueva-funcionalidad).
-Haz tus cambios y haz un commit (git commit -am 'Agrega nueva funcionalidad').
-Haz push a la rama (git push origin feature-nueva-funcionalidad).
-Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.

### Descripción de las Secciones:
- **Getting Started**: Guía para configurar el proyecto en tu entorno local.
- **Estructura de Carpetas**: Explica cómo están organizadas las carpetas y archivos.
- **Ejemplo de Uso**: Muestra cómo se ejecuta el código, incluyendo ejemplos de las clases principales.
- **Manejo de Dependencias**: Aunque no se usa ninguna dependencia externa, se menciona cómo añadirlas si es necesario.
- **Contribuciones**: Explica cómo los demás pueden contribuir al proyecto.
- **Licencia**: Información sobre la licencia del proyecto.
