package com.lb.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.lb.thrift.service.MultipilcationServiceImpl;
import com.lb.thrift.service.MultiplicationService;

public class ThriftServerApplication {

	public static void main(String[] args) {
		try {
            TServerSocket serverTransport = new TServerSocket(7911);
            TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(serverTransport);
            ttpsArgs.processor(new MultiplicationService.Processor(new MultipilcationServiceImpl()));
            ttpsArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TThreadPoolServer(ttpsArgs);
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
	}

}

