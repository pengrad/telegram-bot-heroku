# Hosting Telegram Bot on Heroku
Deploy Telegram Bots on [Heroku](http://www.heroku.com/) with [Java API](https://github.com/pengrad/java-telegram-bot-api)

## Installation

Clone the repository from Github

    $ git clone https://github.com/pengrad/telegram-bot-heroku
    
With the [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli), create your app    
    
    $ cd telegram-bot-heroku/
    $ heroku create
    Creating app... done, ⬢ pacific-fjord-59659
    https://pacific-fjord-59659.herokuapp.com/ | https://git.heroku.com/pacific-fjord-59659.git

Deploy

    $ git push heroku master


[comment]: # (Set created app url as config var https://devcenter.heroku.com/articles/config-vars)
[comment]: # ($ heroku config:set APP_URL=https://pacific-fjord-59659.herokuapp.com)
