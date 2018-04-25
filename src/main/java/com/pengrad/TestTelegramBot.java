package com.pengrad;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public class TestTelegramBot extends BotHandler {

    private static final String TOKEN = "this-is-my-token";
    private final TelegramBot bot = new TelegramBot(TOKEN);

    @Override
    void onWebhookUpdate(Update update) {
        Long chatId = update.message().chat().id();
        bot.execute(new SendMessage(chatId, "Hello from bot"));
    }

    @Override
    String getToken() {
        return TOKEN;
    }

    @Override
    TelegramBot getBot() {
        return bot;
    }
}
