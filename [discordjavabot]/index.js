const fs = require('fs');
const{
    Client,
    Collection,
    Intents
} = require('discord.js');
const config = require('./config.json');

const client = new Client({
    intents: [Intents.FLAGS.GUILDS, Intents.FLAGS.GUILD_MESSAGES, Intents.FLAGS.GUILD_MEMBERS],
    });

    const Discord = require('discord.js');
    client.discord = Discord;
    client.config = config;

    client.commands = new Collection();
    const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));

    for (const file of commandFiles) {
        const command = require(`./commands/${file}`);
        client.commands.set(command.name, command);
    }

    const eventFiles = fs.readdirSync('./events').filter(file => file.endsWith('.js'));

    for (const file of eventFiles) {
        const event = require(`./events/${file}`);
          client.on(event.name, (...args) => event.execute(...args, client));
      };

      client.on('interactionCreate', async (message) => {
          if (message.channel.type === 'dm') return;

          const command = client.commands.get(interection.commandName);
          if (!command) return;


          try {
              await command.excute(interection, client, config);
          } catch (error) {
                console.error(error);
            }
            return interection.reply({
                content: 'There was an error trying to execute that command!'
                ephemeral: true
            });
        };
      });

      client.login(config.token);


    