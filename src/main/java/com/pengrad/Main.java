package com.pengrad;

import com.pengrad.telegrambot.request.SetWebhook;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        final String appSite = "";

        final String portNumber = System.getenv("PORT");
        if (portNumber != null) {
            port(Integer.parseInt(portNumber));
        }


        BotHandler[] bots = new BotHandler[]{
        };

        for (BotHandler bot : bots) {
            String token = bot.getToken();
            post("/" + token, bot);
            bot.getBot().execute(new SetWebhook().url(appSite + "/" + token));
        }

        // Bot handler
//        post("/myBot", new TestTelegramBot());
        // simple string by GET
        get("/hello", (req, res) -> "Hello World");

        post("/test", new Test());
        get("/test", new Test());

        get("/env", (request, response) -> System.getenv().toString());
    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) {
            return "ok, test";
        }
    }
}
