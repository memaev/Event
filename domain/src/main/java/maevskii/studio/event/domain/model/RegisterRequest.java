package maevskii.studio.event.domain.model;

public record RegisterRequest(
        String name,
        String email,
        String password
) { }
