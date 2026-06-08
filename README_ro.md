# Teste automate pentru OpenWeather API

Acest proiect demonstrează un framework de testare automată pentru API, construit cu **Java 17, Maven, TestNG, RestAssured și Allure**.  
Scopul este validarea scenariilor pozitive și negative pentru serviciul OpenWeather și prezentarea rapoartelor Allure într-un mod organizat și ușor de înțeles.

---

##  Tehnologii utilizate
- Java 17
- Maven
- TestNG
- RestAssured
- Allure Reporting

---

##  Structura proiectului

src
└── test
└── java
└── api
└── WeatherTests.java

---

##  Scenarii de testare
- Cazuri pozitive (oraș valid, unități, limbă)
- Cazuri negative (oraș invalid, parametri lipsă, API key lipsă)
- Validarea răspunsurilor (coduri HTTP, câmpuri JSON)

---

##  Raportare
Rapoartele Allure includ:
- Suites și Behaviors grupate prin adnotările `@Epic`, `@Feature`, `@Story`
- Environment metadata (base URL, tester, framework)
- Categories tab pentru testele eșuate

> Un test este lăsat intenționat ca **failed** (status code 201 în loc de 200) pentru a demonstra cum Allure categorizează erorile.  
Aceasta arată că înțeleg procesul de diagnosticare și raportare.

---

## CI/CD
- Pipeline GitHub Actions rulează automat testele la fiecare push
- Raportul Allure este generat și publicat pe GitHub Pages
- [Vizualizează raportul](https://victoria.github.io/OpenWeatherAPITests) *(înlocuiește cu linkul real al repo-ului)*

---

##  Autor
**Victoria — QA Automation Tester**  
Focus: învățare și practică în testarea API, cu accent pe raportare clară și documentație bine structurată.