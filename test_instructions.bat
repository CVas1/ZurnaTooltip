@echo off
echo ============================================
echo CvasTooltip Mod - Testing Instructions
echo ============================================
echo.
echo The Minecraft client should now be running with the CvasTooltip mod loaded.
echo.
echo TO TEST THE MOD:
echo 1. Open your inventory (E key)
echo 2. Hover over various items to collect tooltips
echo 3. Open a chest or crafting table and hover over items
echo 4. Use the in-game commands:
echo    - /tooltips stats   (shows number of collected tooltips)
echo    - /tooltips save    (manually save tooltips)
echo    - /tooltips clear   (clear all tooltips)
echo.
echo EXPECTED BEHAVIOR:
echo - Tooltips are automatically collected when you hover over items
echo - Unique tooltips are saved to: config/cvastooltip/tooltips.yml
echo - Duplicate tooltips are ignored
echo.
echo TO VIEW COLLECTED TOOLTIPS:
echo - Navigate to: .minecraft/config/cvastooltip/tooltips.yml
echo - Or use /tooltips stats command to see count
echo.
echo TO STOP:
echo - Close the Minecraft client
echo - Check the tooltips.yml file for collected data
echo.
echo ============================================
pause
