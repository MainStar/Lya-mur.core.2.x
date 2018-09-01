package lyaMur.model;

public class Service {

    private String serviceName;
    private String imageUrl;
    private String serviceTopick;
    private String serviceInfo;

    public Service(String serviceName, String imageUrl, String serviceTopick, String serviceInfo) {
        this.serviceName = serviceName;
        this.imageUrl = imageUrl;
        this.serviceTopick = serviceTopick;
        this.serviceInfo = serviceInfo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getServiceTopick() {
        return serviceTopick;
    }

    public void setServiceTopick(String serviceTopick) {
        this.serviceTopick = serviceTopick;
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo;
    }
}
