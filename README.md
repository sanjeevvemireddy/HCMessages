# Chat Message Parser

This is a RESTFul service that has PUT operation which takes an input string as plain text and returns a json string whcih identifies user name mentions, Emoticons and Links in the input string. 

TODO
------------------

Development of this  service is still in progress. Below tasks are still pending.
1. Implement logic to retrieve title.
2. Handle exceptions and return HTTP error codes accordingly.
3. Authenticate / validate input request
4. Complete Unit Tests for Links.
5. Add logging.


Technology
-------------------
* JEE7

Dependencies
-------------------
* [Gson](https://code.google.com/p/google-gson/) - For json object mapping 
* [JUnit](https://junit.org/junit5/) - For Unit testing 
* [jersey(JAX-RS](https://jersey.github.io/) - For RESTFul API implementation
* [maven](https://maven.apache.org/) - build tool

Requirements:
------------------ 

Parsing of input is done as for the following :

1. mentions - A way to mention a user. Always starts with an '@' and ends when hitting a non-word character. (https://confluence.atlassian.com/hipchat/get-teammates-attention-744328217.html)

2. Emoticons - For this exercise, you only need to consider 'custom' emoticons which are alphanumeric strings, no longer than 15 characters, contained in parenthesis. You can assume that anything matching this format is an emoticon. (https://www.hipchat.com/emoticons)

3. Links - Any URLs contained in the message, along with the page's title.

Build
----------------

mvn package

Run 
---------------

Deploy the built war file to any J2EE compliant application server

Test
--------------

Use any REST client like SoapUI / chrome extensions and submit a PUT request. 
Sample url : http://localhost:8084/HCMessages/webresources/parse

Output
---------

    Input: "@chris you around?"
    Return:
    {
      "mentions": [
        "chris"
      ]
    }

    Input: "Good morning! (megusta) (coffee)"
    Return:
    {
      "emoticons": [
        "megusta",
        "coffee"
      ]
    }

    Input: "Olympics are starting soon; http://www.nbcolympics.com"
    Return:
    {
      "links": [
        {
          "url": "http://www.nbcolympics.com",
          "title": "2016 Rio Olympic Games | NBC Olympics"
        }
      ]
    }

    Input: "@bob @john (success) such a cool feature; https://twitter.com/jdorfman/status/430511497475670016"
    Return:
    {
      "mentions": [
        "bob",
        "john"
      ],
      "emoticons": [
        "success"
      ],
      "links": [
        {
          "url": "https://twitter.com/jdorfman/status/430511497475670016",
          "title": "Justin Dorfman on Twitter: &quot;nice @littlebigdetail from @HipChat (shows hex colors when pasted in chat). http://t.co/7cI6Gjy5pq&quot;"
        }
      ]
    }
