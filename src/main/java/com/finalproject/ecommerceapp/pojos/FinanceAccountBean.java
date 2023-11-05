package com.finalproject.ecommerceapp.pojos;


import java.util.ArrayList;

public class FinanceAccountBean {
	private long financeaccountid;
    private ArrayList<TransactionBean> transactionList;
    private String bankName;
    private String accountNo;
    private float accountbalance=0;
    public FinanceAccountBean(){
        transactionList=new ArrayList<TransactionBean>();
    }

    public long getFinanceaccountid() {
		return financeaccountid;
	}

	public void setFinanceaccountid(long financeaccountid) {
		this.financeaccountid = financeaccountid;
	}

	public ArrayList<TransactionBean> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<TransactionBean> transactionList) {
        this.transactionList = transactionList;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public float getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(float accountbalance) {
        this.accountbalance = accountbalance;
    }
    
    public TransactionBean createAndAddCreditTransaction(){
        TransactionBean transaction=new TransactionBean(TransactionBean.Type.Debit);
        transactionList.add(transaction);
        return transaction;
        
    }
    
     public TransactionBean createAndAddDebitTransaction(){
        TransactionBean transaction=new TransactionBean(TransactionBean.Type.Debit);
        transactionList.add(transaction);
        return transaction;
        
    }
}
