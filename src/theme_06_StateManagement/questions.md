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
    - област в паметта на сървъра/базата данни, където се пазят различни данни за user-a
5. Как може в Spring да добавим атрибут в HTTP session?
    - като инжектираме HTTPSession обекта като аргумент и му добавяме атрибути
6. Как може да се четат кукита в контролер?
    - с анотация @CookieValue анотация
7. Как може сървърът да изтрие едно Cookie? :-)
   - като сетне същото Cookie - със същото име и properties, но с maxAge = 0
   
8.
