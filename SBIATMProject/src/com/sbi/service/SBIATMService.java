package com.sbi.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.sbi.model.Account;

public class SBIATMService {

	private final int PIN_LENGTH=6;
	private final int ACCOUNT_NUMBER_LENGTH=11;
	private Map<Integer, Account> bankAccounts=new LinkedHashMap<Integer, Account>();


	public SBIATMService() {
		bankAccounts.put(921261,new Account(33983167626L, "Nagendra Babu Chavidisetti", "921261", 50000.0));
		bankAccounts.put(921262,new Account(33983167632L, "Naga Jyothi Chavidisetti", "921262", 80000.0));
		bankAccounts.put(921263,new Account(33983167633L, "Shubhash Chavidisetti", "921263", 25000.0));
		bankAccounts.put(921264,new Account(33983167634L, "NagaRaju Rangisetti", "921264", 100000.0));
		bankAccounts.put(921265,new Account(33983167635L, "Sulochana Chavidisetti", "921265", 75000.0));
		bankAccounts.put(921266,new Account(33983167636L, "Venkata Krishna Rao Chavidisetti", "921266", 25000.0));
		bankAccounts.put(921267,new Account(33983167637L, "Bhulakshmi Chavidisetti", "921267", 10000.0));
		bankAccounts.put(921268,new Account(33983167638L, "Gayathri Rangisetti", "921268", 6000.0));
		bankAccounts.put(921269,new Account(33983167639L, "Aadhya Rangisetti", "921269", 3000.0));
	}



	public void  changePinNumber(String atmPinNumber,String updatedPinNumber) {

		Map<Integer, Account> backAccounts= this.bankAccounts;
		try {

			if( atmPinNumber!=null && updatedPinNumber!=null&&  atmPinNumber.length()==PIN_LENGTH) {

				int pinNumber=Integer.parseInt(atmPinNumber);
				int updatedCardPinNumber=Integer.parseInt(updatedPinNumber);

				Account bankAccount=backAccounts.get(pinNumber);
				if(bankAccount==null) {
					throw new IllegalAccessException("Account not found with that Pin number!!!. Please enter Correct Pin Number ");
				}
				bankAccount.setAtmPin(updatedPinNumber);
				backAccounts.put(updatedCardPinNumber, bankAccount);
				System.out.println("Account Pin Number is Updated Successfully!!!");
			}else {

				System.out.println("Sorry!!!, Please Enter the correct Pin Number ");
			}
		}
		catch(NumberFormatException numberFormatException) {
			System.out.println("Invalid Pin format!!.. Please enter Pin Number in Numerical format");
		}catch (IllegalAccessException illegalAccessException) {
			System.out.println(illegalAccessException.getMessage());
		}catch(Exception exception) {
			System.out.println("Unexpected Error!!!. "+exception.getMessage());
		}

	}

	public void depositAmount(double amount,String atmPinNumber,Long accountNumber) {
		Map<Integer, Account> bankAccounts=this.bankAccounts;

		try {

			if(atmPinNumber!=null &&  atmPinNumber.length()==PIN_LENGTH) {

				if(accountNumber!=null && String.valueOf(accountNumber).length() ==ACCOUNT_NUMBER_LENGTH) {
					int pinNumber=Integer.parseInt(atmPinNumber);
					Account bankAccount=bankAccounts.get(pinNumber);
					if(bankAccount==null) {
						throw new IllegalAccessException("Account not found with that Pin number!!!. Please enter Correct Pin Number ");
					}

					if(bankAccount.getAccountNumber()==accountNumber) {

						if(amount<=0) {
							throw new IllegalArgumentException("Amount should not be negative number or zero");
						}
						else {
							double accountBalance=bankAccount.getAccountBalance();
							accountBalance=accountBalance+amount;
							bankAccount.setAccountBalance(accountBalance);
							System.out.println("Amount "+amount+ " after deposited the Available balance "+accountBalance);

						}
					}
					else {
						System.out.println("Invalid Account Number!!, Please enter valid account number ");
					}

				}
				else {
					System.out.println("Invalid Acount Number. Please enter correct Account Number ");
				}
			}
			else {
				System.out.println("Invalid Pin Number!!!. Please enter Valid pin Number");
			}
		}catch (NumberFormatException numberFormatException) {
			System.out.println("Invalid Pin format!!.. Please enter Pin Number in Numerical format");

		}catch(IllegalAccessException illegalAccessException) {
			System.out.println(illegalAccessException.getMessage());
		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}
		catch (Exception exception) {
			System.out.println("Unexpected Error!!!");

		}

	}

