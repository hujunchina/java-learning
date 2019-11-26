package demo03;

import java.io.IOException;

public interface Server {
    public void stop();
    public void start() throws IOException;
    public void register(Class serviceInterfase, Class impl);
    public boolean isRunning();
    public int getPort();
}
