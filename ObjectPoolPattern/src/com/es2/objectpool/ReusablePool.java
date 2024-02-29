package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReusablePool {
    private static final int DEFAULT_MAX_POOL_SIZE = 10;
    private static ReusablePool instance;
    private final List<HttpURLConnection> pool;
    private final List<HttpURLConnection> inUse;
    private int maxPoolSize;

    private ReusablePool() {
        pool = Collections.synchronizedList(new ArrayList<>());
        inUse = Collections.synchronizedList(new ArrayList<>());
        maxPoolSize = DEFAULT_MAX_POOL_SIZE;
    }

    public static synchronized ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized HttpURLConnection acquire() throws PoolExhaustedException, IOException {
        if (pool.isEmpty()) {
            if (inUse.size() >= maxPoolSize) {
                throw new PoolExhaustedException("Pool is exhausted.");
            }
            HttpURLConnection connection = createConnection();
            inUse.add(connection);
            return connection;
        } else {
            HttpURLConnection connection = pool.remove(0);
            inUse.add(connection);
            return connection;
        }
    }

    private HttpURLConnection createConnection() throws IOException {
        URL url = new URL("http://ipv.pt");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        return connection;
    }

    public synchronized void release(HttpURLConnection connection) throws ObjectNotFoundException {
        if (!inUse.contains(connection)) {
            throw new ObjectNotFoundException("Connection not in use.");
        }
        pool.add(connection);
        inUse.remove(connection);
    }

    public synchronized void resetPool() {
        pool.clear();
        inUse.clear();
    }

    public synchronized void setMaxPoolSize(int size) {
        maxPoolSize = size;
    }
}
