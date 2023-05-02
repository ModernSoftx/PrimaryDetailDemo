package com.nain.primarydetaildemo.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample website_name for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();


    static {

        addItem(new PlaceholderItem("1", "Google", "https://www.google.com"));

        addItem(new PlaceholderItem("2", "Amazon", "https://www.amazon.com"));

        addItem(new PlaceholderItem("3", "Microsoft", "https://www.microsoft.com"));

    }
    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A placeholder item representing a piece of website_name.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String website_name;
        public final String website_url;

        public PlaceholderItem(String id, String website_name, String website_url) {
            this.id = id;
            this.website_name = website_name;
            this.website_url = website_url;
        }

        @Override
        public String toString() {
            return website_name;
        }
    }
}