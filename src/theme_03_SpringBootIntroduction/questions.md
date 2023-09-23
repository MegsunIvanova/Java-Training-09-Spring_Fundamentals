#Лекция Spring Boot Introduction

1. Какво представляват Beans?
   A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

2. PostConstruct анотация?
   Spring calls the methods annotated with @PostConstruct only once, just after the initialization of bean properties. Keep in mind that these methods will run even if there's nothing to initialize

3. PreDestroy анотация?
   A method annotated with @PreDestroy runs only once, just before Spring removes our bean from the application context.

4. Има ли разлика между application.properties и application.yml (отнася се за предназначението)?
    не, само форматът им е различен    

5. Какви Bean Scopes познавате и какви са разликите между тях?
   - singleton (When we define a bean with the singleton scope, the container creates a single instance of that bean; all requests for that bean name will return the same object, which is cached. Any modifications to the object will be reflected in all references to the bean. This scope is the default value if no other scope is specified.)
   - prototype (A bean with the prototype scope will return a different instance every time it is requested from the container. It is defined by setting the value prototype to the @Scope annotation in the bean definition)
   - Web Aware Scopes (request, session, application and websocket) - only available in a web-aware application context
   
6. Какво е SpringBoot?
   - Spring Boot is basically an extension of the Spring framework, which eliminates the boilerplate configurations required for setting up a Spring application.
   - It takes an opinionated view of the Spring platform, which paves the way for a faster and more efficient development ecosystem.

7. Само на Java се пишат спринг приложения?
    не

8. Какво е IoC и DI? Какво е Spring IoC контейнер? 
9. Има ли разлика между Spring Boot и Spring MVC?
10. Какво е Spring Boot Starter?
11. Какво е Spring Boot Autoconfiguration?
12. Какво е Spring Boot Actuator?
13. Как може да създадем един Spring Boot проект?
14. Дайте примери за няколко Spring Starter-а?