Meta:
@search

Narrative:
Поиск туров 2

Scenario: поиск туров 2
Given пользователь переходит на сайт
Given пользователь находится на главной странице
When пользователь вводит регион <nameRegion> и выбирает параметры для посика тура
And пользователь нажимает на кнопку найти туры
Then пользователь видит на странице количество найденных туров
When пользователь изменяет фильтр стоимости
Then пользователь видит количество найденных туров соответствующих параметрам поиска

Examples:
|nameRegion|
|Карелия   |