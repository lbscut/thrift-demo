package com.lb.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import com.lb.thrift.service.MultiplicationService;

public class ThriftClientApplication {

	public static void main(String[] args) {
		try {
			TTransport transport = new TSocket("localhost", 7911);
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			MultiplicationService.Client client = new MultiplicationService.Client(protocol);
			System.out.println(client.multiply(1, 2));
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

}

