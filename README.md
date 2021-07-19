[![License](https://img.shields.io/github/license/Blackoutburst/BasicAFK.svg)](LICENSE)
[![Release](https://img.shields.io/github/release/Blackoutburst/BasicAFK.svg)](https://github.com/Blackoutburst/BasicAFK/releases)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/12631080eb1d4e1d8a4dc747a55981af)](https://www.codacy.com/gh/Blackoutburst/BasicAFK/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Blackoutburst/BasicAFK&amp;utm_campaign=Badge_Grade)

# BasicAFK
A really basic AFK plugin

## What it does
It display whatever you want after the player name when he is AFK for any specified amount of time

Default being bold red AFK after 60s of inactivity

![image](https://user-images.githubusercontent.com/30992311/126196413-efada12e-6f22-43a5-825f-f2cdfa740129.png)

## Commands
`/AFK` make you afk instantly\
`/setAfkTime` set the delay needed to be considered AFK (note a plugin reload is needed to update this `/reload`)\
`/reload` reload the configuration file needed after any modification of the `plugin.yml` or after `/setAfkTime`

## Default Configuration
```yml
afkDelay: 60
afkDisplay: " §4§lAFK§r"
```

Note for the AFK display both `§` and `&` are supported for the color

## API
If you need to know who is afk,

In your plugin.yml
```yml
depend: [BasicAFK]
```

Then this should return either `true` or `false` if the player is AFK or not
```java
AfkPlayer.get(Player).isAfk();
```
