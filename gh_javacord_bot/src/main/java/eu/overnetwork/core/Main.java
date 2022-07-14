package eu.overnetwork.core;

import eu.overnetwork.listener.CreateVerify;
import eu.overnetwork.listener.Verify;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;

public class Main {

    public static Dotenv dotenv = Dotenv.load();
    public static Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        logger.info("Starting Over-Network");

        String token = dotenv.get("TOKEN");

        DiscordApi api = new DiscordApiBuilder()
                .setToken(token)
                .login().exceptionally(e -> {
                    logger.error("Failed to login", e);
                    return null;
                })
                .join();

        logger.info("Logged in as " + api.getYourself().getName());
        logger.info("Over-Network is now running");

        //get total member of members from 987681620821680169
        long totalMember = api.getServerById("987681620821680169").get().getMemberCount();

        api.updateActivity(ActivityType.WATCHING, String.format("%s members", totalMember));

        logger.info("Over-Network is now running");

        logger.info("Registering application (/) commands...");

        Server server = api.getServerById(987681620821680169L).orElse(null);

        //register commands

        SlashCommand.with("create-verify-embed", "Creates a verify embed").createForServer(server).exceptionally(exception -> {
            logger.error(exception.getMessage());
            return null;

        }).join();

        logger.info("application (/) commands registered successfully");

        logger.info("loading Listeners");

        api.addListener(new CreateVerify());
        api.addListener(new Verify());

        logger.info("Listeners loaded successfully");

        logger.info("Over-Network is now running");


    }
}
