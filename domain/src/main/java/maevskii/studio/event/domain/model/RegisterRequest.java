package maevskii.studio.event.domain.model;

import java.util.HashMap;
import java.util.Map;

import maevskii.studio.event.domain.util.Const;

public record RegisterRequest(
        String name,
        String email,
        String password
) {
    public Map<String, String> toMap() {
        return new HashMap<>(){{ put(Const.email, email); put(Const.name, name);}};
    }
}
