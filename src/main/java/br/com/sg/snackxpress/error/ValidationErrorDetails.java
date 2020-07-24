package br.com.sg.snackxpress.error;


public class ValidationErrorDetails extends ErrorDetails {
    private String field;
    private String fieldMessage;

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String field;
        private String fieldMessage;

        private Builder() {
        }


        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }
        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }
        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationDetails = new ValidationErrorDetails();
            validationDetails.setTitle(title);
            validationDetails.setStatus(status);
            validationDetails.setDetail(detail);
            validationDetails.setTimestamp(timestamp);
            validationDetails.setDeveloperMessage(developerMessage);
            validationDetails.setField(field);
            validationDetails.setFieldMessage(fieldMessage);
            return validationDetails;
        }
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }
}
