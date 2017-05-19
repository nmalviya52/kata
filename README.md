# kata
Event Stream Processing

MyEvent.java:  It generates events after every 100ms with random clientID and UUID.

StreamProcess.java: It process request by spawning thread for each event and use corresponding client object for synchronizing events from same client.
