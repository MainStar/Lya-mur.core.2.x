package lyaMur;

public class Post {

    private String serviceName;
    private String serviceTopick;
    private String serviceInfo;

    public Post(String serviceName, String serviceTopick, String serviceInfo) {
        this.serviceName = serviceName;
        this.serviceTopick = serviceTopick;
        this.serviceInfo = serviceInfo;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
