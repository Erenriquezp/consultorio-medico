package org.uce.app.model;

public class Usuario {
    private final String username;
    private final String password;
    private final String ci;

    private Usuario(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.ci = builder.ci;
    }

    public static class Builder {
        private String username;
        private String password;
        private String ci;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder ci(String ci) {
            this.ci = ci;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    // Getters (opcional)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCi() {
        return ci;
    }
}
