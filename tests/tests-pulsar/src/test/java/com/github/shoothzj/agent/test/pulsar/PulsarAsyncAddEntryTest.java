package com.github.shoothzj.agent.test.pulsar;

import io.github.embedded.pulsar.core.EmbeddedPulsarServer;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.junit.jupiter.api.Test;

class PulsarAsyncAddEntryTest {

    @Test
    void testAsyncAddEntry() throws Exception {
        EmbeddedPulsarServer server = new EmbeddedPulsarServer();
        server.start();
        PulsarClient pulsarClient = PulsarClient.builder()
                .serviceUrl(String.format("pulsar://localhost:%d", server.getTcpPort()))
                .build();
        Producer<byte[]> producer = pulsarClient.newProducer()
                .topic("test")
                .create();
        producer.send("hello".getBytes());
        server.close();
    }

}
