package bilzox.acemix.studios;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class SmallTextExpansion extends PlaceholderExpansion {
    private static final String[] UPPERCASE_SMALL = new String[]{"ᴀ", "ʙ", "ᴄ", "ᴅ", "ᴇ", "ꜰ", "ɢ", "ʜ", "ɪ", "ᴊ", "ᴋ", "ʟ", "ᴍ", "ɴ", "ᴏ", "ᴘ", "ǫ", "ʀ", "ѕ", "ᴛ", "ᴜ", "ᴠ", "ᴡ", "x", "ʏ", "ᴢ"};
    private static final String[] LOWERCASE_SMALL;

    public String getIdentifier() {
        return "smalltext";
    }

    public String getAuthor() {
        return "Acemix";
    }

    public String getVersion() {
        return "1.0";
    }

    public String onRequest(OfflinePlayer player, String identifier) {
        if (identifier != null && !identifier.isEmpty()) {
            if (identifier.startsWith("(") && identifier.endsWith(")")) {
                String input = identifier.substring(1, identifier.length() - 1);
                return this.convertToSmallCaps(input);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private String convertToSmallCaps(String input) {
        StringBuilder result = new StringBuilder();
        char[] var3 = input.toCharArray();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            char c = var3[var5];
            if (c >= 'A' && c <= 'Z') {
                result.append(UPPERCASE_SMALL[c - 65]);
            } else if (c >= 'a' && c <= 'z') {
                result.append(LOWERCASE_SMALL[c - 97]);
            } else {
                result.append(c);
            }
        }

        return result.toString();

    }

    static {

        LOWERCASE_SMALL = UPPERCASE_SMALL;

    }
}