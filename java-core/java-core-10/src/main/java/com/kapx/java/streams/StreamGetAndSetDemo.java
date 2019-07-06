package com.kapx.java.streams;

import com.kapx.java.optional.NotFoundException;

import java.util.Optional;
import java.util.function.Function;

public class StreamGetAndSetDemo {
    private static final Function<MessageEntity, MessageDto> copyFunction = (final MessageEntity entity) -> {
        return toMessageDto(entity);
    };

    private static MessageDto toMessageDto(final MessageEntity entity) {
        return new MessageDto(entity.getMessage());
    }

    private static void printMessage(final MessageDto messageDto) {
        final Optional<String> optionalMessage = Optional.ofNullable(messageDto.getMessage());
        System.out.println(optionalMessage.orElseThrow(NotFoundException::new));
    }

    private static MessageEntity getMessageEntity() {
        return new MessageEntity("Test Message");
    }

    public static void main(String[] args) {
        final MessageEntity messageEntity = getMessageEntity();
        final MessageDto messageDto = copyFunction.apply(messageEntity);
        printMessage(messageDto);
    }
}
