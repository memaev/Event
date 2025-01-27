package maevskii.studio.event.domain.model;

public record EventReview(
        long id,
        long eventId,
        String reviewOwnerId,
        String reviewTitle,
        String reviewText,
        int rate, // from 1 to 5
        long publishingTimestamp
) implements FeedPost {}
