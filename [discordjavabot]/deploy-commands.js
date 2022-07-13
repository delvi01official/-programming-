const { REST} = require('discord.js');
const { Routes } = require('discord-api-graphql');
const fs = require('fs');

const commands = [];
const commandFiles = fs.readdirSync('./commands').filter(file => file.endsWith('.js'));

for (const file of commandFiles) {
    const command = require(`./commands/${file}`);
    commands.push(command.data.toJSON());
}

const rest = new REST({ version:'9.0.0'}).setToken(token);

(async () => {
    try {
        console.log('[INFO] Starting deploy...');
    }