package com.kapx.java.streams;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamBuildersComplexTypes
{
    public static void main(String[] args)
    {
//        final NetworkAdapter defaultAdapter = getDefaultNetworkAdapterForOS1();
        final NetworkAdapter defaultAdapter = getDefaultNetworkAdapterForOS2();
        System.out.println(defaultAdapter.getId() + " - " + defaultAdapter.getName() + " - " + defaultAdapter.isDefaultAdapter());
    }

    private static NetworkAdapter getDefaultNetworkAdapterForOS1()
    {
        final OperatingSystem operatingSystem = new OperatingSystem("OS100", "Windows");
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win1000", "Network Adapter 1", Boolean.TRUE, operatingSystem));
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win2000", "Network Adapter 2", Boolean.FALSE, operatingSystem));
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win3000", "Network Adapter 3", Boolean.FALSE, operatingSystem));

        final Set<NetworkAdapter> networkAdapters = operatingSystem.getNetworkAdapters();
        return networkAdapters
                .stream()
                .filter(networkAdapter -> networkAdapter.isDefaultAdapter())
                .findFirst().orElseThrow(() -> new RuntimeException("Not found..."));
    }


    private static NetworkAdapter getDefaultNetworkAdapterForOS2()
    {
        final OperatingSystem operatingSystem = new OperatingSystem("OS100", "Windows");
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win1000", "Network Adapter 1", Boolean.TRUE, operatingSystem));
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win2000", "Network Adapter 2", Boolean.FALSE, operatingSystem));
        operatingSystem.getNetworkAdapters().add(new NetworkAdapter("Win3000", "Network Adapter 3", Boolean.FALSE, operatingSystem));

        /**
        .filter(PortRangeDto::isPortRange)
                        .filter(portRangeDto -> Collections.frequency(portRangeDtoList, portRangeDto) > 1)
                        .distinct()
                        .limit(maxNumberItems)
                        .collect(Collectors.toList());

         - sample code for using map with streams and apply filter -
        final Map<NetworkAdapterType, Boolean> networkAdapters = operatingSystem.getNetworkAdapters();
        final List<NetworkAdapterType> defaultAdapters = networkAdapters.entrySet()
                .stream()
                .filter(map -> map.getValue() == true)
                .map(map -> map.getKey())
                .collect(Collectors.toList());

        final Map<NetworkAdapterType, Boolean> networkAdapters = operatingSystem.getNetworkAdapters();
        final boolean isDefaultAdapter = networkAdapters.entrySet()
                .stream()
                .filter(map -> map.getKey().equals(NetworkAdapterType.valueOf(networkAdapterName)))
                .filter(map -> map.getValue() == true)
                .map(map -> map.getValue())
                .findFirst().orElseThrow(() -> new RuntimeException("{0} is not valid NetworkAdapter for OperatingSystem ID: {1}", networkAdapterName, operatingSystemId));

         public NetworkAdapterType findDefaultNetworkAdapter() {
         	return networkAdapters.entrySet().stream().filter(Map.Entry::getValue)
         			.map(Map.Entry::getKey).findFirst().orElseThrow(() -> new IllegalStateException("OS " + id + " has no default Network Adapter Type"));
         }
        **/

        final Set<NetworkAdapter> networkAdapters = operatingSystem.getNetworkAdapters();
        final List<NetworkAdapter> defaultAdapters = networkAdapters
                .stream()
                .filter(networkAdapter -> networkAdapter.isDefaultAdapter())
                .collect(Collectors.toList());
        if (defaultAdapters.size() != 1) {
            throw new RuntimeException("Zero or more elements found");
        } else {
            return defaultAdapters.iterator().next();
        }
    }
}
