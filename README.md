# StayYoung

[![](https://img.shields.io/modrinth/v/CER9h76l?style=for-the-badge) ![](https://img.shields.io/modrinth/dt/CER9h76l?style=for-the-badge)](https://modrinth.com/mod/stay-young)

A small plugin to easily age-lock a selected mob by right-clicking with a configurable item (poisonous potato by default).
Works on all ageable mobs like villagers, cows and foxes.

## Downloads

Downloads can be obtained from our page on [Modrinth](https://modrinth.com/mod/stay-young).

## Default configuration

```yaml
---
debug: false # Enable debug mode
trigger_item: POISONOUS_POTATO # Item you need to have in your main hand when right-clicking
success_sound: ENTITY_EXPERIENCE_ORB_PICKUP # Sound played when mob is successfully age-locked
success_particle: VILLAGER_HAPPY # Particle spawned when mob is successfully age-locked
failure_sound: ENTITY_PLAYER_BURP # Sound played when player tries to age-lock an already age-locked mob
```

## Building

Use `./gradlew build`.
