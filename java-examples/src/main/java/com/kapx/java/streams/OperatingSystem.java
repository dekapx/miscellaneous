package com.kapx.java.streams;

import java.util.HashSet;
import java.util.Set;

public class OperatingSystem {
    private String id;
    private String family;
    private Set<NetworkAdapter> networkAdapters;

    public OperatingSystem(final String id, final String family) {
        this.id = id;
        this.family = family;
        this.networkAdapters = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public Set<NetworkAdapter> getNetworkAdapters() {
        return networkAdapters;
    }
}
