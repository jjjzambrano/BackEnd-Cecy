package cecy.cecy_backend.cecy_certificados.imagen_certificate;

public class UpdateImageResponse {
    private String message;
    private boolean success;

    // Constructor
    public UpdateImageResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
