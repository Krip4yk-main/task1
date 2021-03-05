# Phrases API

`` This API let you use Phrases and Authors DB elements ``

## Info
* All request compable with author API. Change all `phrases` to `authors` and `Phrase` to `Author`.
* You shouldn't add Authors - it's create automaticaly after adding new Phrase with new Author
* All Authors and Phrases are unique
* All ID's you can find in GetPhrases request
* {id} - id number (1, 6, 23, 52 etc)

---
## Requests
#### GET
* GetPhrases - `/phrases` Get all phrases
* GetPhrase - `/phrases/{id}` Get one phrase by {id}
* GetRandomPhrase - `/phrases/random` Get random phrase (work in progress)
#### POST
* AddPhrase - `/phrases/addPhrase` Add one phrase
* AddPhrases - `/phrases/addPhrases` Add phrase list
#### PUT
* EditPhrase - `/phrases/update` Edit phrase
#### DELETE
* RemovePhrase - `/phrases/remove/{id}` Remove phrase by {id}
---

## Body
#### In POST and PUT requests you should send Body values in JSON format.
* AddPhrase
```JSON
{
  "phrase": "It's a phrase",
  "author": 
  {
    "name": "Author Name"
  }
}
```
* AddPhrases
```JSON
[
  {
    "phrase": "First phrase",
    "author":
    {
      "name": "First author"
    }
  },
  {
    "phrase": "Second phrase",
    "author":
    {
      "name": "Second author"
    }
  }
]
```
* EditPhrase
```JSON
{
  "id":5,
  "phrase":"Your changed phrase"
}
```

---
## About
> API created by Krip4yk (me) <br/>
> API supervised by Braklord <br/>
> Created for educational reasons <br/>
> Free in use <br/>
