package com.example.banking.app;

import com.example.banking.domain.AccountStatus;

public class StudyEnum {

	public static void main(String[] args) {
		for (AccountStatus status : AccountStatus.values()) {
			System.out.println(status.name());
			System.out.println(status.ordinal());
			System.out.println(status.getCode());			
		}
	}

}
