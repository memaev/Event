package maevskii.studio.event.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import maevskii.studio.event.domain.model.AuthRequest;
import maevskii.studio.event.domain.model.RegisterRequest;
import maevskii.studio.event.domain.model.Result;
import maevskii.studio.event.domain.util.CompleteListener;
import maevskii.studio.event.domain.util.Const;

public class AuthRepository implements maevskii.studio.event.domain.repository.AuthRepository {

    private FirebaseAuth auth;
    private final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @Override
    public void login(AuthRequest request, CompleteListener<Object> completeListener) {
        auth.signInWithEmailAndPassword(request.email(), request.password())
                .addOnCompleteListener((task) -> {
                    completeListener.onComplete(new Result<>(
                            task.isSuccessful(),
                            (task.getException() != null) ? task.getException().getMessage() : null,
                            null
                    ));
                });
    }

    @Override
    public void register(RegisterRequest request, CompleteListener<Object> completeListener) {
        auth.createUserWithEmailAndPassword(request.email(), request.email())
                .addOnCompleteListener((task) -> {
                    if (task.isSuccessful() && task.getResult().getUser() != null) {
                        addUserToDb(task.getResult().getUser().getUid(), request.toMap(), completeListener);
                    }
                });
    }

    private void addUserToDb(String userId, Map<String, String> userInfo, CompleteListener<Object> completeListener) {
        database.child(Const.Users).child(userId).setValue(userInfo)
                .addOnCompleteListener((task -> {
                    completeListener.onComplete(new Result<>(
                            task.isSuccessful(),
                            (task.getException() != null) ? task.getException().getMessage() : null,
                            null
                    ));
                }));
    }
}
