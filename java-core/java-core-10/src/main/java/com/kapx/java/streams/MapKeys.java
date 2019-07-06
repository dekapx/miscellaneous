package com.kapx.java.streams;

import java.util.HashMap;
import java.util.Map;

public class MapKeys {
	public static void main(String[] args) {
		final String id = "consistencyGroupId";
		final String time = "createTime.MIN";

		final Map<String, String> params = new HashMap<>();
		params.put("CONSiSTENCYgrouPID", "1");
		params.put("cREaTEtimE.MiN", "2016-06-21");

		try {
			System.out.println(findKey(params, id, ""));
			System.out.println(findKey(params, time, ""));

			System.out.println(findKey(params, "cREaTEtimE.MiN", "time not found"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String findKey(final Map<String, String> params, final String key, final String errorMessage) throws Exception {
		return params.entrySet().stream().filter(map -> map.getKey().equalsIgnoreCase(key)).map(map -> map.getKey().toLowerCase()).findFirst()
				.orElseThrow(() -> new Exception(errorMessage));
	}
}
