package org.example.patterns.facade.door;

public class DoorFacade {
    private DoorClose doorClose;
    private DoorLock doorLock;
    private DoorOpen doorOpen;

    public DoorFacade() {
        this.doorClose = new DoorClose();
        this.doorLock = new DoorLock();
        this.doorOpen = new DoorOpen();
    }

    public void open() {
        doorOpen.openDoor();
    }

    public void close() {
        doorClose.closeDoor();
    }

    public void lock() {
        doorLock.lockDoor();
    }
}