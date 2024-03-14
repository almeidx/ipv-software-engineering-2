package com.es2.memento;

import java.util.ArrayList;

public class BackupService {
    private Server server;
    private ArrayList<Memento> snapshots;

    public BackupService(Server server) {
        this.server = server;
        snapshots = new ArrayList<>();
    }

    public void takeSnapshot() {
        snapshots.add(server.backup());
    }

    /**
     * Restores a previous state in the Server
     * @param snapshotNumber the snapshot number between 0 and (number of snapshots - 1)
     * @throws NotExistingSnapshotException
     */
    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
        if (snapshotNumber < 0 || snapshotNumber >= snapshots.size()) {
            throw new NotExistingSnapshotException("Snapshot does not exist");
        }
        server.restore(snapshots.get(snapshotNumber));
    }
}
