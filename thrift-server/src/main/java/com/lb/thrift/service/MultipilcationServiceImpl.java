package com.lb.thrift.service;

import org.apache.thrift.TException;

public class MultipilcationServiceImpl implements MultiplicationService.Iface{

	@Override
	public int multiply(int n1, int n2) throws TException {
		return n1 * n2;
	}

}
