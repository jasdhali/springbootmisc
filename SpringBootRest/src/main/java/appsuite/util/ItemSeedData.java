package appsuite.util;

import java.util.HashMap;
import java.util.Map;

import appsuite.domain.Item;

public class ItemSeedData {
	public static Map<Long, Item> seedData = new HashMap<Long, Item>();

	static {

		Item i1 = new Item(1l, "OO-CAT001-1", 10);
		Item i2 = new Item(2l, "OO-CAT001-2", 5);
		Item i3 = new Item(3l, "OO-CAT001-3", 11);
		Item i4 = new Item(4l, "OO-CAT001-1", 100);
		Item i5 = new Item(5l, "OO-CAT001-2", 101);
		Item i6 = new Item(6l, "OO-CAT001-3", 3);
		Item i7 = new Item(7l, "OO-CAT001-1", 40);

		seedData.put(i1.getId(), i1);
		seedData.put(i2.getId(), i2);
		seedData.put(i3.getId(), i3);
		seedData.put(i4.getId(), i4);
		seedData.put(i5.getId(), i5);
		seedData.put(i6.getId(), i6);
		seedData.put(i7.getId(), i7);

	}

	public static Map<Long, Item> getSeedData() {

		return seedData;

	}

	public static void setSeedData(Map<Long, Item> seedData) {

		ItemSeedData.seedData = seedData;

	}
}
