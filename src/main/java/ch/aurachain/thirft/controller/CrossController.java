package ch.aurachain.thirft.controller;

import ch.aurachain.thirft.generated.CrossPlatformResource;
import ch.aurachain.thirft.generated.CrossPlatformService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class CrossController {

    @Autowired
    private TProtocolFactory tProtocolFactory;

    private CrossPlatformService.Iface crossPlatformService;

    @PostConstruct
    public void setUp() throws Exception {
        TTransport transport = new THttpClient("http://localhost:8081/cross");

        TProtocol protocol = tProtocolFactory.getProtocol(transport);

        crossPlatformService = new CrossPlatformService.Client(protocol);
    }

    @GetMapping("/{value}")
    public CrossPlatformResource getValue(@PathVariable("value") String value) throws TException {
        return crossPlatformService.get(Integer.valueOf(value));
    }
}
