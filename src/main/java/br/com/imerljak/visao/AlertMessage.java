package br.com.imerljak.visao;

import lombok.*;

@Value
@Builder(builderMethodName = "with")
public class AlertMessage {

    @NonNull
    private String message;

    @NonNull
    @Builder.Default
    private Status status = Status.INFO;

    @Getter
    @RequiredArgsConstructor
    public enum Status {

        PRIMARY("alert-primary"),
        SECONDARY("alert-secondary"),
        SUCCESS("alert-success"),
        DANGER("alert-danger"),
        WARNING("alert-warning"),
        INFO("alert-info"),
        LIGHT("alert-light"),
        DARK("alert-dark");

        public final String styleClass;
    }
}
