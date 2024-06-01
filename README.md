@startuml CHAT REAL TIME

/'----------------------------------------------------------------------
  FORMATAÇÕES GERAIS
  ----------------------------------------------------------------------'/
skinparam diagramBorderColor black
skinparam diagramBorderThickness 3
skinparam participantPadding 20
skinparam defaultFontName helvetica
skinparam defaultFontColor black
skinparam sequenceTitleFontSize 30
skinparam sequenceParticipantBorderColor black
skinparam sequenceParticipantFontSize 14
skinparam actorBackgroundColor transparent
skinparam actorBorderColor black
skinparam actorFontSize 14
skinparam sequenceBoxBorderColor transparent
skinparam sequenceGroupBodyBackgroundColor transparent
skinparam sequenceReferenceBackgroundColor ffffe6
skinparam arrowFontName Courier
skinparam shadowing false
skinparam useBetaStyle true
hide footbox

/'----------------------------------------------------------------------
  PARTICIPANTES
  ----------------------------------------------------------------------'/
box "\nAPI\n" #d3edd6
  participant cli as "Client" #aeeab2
  participant api as "api-ms-chat" #aeeab2
end box
box "\nRecursos\n" #f5e8ba
  participant database as "H2 Database" #f5e5ab
end box

/'----------------------------------------------------------------------
  TITULO
  ----------------------------------------------------------------------'/
title \n\
CHAT REAL TIME\n\
INIT CHAT

/'----------------------------------------------------------------------
  FLUXO
  ----------------------------------------------------------------------'/

cli -> api ++: \n\
<b>Endpoint</b>: /v1/chats/init \n\
<b>Method</b>: POST \n\
<b>Body</b>: \n\
{\n\
    "fromUserId": 1, \n\
    "text": "Hello there!", \n\
    "usersId": [ \n\
        1, \n\
        2 \n\
    ] \n\
} \n
|||

api -> api: Check request body

break#d9d9d9 #f2f2f2 Inconsistent data
|||

api --> cli: \
<b>HTTP 400 (Bad Request)</b> \n\
\n\
{ \n\
    "code": 400, \n\
    "status": "BAD_REQUEST", \n\
    "message": "There's an error in the request", \n\
    "correlationId": "8b775627-45cb-4bf9-9c41-1e779d95a6c7", \n\
    "fields": [ \n\
        { \n\
            "field": "fromUserId", \n\
            "message": "Cannot be null" \n\
        }, \n\
        { \n\
            "field": "fromUserId", \n\
            "message": "Must be positive" \n\
        }, \n\
        { \n\
            "field": "text", \n\
            "message": "Cannot be blank" \n\
        }, \n\
        { \n\
            "field": "usersId", \n\
            "message": "Cannot be null or empty" \n\
        }, \n\
        { \n\
            "field": "usersId", \n\
            "message": "Must have at least 2 usersId" \n\
        } \n\
    ] \n\
  }
|||
end 

api -> api: Checks if the chat already exists

break#d9d9d9 #f2f2f2 Inconsistent data
|||

api --> cli: \
<b>HTTP 400 (Bad Request)</b> \n\
\n\
{ \n\
    "code": 400,  \n\
    "status": "BAD_REQUEST",  \n\
    "message": "Chat already started",  \n\
    "correlationId": "8b775627-45cb-4bf9-9c41-1e779d95a6c7" \n\
} \n\
|||
end 

api -> api: Checks if the users already exists

break#d9d9d9 #f2f2f2 Inconsistent data
|||

api --> cli: \
<b>HTTP 400 (Bad Request)</b> \n\
\n\
{ \n\
    "code": 400,  \n\
    "status": "BAD_REQUEST",  \n\
    "message": "User does not exist - IDs: [1, 2]",  \n\
    "correlationId": "8b775627-45cb-4bf9-9c41-1e779d95a6c7" \n\
} \n\
|||
end 

api -> database ++: \
\n\
Insert data
|||

database --> api: \
Exception
|||

database -> api --: \
\n\
Data saved successfully\n\
\n\
|||

api -> cli: \
<b>HTTP 201 (Created)</b> \n\
{ \n\
    "chatId": 1 \n\
} \n\

@enduml

@startuml CHAT REAL TIME

/'----------------------------------------------------------------------
  FORMATAÇÕES GERAIS
  ----------------------------------------------------------------------'/
skinparam diagramBorderColor black
skinparam diagramBorderThickness 3
skinparam participantPadding 20
skinparam defaultFontName helvetica
skinparam defaultFontColor black
skinparam sequenceTitleFontSize 30
skinparam sequenceParticipantBorderColor black
skinparam sequenceParticipantFontSize 14
skinparam actorBackgroundColor transparent
skinparam actorBorderColor black
skinparam actorFontSize 14
skinparam sequenceBoxBorderColor transparent
skinparam sequenceGroupBodyBackgroundColor transparent
skinparam sequenceReferenceBackgroundColor ffffe6
skinparam arrowFontName Courier
skinparam shadowing false
skinparam useBetaStyle true
hide footbox

/'----------------------------------------------------------------------
  PARTICIPANTES
  ----------------------------------------------------------------------'/
box "\nAPI\n" #d3edd6
  participant cli as "Client" #aeeab2
  participant api as "api-ms-chat" #aeeab2
end box
box "\nRecursos\n" #f5e8ba
  participant database as "H2 Database" #f5e5ab
end box

/'----------------------------------------------------------------------
  TITULO
  ----------------------------------------------------------------------'/
title \n\
CHAT REAL TIME \n\
CREATE USER

/'----------------------------------------------------------------------
  FLUXO
  ----------------------------------------------------------------------'/

cli -> api ++: \n\
<b>Endpoint</b>: /v1/users \n\
<b>Method</b>: POST \n\
<b>Body</b>: \n\
{\n\
    "username": "heycristhian@gmail.com",\n\
    "name": "Cristhian",\n\
    "lastName": "Dias"\n\
}\n\
|||

api -> api: Check request body

break#d9d9d9 #f2f2f2 Inconsistent data
|||

api --> cli: \
<b>HTTP 400 (Bad Request)</b> \n\
\n\
{ \n\
    "code": 400, \n\
    "status": "BAD_REQUEST", \n\
    "message": "There's an error in the request", \n\
    "correlationId": "8b775627-45cb-4bf9-9c41-1e779d95a6c7", \n\
    "fields": [ \n\
        { \n\
            "field": "username", \n\
            "message": "Cannot be blank" \n\
        }, \n\
        { \n\
            "field": "name", \n\
            "message": "Cannot be blank" \n\
        }, \n\
        { \n\
            "field": "lastName", \n\
            "message": "Cannot be blank" \n\
        } \n\
    ] \n\
  }
|||
end 

api -> api: Checks if the username already exists

break#d9d9d9 #f2f2f2 Inconsistent data
|||

api --> cli: \
<b> HTTP 400 (BAD REQUEST) </b> \n\
{ \n\
    "code": 400,  \n\
    "status": "BAD_REQUEST",  \n\
    "message": "Username already exists",  \n\
    "correlationId": "8b775627-45cb-4bf9-9c41-1e779d95a6c7" \n\
} \n\
|||
end

api -> database ++: \
\n\
Insert user
|||

database --> api: \
Exception
|||

database -> api --: \
Users saved succesfully
|||

api -> cli: \
<b>HTTP 201 (CREATED)</b> \n\
{\n\
    "id": 1 \n\
    "username": "heycristhian@gmail.com",\n\
    "name": "Cristhian",\n\
    "lastName": "Dias"\n\
}


@enduml