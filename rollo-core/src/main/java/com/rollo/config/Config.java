package com.rollo.config;

public class Config {
    public enum userAgent {

    }

    private final String userAgent;
    private final long timeout;
    private final long waiting;
    private final int threads;

    public static class ConfigBuilder {
        private final String userAgent;
        private long timeout = 10_000;
        private long waiting = 1000;
        private int threads = Runtime.getRuntime().availableProcessors();

        public ConfigBuilder(String userAgent) {
            this.userAgent = userAgent;
        }

        public ConfigBuilder timeout(long timeout) {
            this.timeout = timeout;
            return this;
        }

        public ConfigBuilder waiting(long waiting) {
            this.waiting = waiting;
            return this;
        }

        public ConfigBuilder threads(int threads) {
            this.threads = threads;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }

        private Config(ConfigBuilder builder) {
            userAgent = builder.userAgent;
            timeout = builder.timeout;
            waiting = builder.waiting;
            threads = builder.threads;
        }

}
