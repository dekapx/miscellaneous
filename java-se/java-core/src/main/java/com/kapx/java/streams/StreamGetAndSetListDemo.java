package com.kapx.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamGetAndSetListDemo {
    private static final Function<MessageEntity, MessageDto> transformFunction = (final MessageEntity entity) -> {
        return toMessageDto(entity);
    };

    private static MessageDto toMessageDto(final MessageEntity entity) {
        return new MessageDto(entity.getMessage());
    }

    private static List<MessageEntity> getMessageEntities() {
        return Arrays.asList(new MessageEntity("Message-1"), new MessageEntity("Message-2"));
    }

    public static void main(String[] args) {
        transformUsingMap();
        transformUsingForEach();
    }

    private static void transformUsingMap() {
        final List<MessageEntity> entities = getMessageEntities();
        List<MessageDto> result = entities
                .parallelStream()
                .filter(entity -> entity.getMessage().equals("Message-2"))
                .map(transformFunction).collect(Collectors.toList());
        result.stream().map(dto -> dto.getMessage()).forEach(System.out::print);
    }

    private static void transformUsingForEach() {
        final List<MessageDto> dtos = new ArrayList<>();
        final List<MessageEntity> entities = getMessageEntities();
        entities
                .stream()
                .filter(entity -> entity.getMessage().equals("Message-2"))
                .forEach(entity -> {
                    final MessageDto messageDto = transformFunction.apply(entity);
                    dtos.add(messageDto);
                });
        dtos.stream().map(dto -> dto.getMessage()).forEach(System.out::print);
    }
}
