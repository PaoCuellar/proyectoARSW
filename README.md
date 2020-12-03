# Escuela Colombiana de Ingeniería Julio Garavito
# Proyecto Arquitectura de Software 2020-2
# Grupo 2
## Integrantes: 
>- Paola Andrea Cuellar Lopez
>- Nicolás Ortega Limas
>- Diego Chinchilla

      
      

## Roles:
|     Nombre    |     Rol         | Trabajo realizado
|:--------------:|:-------------: |:-------------: |
|Paola Andrea Cuellar López |Team Developer    |  Front End Developer  |
|Nicolas Ortega Limas |Team Developer   | Application Arquitect |
|Diego Chinchilla |Team Developer   | Back End Developer
|Ing. Sebastián Henao Pinzón |Product Owner   |   |
# SubastasDINIPA
## Resumen
## Descripción (antecedentes, problema que se resuelve, etc.). 
Esta aplicación tiene como objetivo principal brindar a la comunidad una herramienta fácil y eficiente para la realización de subastas.
Permite a los usuarios publicar e interactuar activamente con las
subastas; registrando ofertas, reacciones y comentarios, además de brindar
la opción de poder visualizar los datos en gráficas, de tal manera que sean mucho más amenos al usuario.

## Herramientas para seguir el estado del proyecto

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/66413a0ec2734ce6b0ae2e8a9271ffbc)](https://www.codacy.com/manual/PaoCuellar/proyectoARSW?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=PaoCuellar/proyectoARSW&amp;utm_campaign=Badge_Grade)
[![CircleCI](https://circleci.com/gh/PaoCuellar/proyectoARSW.svg)](https://app.circleci.com/pipelines/github/PaoCuellar/proyectoARSW)
[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://subastasdinipa.herokuapp.com)

## Diagramas de casos de uso:

## Administrador

![Diagrama de clases](/Diagramas/UC/CasosdeusoAdministrador.png)
## Vendedor

![Diagrama de clases](/Diagramas/UC/CasosdeusoVendedor.png)
## Comprador

![Diagrama de clases](/Diagramas/UC/CasosdeusoComprador.png)
## Historias de usuario

Podrás consultar las historias de usuario en el siguiente [link.](https://dinipa.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=SUB&selectedIssue=SUB-4)

## Enlace
Podrá acceder a nuestro proyecto en el siguiente [link.](https://subastasdinipa.herokuapp.com)

## Funcionalidades más importantes:
>- Permitir al usuario un inicio de sesión que corresponda con su información.
>- Permitir a los usuarios publicar sus articulos a subastar.
>- Permitir al usuario consultar por productos
>- Permitir a los usuarios comunes registrar productos a subastar y ofrecer por estos.
>- Permitir a los usuarios administradores modificar las subastas.
>- Recibir notificaciones al vender un artículo.
>- Permitir a los usuarios administradores modificar información de otros usuarios.
# Diseño

## Diagrama de Clases

![Diagrama de clases](/Diagramas/ClassDiagram.jpeg)

## Diagrama de Clases controllers

![Diagrama de clases](/Diagramas/controllers.jpeg)

## Diagrama de Clases services

![Diagrama de clases](/Diagramas/services.jpeg)

## Diagrama de Clases model

![Diagrama de clases](/Diagramas/model.jpeg)

## Diagrama de Clases persistence

![Diagrama de clases](/Diagramas/persistence.jpeg)

## Diagrama de Componentes

![Componentes](/Diagramas/ComponentDiagram.jpeg)

## Diagrama de Despliegue

![Despliegue](/Diagramas/DeploymentDiagram.jpeg)

## Diagrama de Base de Datos

![Base de Datos](/Diagramas/BDDiagram.jpeg)

### Mockups
* Vista de la pagina de inicio 
  ![inicio](/Imagenes/Inicio.png)
* Vista Informacion general del usuario
  ![VistaUsuario](/Imagenes/VistaUsuario.png)
* Agragar un articulo para subastar
  ![AgregarArticulo](/Imagenes/AgregarArticulo.png)
* Vista del articulo del dueño
  ![VistaArticuloDueño](/Imagenes/VistaArticuloDueño.png)
* Vista del usuario que participa en la subasta
  ![VistaArticuloNormal](/Imagenes/VistaUsuarioNormal.png)
* Vista de las subastas participadas por el usuario
  ![SubastasParticipadas](/Imagenes/SubastaParticipadas.png)
  
### Metodología.
En este proyecto pusimos en práctica la utilización de **la metodología Scrum** en la cual el equipo se reúne y planea lo que se realizará en los diferentes Sprint, la herramienta que se utilizo fue **JIRA** la cual nos permite llevar un control de las historias de usuario y repartir las tareas entre los integrantes.

### Atributos No Funcionales
En este proyecto decidimos documentar dos escenarios que muestren nuestra apropiación del requerimiento no funcional. 
Escogimos la **Usabilidad** y la demoestraremos por medio de la herramienta **Crazy Egg** 

## Escenarios de calidad
* Realizar una puja por un producto

* Publicar un articulo

