package maevskii.studio.event.domain.model;

public record Chat(
        String id,
        long eventId,
        String lastMessage,
        String lastMessageSenderName,
        boolean isUnread
) { }
