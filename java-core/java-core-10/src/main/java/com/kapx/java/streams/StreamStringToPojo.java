package com.kapx.java.streams;

import com.kapx.java.common.model.MessageType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StreamStringToPojo {
    public static void main(String[] args) {
        final String[] messages = {"Sync", "Async", "Reactive"};

        final List<MessageType> messageTypes = toMessageType(messages);

        messageTypes.stream().map(m -> m.getMessage()).forEach(print);
    }

    private static List<MessageType> toMessageType(final String[] languages) {
        return Arrays
                .stream(languages)
                .map(MessageType::new)
                .collect(Collectors.toList());
    }

    private static Consumer<String> print = (arg) -> {
        System.out.println(arg);
    };
}
