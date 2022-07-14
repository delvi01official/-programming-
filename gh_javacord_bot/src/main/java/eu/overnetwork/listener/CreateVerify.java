package eu.overnetwork.listener;

import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class CreateVerify implements SlashCommandCreateListener {

    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent event) {
        SlashCommandInteraction interaction = event.getSlashCommandInteraction();

        if (interaction.getCommandName().equals("create-verify-embed")) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Over-Network ");
            embed.addField("Verification", "Please use the application command `/verify` to get verified");
            embed.setFooter("", interaction.getApi().getYourself().getAvatar());
            interaction.createImmediateResponder().addEmbed(embed).respond();
        }

    }
}

