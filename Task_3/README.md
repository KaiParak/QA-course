# Параметризация тестов

## 📌 Описание

Этот проект демонстрирует пример параметризации тестов с использованием JUnit 5 аннотаций `@ParameterizedTest` и `@MethodSource`.

В рамках проекта реализован автотест для успешного `POST`-запроса к [Petstore API](https://petstore.swagger.io/v2/pet), в котором отправляются разные объекты питомцев. Основная цель — показать, как сократить дублирование кода и упростить масштабирование тестов путём повторного использования одной тестовой логики с разными входными данными.

## 🛠 Технологии

- **Java**
- **Gradle v8.13** (Kotlin DSL)
- **JUnit 5**
- **Rest Assured v5.5.5**
- **Jackson** (для сериализации объектов в JSON)

## 📁 Структура проекта

Task_3/

<pre>
Task_3/
├── src
│   └── test
│       └── java
│           └── api
│               ├── model
│               │   └── Pet.java           // Модель питомца
│               ├── data
│               │   └── PetProvider.java   // Источник данных для параметризации
│               └── PetApiTest.java        // Параметризованный тест
├── build.gradle.kts
└── README.md
</pre>

## ▶ Как запустить

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/KaiParak/QA-cource
   cd QA-cource/Task_3
   ```
2. **Запустите тесты:**
   Если установлен Gradle 8.4 и Java 17:
   ```bash
   gradle test
   ```
   **Или используйте Gradle Wrapper:**
   ```bash
   ./gradlew test     # для Unix/macOS
   gradlew.bat test   # для Windows
   ```
   
## 👤 Автор

KaiParak