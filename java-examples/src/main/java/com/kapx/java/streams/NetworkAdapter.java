package com.kapx.java.streams;

public class NetworkAdapter {
    private String id;
    private String name;
    private boolean defaultAdapter;
    private OperatingSystem operatingSystem;

    public NetworkAdapter(final String id, final String name, final boolean defaultAdapter, final OperatingSystem operatingSystem) {
        this.id = id;
        this.name = name;
        this.defaultAdapter = defaultAdapter;
        this.operatingSystem = operatingSystem;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDefaultAdapter() {
        return defaultAdapter;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
}