	public void withdrawAmount(double amount, String atmPinNumber ) {

		Map<Integer, Account> bankAccounts=this.bankAccounts;

		try {

			if( atmPinNumber!=null && atmPinNumber.length()==PIN_LENGTH) {
				int pinNumber=Integer.parseInt(atmPinNumber);

				Account bankAccount=bankAccounts.get(pinNumber);
				if(bankAccount==null) {
					throw new IllegalAccessException("Account not found with that Pin number!!!. Please enter Correct Pin Number ");
				}

				if(amount <= 0) {
					throw new IllegalArgumentException("Amount should not be negative number or zero");
				} else if(bankAccount.getAccountBalance()<amount) {
					throw new IllegalArgumentException("Insufficient Funds!!!");

				}
				else {
					double availableBalance=bankAccount.getAccountBalance();
					availableBalance=availableBalance-amount;
					bankAccount.setAccountBalance(availableBalance);
					System.out.println(" Amount "+amount+" withdraw from your Account. Available balance is "+availableBalance);
				}
			}
			else {
				System.out.println("Invalid Pin Number!!!. Please enter valid Pin Number.");
			}
		}catch(NumberFormatException numberFormatException) {
			System.out.println("Invalid Pin format!!.. Please enter Pin Number in Numerical format");
		}catch(IllegalAccessException illegalAccessException) {
			System.out.println(illegalAccessException.getMessage());
		}catch(IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
		}

	}

	public double checkBalance(String atmPinNumber) {

		Map<Integer, Account> bankAccounts=this.bankAccounts;
		double availableBalance=0;
		try {

			if(atmPinNumber!=null && atmPinNumber.length()==PIN_LENGTH) {
				int pinNumber=Integer.parseInt(atmPinNumber);

				Account bankAccount=bankAccounts.get(pinNumber);
				if(bankAccount==null) {
					throw new IllegalAccessException("Account not found with that Pin number!!!. Please enter Correct Pin Number ");

				}
				availableBalance=bankAccount.getAccountBalance();

			}
			else {
				System.out.println(" Invalid Pin Number!!!. Please enter valid pin number ");
			}
		}catch(NumberFormatException numberFormatException) {
			System.out.println("Invalid Pin format!!.. Please enter Pin Number in Numerical format");
		}catch(IllegalAccessException illegalAccessException) {
			System.out.println(illegalAccessException.getMessage());
		}

		return availableBalance;
	}

	public void displayAccountDetails(String atmPinNumber) {

		Map<Integer, Account> bankAccounts=this.bankAccounts;
		try {
			if(atmPinNumber!=null && atmPinNumber.length()==PIN_LENGTH) {
				int pinNumber=Integer.parseInt(atmPinNumber);
				Account bankAccount=bankAccounts.get(pinNumber);
				if(bankAccount==null) {
					throw new IllegalAccessException("Account not found with that Pin number!!!. Please enter Correct Pin Number ");

				}
				System.out.println(" Bank Account Number :- "+bankAccount.getAccountNumber());
				System.out.println(" Bank Account Holder Name :- "+bankAccount.getAccountHolderName());
				System.out.println(" Bank Account Pin Number :- "+bankAccount.getAccountNumber());
				System.out.println(" Bank Account Available Balance :- "+bankAccount.getAccountBalance());
			}
			else {
				System.out.println("Invalid Pin Number!!!. Please enter Valid Pin Number ");
			}
		}catch(NumberFormatException numberFormatException) {
			System.out.println("Invalid Pin format!!.. Please enter Pin Number in Numerical format");
		}catch(IllegalAccessException illegalAccessException) {
			System.out.println(illegalAccessException.getMessage());
		}

	}

}

