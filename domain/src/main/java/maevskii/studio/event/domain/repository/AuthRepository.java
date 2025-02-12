package maevskii.studio.event.domain.repository;

import maevskii.studio.event.domain.model.AuthRequest;
import maevskii.studio.event.domain.model.RegisterRequest;
import maevskii.studio.event.domain.util.CompleteListener;

public interface AuthRepository {
    void login(AuthRequest request, CompleteListener<Object> completeListener);
    void register(RegisterRequest request, CompleteListener<Object> completeListener);
}
