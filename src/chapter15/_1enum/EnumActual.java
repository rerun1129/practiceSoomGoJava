package chapter15._1enum;

import java.util.Collections;
import java.util.Set;

public enum EnumActual {

    GOOGLE {
        public ClientRegistration.Builder getBuilder(String registrationId) {
            ClientRegistration.Builder builder = getBuilder(registrationId);
            builder.authorizationUri("https://accounts.google.com/o/oauth2/auth");
            builder.tokenUri("https://oauth2.googleapis.com/token");
            builder.userInfoUri("https://openidconnect.googleapis.com/v1/userinfo");
            builder.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs");
            builder.clientName("Google");
            return builder;
        }
    },

    GITHUB {
        public ClientRegistration.Builder getBuilder(String registrationId) {
            ClientRegistration.Builder builder = getBuilder(registrationId);
            builder.scope("read:user");
            builder.authorizationUri("https://github.com/login/oauth/authorize");
            builder.tokenUri("https://github.com/login/oauth/access_token");
            builder.userInfoUri("https://api.github.com/user");
            builder.clientName("GitHub");
            return builder;
        }
    },

    FACEBOOK {
        public ClientRegistration.Builder getBuilder(String registrationId) {
            ClientRegistration.Builder builder = getBuilder(registrationId);
            builder.scope("public_profile", "email");
            builder.authorizationUri("https://www.facebook.com/v3.0/dialog/oauth");
            builder.tokenUri("https://graph.facebook.com/v3.0/oauth/access_token");
            builder.userInfoUri("https://graph.facebook.com/me?fields=id,name,email");
            builder.clientName("Facebook");
            return builder;
        }
    };

    private static final String DEFAULT_REDIRECT_URL = "{baseUrl}/login/oauth2/code/{registrationId}";

}


class ClientRegistration {

    private final String registrationId;
    private final String clientId;
    private final String clientSecret;
    private final String clientName;
    private final String redirectUriTemplate;
    private final Set <String> scopes;
    private final String providerConfigurationMetadata;
    private final String authorizationUri;
    private final String tokenUri;
    private final String jwkSetUri;
    private final String userInfoUri;
    private final String userNameAttributeName;

    private ClientRegistration(Builder builder) {
        this.registrationId = builder.registrationId;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.clientName = builder.clientName;
        this.redirectUriTemplate = builder.redirectUriTemplate;
        this.scopes = Collections.unmodifiableSet ( builder.scopes );
        this.providerConfigurationMetadata = builder.providerConfigurationMetadata;
        this.authorizationUri = builder.authorizationUri;
        this.tokenUri = builder.tokenUri;
        this.jwkSetUri = builder.jwkSetUri;
        this.userInfoUri = builder.userInfoUri;
        this.userNameAttributeName = builder.userNameAttributeName;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getClientName() {
        return clientName;
    }

    public String getRedirectUriTemplate() {
        return redirectUriTemplate;
    }

    public Set<String> getScopes() {
        return scopes;
    }

    public String getProviderConfigurationMetadata() {
        return providerConfigurationMetadata;
    }

    public String getAuthorizationUri() {
        return authorizationUri;
    }

    public String getTokenUri() {
        return tokenUri;
    }

    public String getJwkSetUri() {
        return jwkSetUri;
    }

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public String getUserNameAttributeName() {
        return userNameAttributeName;
    }

    public static class Builder {
        private final String registrationId;
        private String clientId;
        private String clientSecret;
        private String clientName;
        private String redirectUriTemplate;
        private Set<String> scopes;
        private String providerConfigurationMetadata;
        private String authorizationUri;
        private String tokenUri;
        private String jwkSetUri;
        private String userInfoUri;
        private String userNameAttributeName;

        private Builder(String registrationId) {
            this.registrationId = registrationId;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder redirectUriTemplate(String redirectUriTemplate) {
            this.redirectUriTemplate = redirectUriTemplate;
            return this;
        }

        public Builder scope(String... scope) {
            this.scopes = Set.of(scope);
            return this;
        }

        public Builder authorizationUri(String authorizationUri) {
            this.authorizationUri = authorizationUri;
            return this;
        }

        public Builder tokenUri(String tokenUri) {
            this.tokenUri = tokenUri;
            return this;
        }

        public Builder jwkSetUri(String jwkSetUri) {
            this.jwkSetUri = jwkSetUri;
            return this;
        }

        public Builder userInfoUri(String userInfoUri) {
            this.userInfoUri = userInfoUri;
            return this;
        }

        public Builder userNameAttributeName(String userNameAttributeName) {
            this.userNameAttributeName = userNameAttributeName;
            return this;
        }

        public ClientRegistration build() {
            return new ClientRegistration(this);
        }
    }
}