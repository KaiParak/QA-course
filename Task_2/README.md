# Использование фреймворка Rest Assured

## 📌 Описание

Этот проект создан с целью освоения написания автотестов для REST API с использованием следующих технологий:

- **JUnit 5** — модульное тестирование
- **Rest Assured** — тестирование REST API
- **DTO (Data Transfer Object)** — работа с моделью данных через сериализацию и десериализацию

В проекте реализованы три тестовых класса:

- `PetstoreDtoTest.java` — тесты с использованием DTO и Rest Assured
- `restassured/PetstoreApiTest.java` — тесты на чистом Rest Assured
- `junit/PetstoreApiTest.java` — базовые примеры тестов с использованием JUnit

## 🛠 Используемые технологии

- **Java**: Liberica 17
- **Gradle**: 8.13
- **JUnit**: 5
- **Rest Assured**: 5.5.5
- **Jackson**: для работы с JSON и DTO

## 🚀 Как запустить проект

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/KaiParak/QA-course.git
   cd Task_2
   ```
2. Выполните тесты:
   ```bash
   gradle test
   ```
   Убедитесь, что у вас установлен Java 17 и Gradle 8.4, либо используйте Gradle Wrapper (./gradlew test).   

## 🧪 О чём тесты

Все тесты направлены на взаимодействие с публичным API Swagger Petstore, проверяя корректность работы CRUD операций через HTTP-запросы.

## Автор

KaiParak