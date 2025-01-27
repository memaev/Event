package maevskii.studio.event.domain.model;

public record Comment(
        long id,
        long reviewPostId,
        String commentOwnerId,
        String commentText,
        long publishingTimestamp
) {
}
