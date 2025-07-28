# 🚀 PreProject313

Java + Spring Boot проект с авторизацией, ролями пользователей и защищёнными страницами. Реализованы CRUD-операции, разграничение доступа и кастомная аутентификация.

---

## 📦 Стек технологий

- Java 17+
- Spring Boot 3.5.3
- Spring MVC
- Spring Security 6
- Spring Data JPA
- Hibernate ORM
- MySQL 8.0+
- Thymeleaf
- Maven
- Bootstrap

---

## 📂 Структура проекта

```
src/
├── controller/        // Контроллеры для работы с пользователями и интерфейсом
├── model/             // Сущности: User, Role
├── repository/        // JPA-репозитории
├── service/           // Сервисы с бизнес-логикой
├── security/          // Конфигурация Spring Security
└── templates/         // HTML-страницы (Thymeleaf)
```

---

## 🔐 Роли и доступ

- **`ADMIN`** имеет полный доступ:
  - `GET /admin/**` — доступ к управлению пользователями
  - Возможность CRUD-операций

- **`USER`**:
  - `GET /user` — доступ только к своей домашней странице
  - Нет доступа к `/admin/**`

---

## 🔑 Аутентификация

- Пользователь вводит логин и пароль на `/login`
- Используется Spring Security `UserDetailsService`
- Пароли хранятся в открытом виде (NoOpPasswordEncoder) — только для разработки
- После успешного входа:
  - Админ перенаправляется на `/admin`
  - Пользователь — на `/user`

---

## 🧪 Как запустить проект

1. Клонировать репозиторий:
   ```bash
   git clone https://github.com/your-name/PreProject311.git
   ```

2. Создать базу данных:
   ```sql
   CREATE DATABASE my_db;
   ```

3. Настроить `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/my_db
   spring.datasource.username=your_user
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Собрать и запустить:
   ```bash
   mvn clean spring-boot:run
   ```

5. Перейти в браузере:
   ```
   http://localhost:8080/login
   ```

---

## 👤 Примеры пользователей

> Данные добавляются в БД вручную или через SQL-скрипт

| Логин     | Пароль  | Роль         |
|-----------|---------|--------------|
| `admin`   | `admin` | `ROLE_ADMIN` |
| `user`    | `user`  | `ROLE_USER`  |

---

## ✅ Функциональность

- Авторизация и проверка ролей
- CRUD для пользователей (admin)
- Thymeleaf-шаблоны
- Безопасный logout
- Перенаправление после логина

---

## 📌 Дополнительно

- Используется аннотация `@ManyToMany` для связи `User <-> Role`
- Пользователь может иметь **несколько ролей**
- Все роли реализуют `GrantedAuthority`, а `User` — `UserDetails`

---

## 📧 Контакты

> Автор: Misak Grigoryan  
> Проект для изучения Spring Security + CRUD  
> GitHub: https://github.com/xxMUGIWARAxx/PreProject312.git
# PreProject313
