# Описание приложения getting-the-exchange-rate

Приложение "getting-the-exchange-rate" предоставляет возможность получать GIF-изображения на основе курса выбранной валюты к базовой валюте USD(базовую валюту можно изменить в properties файле). 
Пользователь может выбрать любую валюту из списка, поддерживаемого приложением.
Приложение также сравнивает курсы обмена за вчерашний и сегодняшний день. Если курс сегодня выше, чем вчера возвращается GIF с тегом "rich", если ниже - то "broke".

## Использование

Для использования приложения необходимо отправить GET-запрос по следующему URL-адресу:
```
/gif/{currency_code}
```
где {currency_code} - это код выбранной валюты (например, USD, EUR, GBP и т.д.) список: https://en.wikipedia.org/wiki/ISO_4217.
В ответ на запрос приложение возвращает GIF в виде JSON (shema: https://developers.giphy.com/docs/api/schema), 
соответствующее курсу выбранной валюты. Если курс сегодня выше, чем вчера возвращается GIF с тегом "rich", если ниже - то "broke".
## Технологии
Приложение написано на языке Java(JavaVersion.VERSION_17) с использованием фреймворка Spring Boot version "3.0.5".
Для получения курсов обмена используется API сервиса https://openexchangerates.org/.
Для получения Gif используется API сервиса https://developers.giphy.com/docs/api/endpoint#random

## Сборка и запуск
Для сборки проекта используется команда в корневой директории приложения: gradlew build
Для сборки образа докер: docker build -t getting-the-exchange-rate:0.0.1 .
Для запуска образа докер: docker run -p 8080:8080 getting-the-exchange-rate:0.0.1 
Готовый образ докер: https://hub.docker.com/r/slipeer13/getting-the-exchange-rate
