package io.github.icommapi.bizgo;

import java.time.Duration;

/** How the transport waits between retries. Replaced in tests so they do not slow down. */
@FunctionalInterface
interface Sleeper {

    Sleeper SYSTEM = duration -> Thread.sleep(duration.toMillis());

    void sleep(Duration duration) throws InterruptedException;
}
