# DemoQA BookStore — API & Web Tests

Автоматизированный тестовый проект для сайта  
👉 https://demoqa.com/books

Проект включает **API** и **Web** автотесты и настроен для запуска локально и через **Jenkins** с публикацией отчётов в **Allure** и **Allure TestOps**.

---

## О проекте

Цель проекта — продемонстрировать навыки:
- API-тестирования (REST)
- Web UI-тестирования
- интеграции API + UI
- настройки CI (Jenkins)
- работы с Allure и Allure TestOps

Проект разработан в рамках учебного / дипломного задания.

---


## Технологии и инструменты:
---
<p>
  <a href="https://www.java.com/"><img src="images/logo/Java.svg" height="48" alt="Java"/></a> 
  <a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" height="48" alt="IDEA"/></a> 
  <a href="https://github.com/"><img src="images/logo/Github.svg" height="48" alt="Github"/></a> 
  <a href="https://gradle.org/"><img src="images/logo/Gradle.svg" height="48" alt="Gradle"/></a> 
  <a href="https://github.com/allure-framework"><img src="images/logo/Allure.svg" height="48" alt="Allure"/></a> 
  <a href="https://qameta.io/"><img src="images/logo/Allure2.svg" height="48" alt="Allure TestOps"/></a>  
  <a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" height="48" alt="Jenkins"/></a>  
  <a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" height="48"  alt="JUnit 5"/></a>  
  <a href="https://selenide.org/"><img src="images/logo/Selenide.svg" height="48"  alt="Selenide"/></a> 
  <a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" height="48" alt="Selenoid"/></a> 
  <a href="https://web.telegram.org/k/"><img src="images/logo/Telegram.svg" height="48" alt="Telegram"/></a> 
  <a href="https://www.atlassian.com/ru/software/jira/"><img src="images/logo/Jira.svg" height="48" alt="Jira"/></a>  
</p>

---

## Покрытие тестами

### API тесты
- Логин пользователя
- Получение списка книг
- Получение книги по ISBN
- Добавление книги пользователю
- Удаление книги / книг

Используемые HTTP-методы:
- `GET`
- `POST`
- `DELETE`

---

### Web тесты
- Авторизация пользователя
- Проверка профиля
- Проверка наличия книг
- Удаление книг через UI

⚠️ Для подготовки тестовых данных Web-тесты используют API.

---

## Запуск тестов

Локальный запуск всех тестов
<div style="background:#f6f8fa; padding:16px; border-radius:6px;">
<pre>
gradle clean test
</pre>
</div>

Запуск с параметрами браузера

<div style="background:#f6f8fa; padding:16px; border-radius:6px;">
<pre>
gradle clean test \
-Dbrowser=chrome \
-DbrowserVersion=128.0 \
-DbrowserSize=1920x1080
</pre>
</div>


Запуск в Selenoid
<div style="background:#f6f8fa; padding:16px; border-radius:6px;">
<pre>
gradle clean test \
-Dbrowser=chrome \
-DbrowserVersion=128.0 \
-DbrowserSize=1920x1080 \
-Dremote=https://user:password@selenoid.host/wd/hub
</pre>
</div>

---

## Отчеты

### Allure Report (Jenkins)

После выполнения тестов формируется HTML-отчёт Allure, доступный из [Jenkins](https://jenkins.autotests.cloud/job/38-alexandrachirkova-final-project-api/).

<p align="center">
<img src="images/screenshots/Allure.png"/>
</p>

<p align="center">
<img src="images/screenshots/Jenkins.png"/>
</p>

### Allure TestOps

Результаты тестов автоматически отправляются в [Allure TestOps](https://allure.autotests.cloud/project/5081/dashboards)

<p align="center">
<img src="images/screenshots/AllureTestOps.png"/>
</p>

## Уведомление в Telegram при помощи бота

---
<p align="center">
<img src="images/screenshots/telegram.png" />
</p>

---


