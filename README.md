# management_system
Система представляет WEB-приложение, интерфейс которого управляет пользователями.

Система поддерживает две роли:

USER - Авторизация (Login)
       Просматривает список пользователей (List)
       Просматривает детали любого пользователя (View)
       Выход (Logout)
       
ADMIN - Авторизация (Login)
        Просматривает список пользователей (List)
        Просматривает детали любого пользователя (View)
        Созданет нового пользователя (New/Edit)
        Редактирует существующего пользователя (New/Edit)
        Lock/Unlock пользователя (Lock/Unlock)
        Выход (Logout)

Пароли в БД хранятся в хешированом виде с применением алгоритма bcrypt.

По умолчанию установлено два пользователя:

1) username - user, password - user, role - USER;
2) username - admin, password - admin, role - ADMIN

Стек технологий Java 11, Spring Boot, Spring Security, Spring Data, Lombok, Liquibase, MySQL, Thymeleaf