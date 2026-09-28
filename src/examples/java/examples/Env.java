package examples;

/** Reads example settings from environment variables. Never hard-code keys or phone numbers. */
final class Env {

    private Env() {
    }

    static String get(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("환경변수 " + name + "를 설정하세요 (src/examples/README.md 참고)");
        }
        return value;
    }
}
