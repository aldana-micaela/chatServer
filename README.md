# 💬 Chat Server con Sockets en Java

Este proyecto académico consiste en un sistema de chat en red desarrollado en **Java**, donde múltiples clientes pueden conectarse a un servidor para intercambiar mensajes en tiempo real. Se utilizaron sockets TCP para la comunicación, programación multihilo para manejar múltiples conexiones, e interfaces gráficas con Java Swing para mejorar la experiencia del usuario.

## 🛠️ Tecnologías utilizadas

- **Java** – Lenguaje principal del proyecto.
- **Sockets TCP** – Comunicación entre cliente y servidor.
- **Multithreading (Threads)** – Para gestionar múltiples usuarios conectados.
- **Java Swing** – Interfaces gráficas para cliente y servidor.
- **POO** – Diseño modular y estructurado.
- **Eclipse IDE** – Proyecto estructurado para abrir directamente.

## 🎯 Funcionalidades principales

- Inicio de servidor y espera de conexiones entrantes.
- Clientes pueden conectarse y enviar mensajes de forma simultánea.
- Interfaz gráfica para visualizar el chat en ambas partes.
- Múltiples hilos que permiten la comunicación en paralelo.
- Validación de entrada y control de errores básicos.

## 📂 Estructura del proyecto

```text
chat-server/
│
├── src/
│   ├── Servidor/
│   │   ├── Servidor.java
│   │   ├── ConexionCliente.java
│   │   └── MainForm.java        # Interfaz gráfica del servidor
│   └── Cliente/
│       ├── ClienteForm.java     # Interfaz gráfica del cliente
│       └── ChatThread.java      # Manejo de recepción de mensajes
│
├── bin/                         # Archivos compilados
├── .project / .classpath        # Archivos de Eclipse
└── README.md

```

## 👩‍💻 Autoría
> ⚠️ **Nota importante:** Este proyecto fue desarrollado como **ejemplo en una clase práctica**. El código base no fue escrito completamente por mí, sino que fue proporcionado por el docente o adaptado a partir de material educativo. El objetivo del trabajo fue entender el funcionamiento de sockets, cliente-servidor y multithreading en Java.
