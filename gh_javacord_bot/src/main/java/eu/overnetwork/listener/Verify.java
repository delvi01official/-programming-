package eu.overnetwork.listener;

import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.listener.interaction.SlashCommandCreateListener;

public class Verify implements SlashCommandCreateListener {
    @Override
    public void onSlashCommandCreate(SlashCommandCreateEvent slashCommandCreateEvent) {
        SlashCommandInteraction interaction = slashCommandCreateEvent.getSlashCommandInteraction();

        //give user the role 987681865437704202

        if (interaction.getCommandName().equals("verify")) {
            interaction.getApi().getYourself().addRole(interaction.getApi().getRoleById(987681865437704202L).get());
            EmbedBuilder verify = new EmbedBuilder();
            verify.setTitle("Verified");
            verify.addField("Verification", "You are now verified");
            verify.setThumbnail(interaction.getUser().getAvatar());
            verify.setFooter("EsslessV Test", interaction.getApi().getYourself().getAvatar());
            interaction.createImmediateResponder().addEmbed(verify).setFlags(MessageFlag.EPHEMERAL).respond();


        }
    }
}
