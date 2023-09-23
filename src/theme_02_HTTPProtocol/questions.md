# Лекция HTTP Protocol

1. Обяснете кодовере, които започват с 1хх, 2хх, 3хх, 4хх и 5хх
   1xx informational
   2xx successful
   3xx redirection
   4xx client error
   5xx server error

2. HTTP2 - какво е multiplexing server push?
   HTTP/2 can send multiple requests for data in parallel over a single TCP connection

3. Как работи TLS/SSL?
   The SSL/TLS involves the following steps:
   - The client contacts the server using a secure URL (HTTPS…).
   - The server sends the client its certificate and public key.
   - The client verifies this with a Trusted Root Certification Authority to ensure the certificate is legitimate.
   - The client and server negotiate the strongest type of encryption that each can support

4. Какво HTTP глаголи познавате?
   GET - за вземане на ресурс
   PUT - за създаване на ресурс
   POST - за ъпдейтване на ресурс
   PATCH - за парциален ъпдейт на ресурс
   DELETE - за изтриване на ресурс
   OPTIONS

5. Опишете структурата на едно URL
   [protocol]://[subdomain].[domain name]:[port]/[path]?[query]#[fragment]
   example: https://www.hostinger.com:80/videoplay?docid=720&hl=en#00h02m30s

6. Каква е разликата между URI и URL?
   URL са подмножество на URI
   URI identifies a resource and differentiates it from others by using a name, location, or both. URL identifies the web address or location of a unique resource. URI contains components like a scheme, authority, path, and query.

7. Разлика между PUT/POST/PATCH? - виж 4

8. Какво представлява модел POST-redirect-GET и защо се използва?
   It is used to prevent the resubmission of a form caused by reloading the same web page after submitting the form. It removes redundancy of content to strengthen the SEO and makes the website user friendly.

9. Избройте някои по-често срещани HTTP status-и?

10. Какви недостатъци има HTTP/2?

11. Каквo представлява HTTP/3?