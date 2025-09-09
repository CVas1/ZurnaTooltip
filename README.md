# CvasTooltip - Minecraft Tooltip Extraction Mod

A Minecraft Fabric mod that automatically extracts tooltip texts and saves them to a YAML file, avoiding duplicates.

## Features

- **Automatic Tooltip Collection**: Captures tooltip texts when hovering over items
- **Duplicate Prevention**: Only saves unique tooltip texts to avoid redundancy
- **YAML Output**: Saves collected tooltips in a clean YAML format
- **Client Commands**: Provides commands to manage tooltip collection
- **Persistent Storage**: Automatically saves to `config/cvastooltip/tooltips.yml`

## Installation

1. Download and install [Fabric Loader](https://fabricmc.net/use/installer/)
2. Install [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
3. Place the `cvastooltip-1.0.jar` in your mods folder
4. Launch Minecraft

## Usage

### Automatic Collection
The mod automatically starts collecting tooltip texts as soon as you launch the game. Simply hover over any item to have its tooltip captured.

### Commands
Use these commands in-game to manage tooltip collection:

- `/tooltips stats` - Shows how many unique tooltips have been collected
- `/tooltips save` - Manually force save tooltips to file
- `/tooltips clear` - Clear all collected tooltips

### Output File
Tooltips are automatically saved to:
```
.minecraft/config/cvastooltip/tooltips.yml
```

Example output:
```yaml
- "Diamond Sword"
- "Iron Pickaxe | Efficiency II | Unbreaking I"
- "Bread | Restores 5 hunger points"
```

## How It Works

The mod uses Mixin to intercept tooltip rendering calls and extracts the text content. It maintains a set of unique tooltip texts in memory and periodically saves them to a YAML file.

### Supported Tooltip Sources
- Item tooltips in inventories
- Item tooltips in creative menu
- Item tooltips when hovering in GUI screens

## Development

### Building from Source
```bash
./gradlew build
```

### Running for Development
```bash
./gradlew runClient
```

## Technical Details

- **Minecraft Version**: 1.21.5
- **Fabric Loader**: 0.17.2+
- **Dependencies**: Fabric API, SnakeYAML
- **Mixins**: Uses client-side mixins to capture tooltip data

## Configuration

The mod currently has no configuration options. All tooltips are automatically collected and saved to the default location.

## Troubleshooting

### No tooltips being saved
1. Check that the mod is loaded (you should see "CvasTooltip mod initialized" in the logs)
2. Verify the `config/cvastooltip/` directory exists
3. Try using `/tooltips stats` to check if tooltips are being collected

### Mod not loading
1. Ensure you have the correct Minecraft version (1.21.5)
2. Verify Fabric Loader and Fabric API are installed
3. Check the logs for any error messages

## License

All Rights Reserved

## Contributing

This mod is part of the CVAS project. For issues or suggestions, please contact the development team.
