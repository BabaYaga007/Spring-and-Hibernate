package awesome.aopdemo.dao;

import org.springframework.stereotype.Component;

import awesome.aopdemo.Account;

@Component
public class AccountDAO {
	
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean vipFlag) {
				
		System.out.println(getClass() + ": Doing my DB work: Adding an account");
	}

	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()");
		return false;
		
	}

	public String getName() {
		System.out.println(getClass() + ": Doing my DB work: in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": Doing my DB work: in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": Doing my DB work: in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": Doing my DB work: in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	
	
	
	
}
