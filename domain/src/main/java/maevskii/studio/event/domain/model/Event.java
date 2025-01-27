package maevskii.studio.event.domain.model;

import java.util.List;

public record Event(
        long id,
        String eventOwnerId,
        long publishingTimestamp,
        long eventStartTimestamp,
        double addressLatitude,
        double addressLongitude,
        String eventTitle,
        String eventDescription,
        List<String> participantsIds
) { }
