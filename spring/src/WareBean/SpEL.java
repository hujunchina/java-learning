package WareBean;

public class SpEL {
    private String count;
    private String message;
    private String frequency;
    private String capacity;

    public void setCount(String count) {
        this.count = count;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "SpEL{" +
                "count='" + count + '\'' +
                ", message='" + message + '\'' +
                ", frequency='" + frequency + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}
