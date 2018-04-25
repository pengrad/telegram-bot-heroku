package com.pengrad;

import com.pengrad.telegrambot.request.SetWebhook;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        final String portNumber = System.getenv("PORT");
        if (portNumber != null) {
            port(Integer.parseInt(portNumber));
        }

        // current app url to set webhook
        // should be set via heroku config vars
        // https://devcenter.heroku.com/articles/config-vars
        // heroku config:set APP_URL=https://app-for-my-bot.herokuapp.com
        final String appUrl = System.getenv("APP_URL");

        // define list of bots
        BotHandler[] bots = new BotHandler[]{
                new TestTelegramBot()
        };

        // set bot to listen https://my-app.heroku.com/BOTTOKEN
        // register this URL as Telegram Webhook
        for (BotHandler bot : bots) {
            String token = bot.getToken();
            post("/" + token, bot);
            bot.getBot().execute(new SetWebhook().url(appUrl + "/" + token));
        }

        // can declare other routes
        get("/hello", (req, res) -> "Hello World");
        post("/test", new Test());
        get("/test", new Test());
    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) {
            return "ok, test";
        }
    }
}
