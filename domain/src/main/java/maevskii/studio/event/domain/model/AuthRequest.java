package maevskii.studio.event.domain.model;

public record AuthRequest(
        String email,
        String password
) {}
