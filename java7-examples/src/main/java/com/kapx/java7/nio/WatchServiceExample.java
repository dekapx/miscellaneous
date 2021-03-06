package com.kapx.java7.nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceExample {

	public WatchServiceExample() {
		init();
	}

	private void init() {
		try {
			FileSystem fileSystem = FileSystems.getDefault();
			WatchService watchService = fileSystem.newWatchService();
			Path directory = Paths.get("C:/Local/Temp");
			WatchEvent.Kind<?>[] events = { StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY };
			directory.register(watchService, events);
			while (true) {
				System.out.println("Waiting for a watch event");
				WatchKey watchKey = watchService.take();
				System.out.println("Path being watched: " + watchKey.watchable());
				if (watchKey.isValid() == false) {
					return;
				}
				for (WatchEvent<?> event : watchKey.pollEvents()) {
					System.out.println("Kind: " + event.kind());
					System.out.println("Context: " + event.context());
					System.out.println("Count: " + event.count());
					System.out.println();
				}
				boolean valid = watchKey.reset();
				System.out.println(valid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		new WatchServiceExample();
	}
}
