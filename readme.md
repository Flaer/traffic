# REST Service for site traffic accounting


### Database console managing
For manual tables browse
`http://localhost:8080/console`

Connection settings:
JDBC  URL: jdbc:h2:file:./traffic
User Name: sa
Password: (empty)

### Test urls:

**POST** request for site visit registration.
Create visit and return daily statistic in JSON format
URL: `http://localhost:8080/visit`
Body: `{"userId":"user","pageId":"about"}`
Headers: `"Content-Type":"application/json"`
Return example:
```
{"uniqueUsersAmount":2,"visitsAmount":15}
```

**GET** request example for extended statistic:
`http://localhost:8080/statistics?start=2018-03-16&end=2018-03-17`
Return example:
```
{"uniqueUsersAmount":2,"visitsAmount":15,"regularUsersAmount":1}
```
