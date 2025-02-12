package maevskii.studio.event.domain.util;

import maevskii.studio.event.domain.model.Result;

public interface CompleteListener<T> {
    void onComplete(Result<T> result);
}
