package health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
public class MeetupHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named("Check all meetups ")
                .withData("check 1", "ok")
                .withData("check 2", "ok")
                .withData("check 3", "ok")
                .up()
                .build();
    }
}
