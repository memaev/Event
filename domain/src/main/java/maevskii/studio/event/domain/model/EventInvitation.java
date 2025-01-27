package maevskii.studio.event.domain.model;

import java.util.List;

public record EventInvitation(
        long id,
        long eventId,
        String invitationOwnerId,
        int maximumAmount, // maximum amount of members registered to the event, -1 if infinity
        int currentParticipantsAmount,
        long publishingTimestamp
) implements FeedPost { }
