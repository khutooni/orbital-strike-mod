# Orbital Strike Cannon Mod

A Minecraft Fabric mod for version 1.26.1 that adds two orbital cannon items with dramatic effects.

## Features

### Nuke Shot
- **How to get:** Use `/orbital_nuke` command or craft with Fishing Rod + 8x TNT
- **Effect:** After 2 seconds, spawns 15 concentric TNT rings in the sky and detonates them
- **Durability:** 1 use only
- **Sound:** Shield break sound when used

### Stab Shot
- **How to get:** Use `/orbital_stab` command or craft with Fishing Rod + 4x TNT + 4x Stone
- **Effect:** After 2 seconds, spawns a TNT column from Y=319 to Y=-64 and detonates instantly
- **Durability:** 1 use only
- **Sound:** Shield break sound when used

## Crafting Recipes

### Nuke Shot (Fishing Rod + 8x TNT)
```
T T T
T F T
T T T
```
(T = TNT, F = Fishing Rod)

### Stab Shot (Fishing Rod + 4x TNT + 4x Stone)
```
T S T
S F S
T S T
```
(T = TNT, S = Stone, F = Fishing Rod)

## Commands

- `/orbital_nuke` - Gives you a Nuke Shot
- `/orbital_stab` - Gives you a Stab Shot

## How to Build

### Prerequisites
1. Install Java 21 from [Adoptium](https://adoptium.net/)
2. Install [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/)

### Build Steps

1. **Download and Extract**
   - Go to: https://github.com/khutooni/orbital-strike-mod
   - Click green "Code" button → "Download ZIP"
   - Extract the downloaded file

2. **Open in IntelliJ IDEA**
   - Open IntelliJ
   - File → Open
   - Select the extracted orbital-strike-mod folder
   - Wait for Gradle to sync (2-3 minutes)

3. **Build the mod**
   - Open Terminal in IntelliJ (View → Tool Windows → Terminal)
   - Run: `./gradlew build`
   - Wait for the build to complete (2-5 minutes)

4. **Find your .jar file**
   - The compiled mod will be at: `build/libs/orbitalstrike-1.0.0.jar`
   - This is the file you upload to Modrinth

### Upload to Modrinth

1. Go to [Modrinth](https://modrinth.com)
2. Create a new project or update existing
3. Upload the `orbitalstrike-1.0.0.jar` file
4. Fill in:
   - Minecraft Version: 1.26.1
   - Loader: Fabric
   - Loader Version: 0.16.9+
5. Publish!

## Requirements

- Minecraft 1.26.1
- Fabric Loader >=0.15.0
- Fabric API

## License

MIT License

## Author

khutooni
