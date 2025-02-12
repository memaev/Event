package maevskii.studio.event.domain.model;

public record Result<T>(
        boolean isSuccessful,
        String message,
        T data
) { }
