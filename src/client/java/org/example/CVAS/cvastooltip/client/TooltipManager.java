package org.example.CVAS.cvastooltip.client;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TooltipManager {
    private static final TooltipManager INSTANCE = new TooltipManager();
    private final Set<String> tooltipTexts = new LinkedHashSet<>();
    private final Path configDir;
    private final Path tooltipFile;
    
    private TooltipManager() {
        this.configDir = FabricLoader.getInstance().getConfigDir().resolve("cvastooltip");
        this.tooltipFile = configDir.resolve("tooltips.yml");
        
        try {
            Files.createDirectories(configDir);
            loadExistingTooltips();
        } catch (IOException e) {
            System.err.println("Failed to initialize tooltip manager: " + e.getMessage());
        }
    }
    
    public static TooltipManager getInstance() {
        return INSTANCE;
    }
    
    public void addTooltip(List<Text> tooltipLines) {
        if (tooltipLines == null || tooltipLines.isEmpty()) {
            return;
        }
        
        // Convert tooltip lines to strings
        List<String> textLines = new ArrayList<>();
        for (Text line : tooltipLines) {
            String text = line.getString().trim();
            if (!text.isEmpty()) {
                textLines.add(text);
            }
        }
        
        if (!textLines.isEmpty()) {
            String tooltipText = String.join(" | ", textLines);
            addTooltipText(tooltipText);
        }
    }
    
    public void addTooltipText(String tooltipText) {
        if (tooltipText == null || tooltipText.trim().isEmpty()) {
            return;
        }
        
        String cleanText = tooltipText.trim();
        if (tooltipTexts.add(cleanText)) {
            // New tooltip text was added, save to file
            saveTooltipsToFile();
        }
    }
    
    private void loadExistingTooltips() {
        if (!Files.exists(tooltipFile)) {
            return;
        }
        
        try {
            Yaml yaml = new Yaml();
            Object data = yaml.load(Files.newInputStream(tooltipFile));
            
            if (data instanceof List<?> list) {
                for (Object item : list) {
                    if (item instanceof String text) {
                        tooltipTexts.add(text);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load existing tooltips: " + e.getMessage());
        }
    }
    
    private void saveTooltipsToFile() {
        try {
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            options.setIndent(2);
            
            Yaml yaml = new Yaml(options);
            
            try (FileWriter writer = new FileWriter(tooltipFile.toFile())) {
                yaml.dump(new ArrayList<>(tooltipTexts), writer);
            }
            
            System.out.println("Saved " + tooltipTexts.size() + " unique tooltips to " + tooltipFile);
        } catch (IOException e) {
            System.err.println("Failed to save tooltips: " + e.getMessage());
        }
    }
    
    public Set<String> getTooltipTexts() {
        return new LinkedHashSet<>(tooltipTexts);
    }
      public int getTooltipCount() {
        return tooltipTexts.size();
    }
    
    public void forceSave() {
        saveTooltipsToFile();
    }
    
    public void clearTooltips() {
        tooltipTexts.clear();
        saveTooltipsToFile();
    }
}
