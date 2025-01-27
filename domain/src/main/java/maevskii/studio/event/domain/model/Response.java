package maevskii.studio.event.domain.model;

public record Response(
        boolean isSuccessful,
        String message
) { }
