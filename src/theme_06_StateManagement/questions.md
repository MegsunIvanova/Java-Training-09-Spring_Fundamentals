# Лекция State Management

1. Какво е Cookie?
    -Cookies are small files of information that a web server generates and sends to a web browser.
   - Cookies help inform websites about the user, enabling the websites to personalize the user experience.
   - не съдържат изпълним код
2. За какво служат cookies? 
   - User sessions: Cookies help associate website activity with a specific user. A session cookie contains a unique string (a combination of letters and numbers) that matches a user session with relevant data and content for that user.
   - Personalization: Cookies help a website "remember" user actions or user preferences, enabling the website to customize the user's experience.
   - Tracking: Some cookies record what websites users visit. This information is sent to the server that originated the cookie the next time the browser has to load content from that server. With third-party tracking cookies, this process takes place anytime the browser loads a website that uses that tracking service.
3. Какво е third party cookie?
    - A third-party cookie is a cookie that belongs to a domain other than the one displayed in the browser. 
    - Third-party cookies are most often used for tracking purposes. 
    - They contrast with first-party cookies, which are associated with the same domain that appears in the user's browser.
4. Какво е HTTP сесия?
    - series of related browser requests that come from the same client during a certain time period
    - област в паметта на сървъра/базата данни, където се пазят различни данни за user-a и 
    - свързва дадено session id с някакъв storage, това session id пътува обикновенно по cookie
    - по този начин даден request може да се отъждестви с дадена session
    
5. Как може в Spring да добавим атрибут в HTTP session?
    - като инжектираме HTTPSession обекта като аргумент и му добавяме атрибути
6. Как може да се четат кукита в контролер?
    - с анотация @CookieValue анотация
7. Как може сървърът да изтрие едно Cookie? :-)
   - като сетне същото Cookie - със същото име и properties, но с maxAge = 0
   
8. Какво е scope на едно Cookie?
   - от къде е дошло cookie-то и кой сървър би могъл да го получи при http-request-a
9. Какво е съдържанието на едно Cookie?
   - key-value pair, напр lang=en, освен това може да има и т.нар. атрибути като:
   - secure - cookie-то да може да бъде изпратено само по https, когато имаме някъкъв TLS
   - http only - определя, че cookie-то не може да бъде пипано от JavaScript
   - same side - определя кога точно може да се прати едно cookie - директно или не
   - expires - до кога е валидно cookie-то
10. Какво се създава и унищожава  една HTTP сесия?
   - HTTP session-a се създава от сървъра и обикновенно тогава сървърът създава и израща на на клиента cookie със session id-то му
   - в последствие, когато това session id се върне от клиента към сървъра, сървъра знае за коя сесия става въпрос
11. С помоща на кои класове и анотации работим със сесии в Spring MVC?
   - когато имаме някакъв Controller бихме могли да обявим аргумент на метода на controller-a от типа HttpSession
11. С помоща на кои класове и анотации работим с Cookies в Spring MVC?
   - ResponseCookie дава възможност да направим cookie s помоща на builder pattern-a, което по-късно може да се добави към HttpSession-a

